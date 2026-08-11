package net.likelion.bebc25.board03.post.repository;
// 이 클래스는 게시글 데이터를 데이터베이스(MySQL)의 post2 테이블에 저장하거나 조회하는 Repository입니다.
//board02에서는 List<PostDto>(가짜 데이터)를 사용했지만,
//board03에서는 JdbcTemplate을 이용해 실제 데이터베이스(DB) 와 연결합니다.

// JdbcTemplatePostRepository는 JdbcTemplate을 이용해 MySQL의 post2 테이블과 직접 통신하는 Repository입니다.
// findAll(), findById(), save(), update(), deleteById() 메서드로 게시글 조회·등록·수정·삭제(CRUD) 를 수행하며,
// RowMapper를 사용해 데이터베이스의 각 행(Row)을 PostDto 객체로 변환하여 애플리케이션에서 사용할 수 있도록 합니다.

import net.likelion.bebc25.board03.post.dto.PostDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcTemplatePostRepository implements PostRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplatePostRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<PostDto> postRowMapper = (ResultSet rs, int rowNum) -> {
//        return new PostDto(
//                rs.getInt("id"),
//                rs.getString("title"),
//                rs.getString("content"),
//                rs.getString("author"),
//                rs.getBoolean("secret"),
//                rs.getObject("created_at", LocalDateTime.class));
        return PostDto.builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .author(rs.getString("author"))
                .createdAt(rs.getObject("created_at", LocalDateTime.class))
                .content(rs.getString("content"))
                .secret(rs.getBoolean("secret")).build();
    };

    @Override
    public List<PostDto> findAll() {
        return jdbcTemplate.query("SELECT * FROM post2", postRowMapper);
    }

    @Override
    public PostDto findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM post2 WHERE id = ?", postRowMapper, id);
    }

    @Override
    public void save(PostDto post) {
        jdbcTemplate.update("INSERT INTO post2 (title, author, content) VALUES (?, ?, ?)"
                , post.getTitle()
                , post.getAuthor()
                , post.getContent());
    }

    @Override
    public void update(PostDto post) {
        jdbcTemplate.update("UPDATE post2 SET title = ?, author = ?, content = ? WHERE id = ?"
                , post.getTitle()
                , post.getAuthor()
                , post.getContent()
                , post.getId());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM post2 WHERE id = ?", id);
    }
}
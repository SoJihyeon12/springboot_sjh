package net.likelion.bebc25.board03.post.repository;
// 이 PureJdbcPostRepository는 순수 JDBC(Java Database Connectivity) 를 사용해서 데이터베이스와 직접 통신하는 Repository입니다.
// 즉, JdbcTemplate이 내부적으로 해주는 일을 직접 하나하나 작성한 코드입니다.

// PureJdbcPostRepository는 순수 JDBC API만 사용하여 MySQL과 직접 통신하는 Repository입니다.
// Connection으로 데이터베이스에 연결하고, Statement로 SQL을 실행하며, ResultSet으로 조회 결과를 읽어 PostDto 객체로 변환합니다.
// 이 방식은 JDBC의 동작 원리를 이해하는 데 좋지만, 코드가 길고 자원 관리와 SQL Injection 위험을 개발자가 직접 처리해야 하므로
// 실무에서는 주로 PreparedStatement나 JdbcTemplate을 사용합니다.

import jakarta.validation.Valid;
import net.likelion.bebc25.board03.post.dto.PostDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PureJdbcPostRepository implements PostRepository {

    @Value("${spring.datasource.url}")
    private String url;
//    private String url = "jdbc:mariadb://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public List<PostDto> findAll() {
        String sql = "SELECT id, title, author, secret, created_at AS createdAt FROM post2";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<PostDto> result = new ArrayList<>();

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(url, user, password);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행
            rs = stmt.executeQuery(sql);

            // 4. 결과 처리(ResultSet 사용)
            while(rs.next()){
                PostDto postDto = new PostDto();
                postDto.setId(rs.getInt("id"));
                postDto.setTitle(rs.getString("title"));
                postDto.setAuthor(rs.getString("author"));
                postDto.setCreatedAt(rs.getObject("createdAt", LocalDateTime.class));
                postDto.setSecret(rs.getBoolean("secret"));

                result.add(postDto);
            }

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(rs != null) rs.close(); } catch (Exception e){ }
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }

        return result;
    }

    @Override
    public PostDto findById(int id) {
        String sql = "SELECT id, title, content, author, created_at AS createdAt FROM post2 WHERE id = " + id;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        PostDto postDto = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(url, user, password);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행
            rs = stmt.executeQuery(sql);

            // 4. 결과 처리(ResultSet 사용)
            if(rs.next()){
                postDto = new PostDto();
                postDto.setId(rs.getInt("id"));
                postDto.setTitle(rs.getString("title"));
                postDto.setAuthor(rs.getString("author"));
                postDto.setCreatedAt(rs.getObject("createdAt", LocalDateTime.class));
                postDto.setContent(rs.getString("content"));
            }

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(rs != null) rs.close(); } catch (Exception e){ }
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }

        return postDto;
    }

    @Override
    public void save(PostDto post) {
        String sql = "INSERT INTO post2 (author, title, content) VALUES ('"+post.getAuthor()+"', '"+post.getTitle()+"', '"+post.getContent()+"')";

        Connection conn = null;
        Statement stmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(url, user, password);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행
            int affectedRows = stmt.executeUpdate(sql);

            System.out.println("게시글 등록 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

    @Override
    public void update(PostDto post) {
        String sql = "UPDATE post2 SET title = '"+post.getTitle()+"', author='"+post.getAuthor()+"', content = '"+post.getContent()+"' WHERE id = " + post.getId();

        Connection conn = null;
        Statement stmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(url, user, password);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행
            int affectedRows = stmt.executeUpdate(sql);

            System.out.println("게시글 수정 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM post2 WHERE id=" + id;
        Connection conn = null;
        Statement stmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(url, user, password);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행
            int affectedRows = stmt.executeUpdate(sql);

            System.out.println(id + "번 게시글 삭제 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }
}
package net.likelion.bebc25.board03.post.repository;
// 이 MemoryPostRepository는 데이터베이스를 사용하지 않고 메모리(List)에 게시글을 저장하는 Repository입니다.
//앞에서 설명한 JdbcTemplatePostRepository와 같은 역할을 하지만, MySQL 대신 ArrayList를 사용한다는 차이가 있습니다.
//즉,
//MemoryPostRepository → 메모리(List)에 저장 (프로그램 종료 시 데이터 사라짐)
//JdbcTemplatePostRepository → 데이터베이스(MySQL)에 저장 (프로그램 종료 후에도 데이터 유지)

// MemoryPostRepository는 데이터베이스 대신 ArrayList<PostDto>를 사용하여 게시글을 메모리에 저장하는 Repository입니다.
// findAll(), findById(), save(), update(), deleteById() 메서드를 통해 게시글의 CRUD 기능을 수행하며,
// 프로그램이 실행되는 동안에만 데이터가 유지되고 종료하면 모두 사라지는 특징이 있습니다.

import net.likelion.bebc25.board03.post.dto.PostDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryPostRepository implements PostRepository {

    private final List<PostDto> fakePosts;

    public MemoryPostRepository(){
        fakePosts = new ArrayList<PostDto>();

        PostDto post1 = new PostDto();
        post1.setId(1);
        post1.setTitle("1번 게시글");
        post1.setContent("1번 게시글 내용입니다.");
        post1.setAuthor("하루");
        post1.setSecret(true);
        post1.setCreatedAt(LocalDateTime.now());

        PostDto post2 = new PostDto();
        post2.setId(2);
        post2.setTitle("2번 게시글");
        post2.setContent("2번 게시글 내용입니다.");
        post2.setAuthor("나무");
        post2.setCreatedAt(LocalDateTime.now());

        fakePosts.add(post1);
        fakePosts.add(post2);
    }

    @Override
    public List<PostDto> findAll() {
        return fakePosts;
    }

    @Override
    public PostDto findById(int id) {
        for(PostDto org : fakePosts){
            if(org.getId() == id){
                return org;
            }
        }
        throw new IllegalArgumentException(id + "번 게시글은 존재하지 않습니다.");
    }

    @Override
    public void save(PostDto post) {
        PostDto lastPost = fakePosts.getLast();
        post.setId(lastPost.getId() + 1);
        post.setCreatedAt(LocalDateTime.now());
        fakePosts.add(post);
    }

    @Override
    public void update(PostDto post) {
        PostDto targetPost = null;
        for(PostDto org : fakePosts){
            if(org.getId() == post.getId()){
                targetPost = org;
                break;
            }
        }
        targetPost.setTitle(post.getTitle());
        targetPost.setContent(post.getContent());
        targetPost.setAuthor(post.getAuthor());
    }

    @Override
    public void deleteById(int id) {
        for(PostDto org : fakePosts){
            if(org.getId() == id){
                fakePosts.remove(org);
                break;
            }
        }
    }
}
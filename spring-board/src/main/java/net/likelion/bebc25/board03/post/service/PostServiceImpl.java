package net.likelion.bebc25.board03.post.service;
// 이 PostServiceImpl은 PostService 인터페이스를 실제로 구현한 클래스입니다.
//쉽게 말하면,
//PostService → 설계도(무슨 기능이 있어야 하는지 정의)
//PostServiceImpl → 실제 기능을 수행하는 클래스
//또한 이 클래스는 Controller와 Repository 사이에서 중간 역할을 합니다.

// PostServiceImpl은 PostService 인터페이스를 구현한 실제 서비스 클래스입니다. Controller의 요청을 받아 필요한 업무를 처리하고,
// PostRepository를 통해 데이터베이스에 게시글을 조회·등록·수정·삭제합니다.
// @Qualifier("jdbcTemplatePostRepository")를 사용하여 여러 Repository 구현체 중 JdbcTemplatePostRepository를 선택해 주입받아 사용합니다.

import net.likelion.bebc25.board03.post.dto.PostDto;
import net.likelion.bebc25.board03.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(@Qualifier("jdbcTemplatePostRepository") PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public PostDto getPost(int id) {
        return postRepository.findById(id);
    }

    @Override
    public void writePost(PostDto post) {
        postRepository.save(post);
    }

    @Override
    public void editPost(PostDto post) {
        postRepository.update(post);
    }

    @Override
    public void removePost(int id) {
        postRepository.deleteById(id);
    }
}
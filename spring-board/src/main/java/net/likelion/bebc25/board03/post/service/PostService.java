package net.likelion.bebc25.board03.post.service;
// 이 PostService는 게시글 서비스(Service)의 기능을 정의한 인터페이스입니다.
//앞에서 배운 PostRepository와 매우 비슷하지만 역할이 다릅니다.
//Repository → 데이터베이스(DB)와 직접 통신
//Service → Controller와 Repository 사이에서 비즈니스 로직(업무 처리) 을 담당
//즉,
//"게시글 서비스는 이런 기능들을 반드시 제공해야 한다." 라는 규칙을 만든 인터페이스입니다.

// PostService는 게시글 서비스가 반드시 제공해야 하는 기능(목록 조회, 상세 조회, 등록, 수정, 삭제)을 정의한 인터페이스입니다.
// 실제 구현은 PostServiceImpl 같은 구현 클래스에서 작성하며, Controller와 Repository 사이에서 비즈니스 로직을 처리하는 역할을 담당합니다.

import net.likelion.bebc25.board03.post.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getPosts();
    PostDto getPost(int id);
    void writePost(PostDto post);
    void editPost(PostDto post);
    void removePost(int id);
}
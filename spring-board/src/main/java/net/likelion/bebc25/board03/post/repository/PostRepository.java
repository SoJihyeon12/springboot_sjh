package net.likelion.bebc25.board03.post.repository;
// 이 PostRepository는 게시글 저장소(Repository)의 기능을 정의한 인터페이스입니다.
//쉽게 말하면,
//"Repository는 이런 기능들을 반드시 가지고 있어야 한다." 라는 규칙(설계도)을 만든 것입니다.
//실제로 데이터를 저장하는 코드는 없고, 메서드의 이름과 형태만 정의되어 있습니다.

// PostRepository는 게시글 저장소가 반드시 제공해야 하는 기능(조회, 등록, 수정, 삭제)을 정의한 인터페이스입니다.
// 실제 동작은 없고 메서드의 이름과 형태만 정의하며, MemoryPostRepository와 JdbcTemplatePostRepository 같은 구현 클래스가 이 규칙을 따라 실제 기능을 구현합니다.

import net.likelion.bebc25.board03.post.dto.PostDto;

import java.util.List;

public interface PostRepository {
    List<PostDto> findAll();
    PostDto findById(int id);
    void save(PostDto post);
    void update(PostDto post);
    void deleteById(int id);
}
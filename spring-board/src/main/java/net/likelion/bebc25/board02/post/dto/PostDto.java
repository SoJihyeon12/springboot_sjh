package net.likelion.bebc25.board02.post.dto;
// 이 PostDto는 게시글 하나를 저장하는 DTO(Data Transfer Object) 입니다.
//board01의 PostDto와 거의 같지만, Validation(입력값 검증) 과 비밀글(secret) 기능이 추가되었습니다.

// 이 PostDto는 게시글 하나를 저장하는 데이터 객체이며, 게시글 번호(id), 제목(title), 내용(content), 작성자(author), 비밀글 여부(secret), 작성일(createdAt) 을 저장합니다.
// 또한 @NotBlank와 @Size를 이용해 제목, 내용, 작성자의 입력값이 올바른지 자동으로 검증할 수 있도록 만든 DTO입니다.

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

// 게시글 하나를 저장할 객체
public class PostDto { // PostDto라는 클래스를 선언합니다. Post → 게시글, DTO(Data Transfer Object) → 데이터를 담아 전달하는 객체, 즉, 게시글 정보를 저장하고 Controller와 View 사이에서 전달하는 객체입니다.
    private int id; // 필드(멤버 변수), 게시글 번호를 저장합니다.

    @NotBlank(message = "제목은 필수 입력 항목입니다.")
    @Size(max = 100, message = "제목은 100자 이하로 입력해야 합니다.")
    private String title;

    @NotBlank(message = "내용은 필수 입력 항목입니다.")
    private String content;

    @NotBlank(message = "작성자는 필수 입력 항목입니다.")
    @Size(min = 2, max = 10, message = "작성자 이름은 2자 이상 10자 이하여야 합니다.")
    private String author;

    private boolean secret;
    private LocalDateTime createdAt;

    public PostDto(){}

    public PostDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public PostDto(int id, String title, String content, String author, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) { // Setter : 값을 변경하는 메서드
        this.secret = secret;
    }

    public int getId() { // Getter: 값을 꺼내는 메서드
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
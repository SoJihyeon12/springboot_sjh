package net.likelion.bebc25.board01.post.dto;
// 이 PostDto 클래스는 게시글 1개를 저장하는 객체(데이터 묶음) 입니다.
// 쉽게 말하면 게시판의 게시글 하나를 자바 객체로 표현한 것입니다.
// 이 PostDto는 게시글 하나의 데이터를 담는 바구니라고 생각하면 이해하기 쉽습니다.
// BoardController에서는 이 객체를 여러 개 만들어 List<PostDto>에 저장합니다.
// 즉, PostDto는 게시글 1개를 표현하는 객체이고, List<PostDto>는 여러 개의 게시글을 저장하는 목록입니다.

import java.time.LocalDateTime;

// 게시글 하나를 저장할 객체
public class PostDto { // PostDto라는 클래스를 선언한 것입니다. Post → 게시글, DTO → Data Transfer Object(데이터 전달 객체) 즉, 게시글 데이터를 담아서 전달하기 위한 객체입니다.
    // 필드(멤버 변수):게시글이 가져야 하는 정보를 저장하는 변수들입니다.
    private int id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public PostDto(){} // 기본 생성자, 아무 값 없이(null) 객체를 생성할 수 있게 합니다.

    // 생성자(제목, 내용, 작성자), 객체를 만들면서 제목, 내용, 작성자를 한번에 저장합니다.
    public PostDto(String title, String content, String author) {
        this.title = title; // 왼쪽의 this.title이란? 객체 안의 변수, 오른쪽 title은 매개변수, 객체의 title = 전달받은 title이라는 뜻
        this.content = content;
        this.author = author;
    }

    // 모든 값을 받는 생성자, 이번에는 모든 값을 한 번에 저장합니다.
    public PostDto(int id, String title, String content, String author, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }

    public int getId() { // Getter, 얘의 역할은 (id값을) 꺼내주는 메서드입니다.
        return id;
    }

    public void setId(int id) { // Setter, 역할은 (id값을) 변경하는 메서드입니다.
        this.id = id;
    }

    public String getTitle() { // Getter 꺼내주는 메서드입니다.
        return title;
    }

    public void setTitle(String title) { // Setter 변경하는 메서드입니다.
        this.title = title;
    }

    public String getContent() { // Getter 꺼내주는 메서드입니다.
        return content;
    }

    public void setContent(String content) { // Setter 변경하는 메서드입니다.
        this.content = content;
    }

    public String getAuthor() { // Getter 꺼내주는 메서드입니다.
        return author;
    }

    public void setAuthor(String author) { // Setter 변경하는 메서드입니다.
        this.author = author;
    }

    public LocalDateTime getCreatedAt() { // Getter 꺼내주는 메서드입니다.
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) { // Setter 변경하는 메서드입니다.
        this.createdAt = createdAt;
    }

    @Override
    public String toString() { // 객체를 문자열로 출력할 때 사용하는 메서드입니다.
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
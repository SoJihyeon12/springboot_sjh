package net.likelion.bebc25.board03.post.dto;
// 이 PostDto는 board02의 PostDto를 더 간결하게 개선한 버전입니다.
//가장 큰 차이점은 Lombok을 사용해서 생성자, Getter, Setter, toString() 등을 직접 작성하지 않아도 된다는 것입니다.

// 이 PostDto는 게시글 하나의 데이터를 저장하는 DTO이며, Validation으로 입력값을 검증하고,
// Lombok을 이용해 생성자·Getter·Setter·toString()을 자동 생성하며, @Builder를 통해 객체를 더 쉽고 가독성 있게 생성할 수 있도록 만든 클래스입니다.

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// 게시글 하나를 저장할 객체
public class PostDto {
    private int id;

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

}
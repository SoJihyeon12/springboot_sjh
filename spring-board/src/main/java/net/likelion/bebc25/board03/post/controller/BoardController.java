package net.likelion.bebc25.board03.post.controller;
// 이 BoardController는 board03의 컨트롤러입니다.
//board02와 비교했을 때 가장 큰 변화는 비즈니스 로직을 PostService로 분리했다는 점입니다.
//즉,
//board02 : Controller가 데이터 처리까지 담당
//board03 : Controller는 요청만 받고, 실제 처리는 Service에게 맡김
//이것이 Spring의 MVC(Model-View-Controller) 구조에 더 가까운 설계입니다.

// board03는 다음과 같이 역할이 분리됩니다.
// Controller → 요청을 받음
// Service → 실제 작업 수행
// DTO → 데이터 저장

// BoardController는 사용자의 요청을 받아 필요한 데이터를 PostService에 요청하고,
// 결과를 Model에 담아 View(Thymeleaf)로 전달하는 역할만 담당합니다.
// 게시글 조회·등록·수정·삭제와 같은 실제 비즈니스 로직은 모두 PostService가 처리하도록 분리한 것이 board03의 가장 큰 특징입니다.

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import net.likelion.bebc25.board03.post.dto.PostDto;
import net.likelion.bebc25.board03.post.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/03/board")
public class BoardController {

    private final PostService postService;

    public BoardController(PostService postService){
        this.postService = postService;
    }

    // 게시글 목록 조회하는 컨트롤러
    @GetMapping("/list.html")
    public String getBoardList(Model model){
        // 게시글 목록 조회(데이터)
        List<PostDto> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "board/list";
    }

    // 게시글 상세 조회하는 컨트롤러
    @GetMapping("/detail.html")
    public String getDetail(@RequestParam("id") int id, Model model){
        PostDto post = postService.getPost(id);
        model.addAttribute("post", post);
        return "board/detail"; // 템플릿 파일 경로
    }

    // 게시글 등록 화면을 요청하는 컨트롤러
    @GetMapping("/write.html")
    public String getWriteForm(@ModelAttribute("postForm") PostDto post){ // 모델에 자동으로 주입까지 됨(postDto 이름으로)
        return "board/write";
    }

    // 게시글 수정 화면을 요청하는 컨트롤러
    @GetMapping("/edit.html")
    public String getEditForm(@RequestParam("id") int id, Model model){
        PostDto post = postService.getPost(id);
        model.addAttribute("postForm", post);
        return "board/write";
    }

    // 게시글 등록 요청을 처리하는 컨트롤러
    @PostMapping("/write")
    public String writePost(@Valid @ModelAttribute("postForm") PostDto post, // Validation 검증 대상 객체
                            BindingResult bindingResult){ // Validation 검증 결과 저장 객체(대상 객체 뒤에 기술해야 함)
        if(bindingResult.hasErrors()){ // 검증에 실패했을 경우
            return "board/write"; // 작성중이던 페이지로 다시 보낸다.
        }
        postService.writePost(post);
        return "redirect:list.html"; // 브라우저에 list.html로 재요청하라고 응답
    }

    // 게시글 수정 요청을 처리하는 컨트롤러
    @PostMapping("/edit")
    public String editPost(@Valid @ModelAttribute("postForm") PostDto post,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "board/write";
        }
        postService.editPost(post);
        return "redirect:detail.html?id=" + post.getId();
    }

    // 게시글 삭제 요청을 처리하는 컨트롤러
    @PostMapping("/delete")
    public String deletePost(@RequestParam int id){
        postService.removePost(id);
        return "redirect:list.html";
    }
}
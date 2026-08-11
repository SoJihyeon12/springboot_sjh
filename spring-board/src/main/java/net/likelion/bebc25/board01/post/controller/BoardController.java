package net.likelion.bebc25.board01.post.controller;
//이 코드는 Spring Boot로 게시판을 직접 구현하는 첫 단계입니다.
// 아직 데이터베이스(DB)를 사용하지 않고, 가짜 데이터(fakePosts)를 메모리에 저장하여
// 게시글 목록, 상세조회, 등록, 수정 화면 등을 직접 HTML 문자열로 만들어 브라우저에 보내는 예제입니다.

//이 코드는 Spring MVC의 기본 흐름(Controller → 데이터 처리 → View 반환)을 배우기 위한 예제입니다. 아직 DB나 Thymeleaf를 사용하지 않고,
// fakePosts라는 메모리 리스트를 데이터 저장소로 사용하며, HTML도 문자열로 직접 만들어 응답하는 구조입니다.
// 이후 학습에서는 이 구조가 Controller → Service → Repository → Database로 발전하고, HTML도 Thymeleaf 같은 템플릿 엔진으로 분리되는 형태로 확장됩니다.

import lombok.extern.slf4j.Slf4j;
import net.likelion.bebc25.board01.post.dto.PostDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller // Spring에게 "이 클래스는 웹 요청(URL)을 처리하는 컨트롤러입니다."라고 알려주는 어노테이션입니다.
@Slf4j // log.debug("출력");처럼 로그를 출력할 수 있습니다.
public class BoardController {

    private final List<PostDto> fakePosts; // 게시글 저장소, 여기서 가장 중요한 변수입니다. 게시글들을 저장하는 리스트입니다. 하지만 DB가 아니라 메모리에 저장합니다. fakePosts → 변수(변수명), List<Post> → 변수의 자료형(타입)

    public BoardController(){ // 생성자
        fakePosts = new ArrayList<PostDto>(); // 빈 리스트 생성 현재 [] 상태

        // 첫 번째 게시글 생성
        PostDto post1 = new PostDto(); // 객체 생성
        post1.setId(1); // 번호
        post1.setTitle("1번 게시글"); // 제목
        post1.setContent("1번 게시글 내용입니다."); //내용
        post1.setAuthor("하루"); // 작성자
        post1.setCreatedAt(LocalDateTime.now()); //작성일

        // 두 번째 게시글 생성
        PostDto post2 = new PostDto();
        post2.setId(2);
        post2.setTitle("2번 게시글");
        post2.setContent("2번 게시글 내용입니다.");
        post2.setAuthor("나무");
        post2.setCreatedAt(LocalDateTime.now());

        //리스트에 저장
        fakePosts.add(post1);
        fakePosts.add(post2);
    }

    // 모든 게시글 목록을 반환한다. 게시글 목록 가져오기, 실제로는 fakePosts를 그대로 돌려줍니다.
    public List<PostDto> getPosts(){
        List<PostDto> list = fakePosts;
        return list;
    }

    // index.html 요청을 처리하는 컨트롤러
    @RequestMapping(value = "/index", method= RequestMethod.GET) // @RequestMapping(...)으로 URL 요청을 처리합니다. 브라우저에서 /index 요청하면 실행됩니다.
    @ResponseBody
    public String getIndex(){
        // Java의 텍스트 블록(Text Block) 문법입니다. 긴 HTML을 문자열로 작성할 수 있습니다.
        String result = """ 
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                  <meta charset="UTF-8">
                  <title>스프링 부트 게시판 데모 홈</title>
                  <link rel="stylesheet" href="/board/css/common.css">
                  <link rel="stylesheet" href="/board/css/index.css">
                </head>
                <body>
                  <div class="container">
                    <div class="welcome-card">
                      <h1>스프링 부트 게시판 v.02</h1>
                      <p>스프링 부트 게시판에 오신걸 환영합니다.</p>
                      <p><a href="/01/board/list.html">01 - Controller에서 HTML 하드코딩</a></p>
                      <p>현재 시간은 %s 입니다.</p>
                      <div>
                        <a href="board/list.html" class="btn-lg">게시글 목록으로 이동</a>
                      </div>
                    </div>
                  </div>
                </body>
                </html>
                """;

        result = result.formatted(LocalDateTime.now()); // 현재시간 출력

        return result;
    }

    // 게시글 목록 조회하는 컨트롤러
    @GetMapping("/01/board/list.html")
    @ResponseBody
    public String getBoardList(){
        // 게시글 목록 조회(데이터)
        List<PostDto> posts = getPosts();

        // View(html)
        String result = """
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                  <meta charset="UTF-8">
                  <title>스프링 게시판 - 목록</title>
                  <link rel="stylesheet" href="/board/css/common.css">
                  <link rel="stylesheet" href="/board/css/list.css">
                </head>
                <body>
                  <div class="container">
                    <h1>게시글 목록</h1>
                    <div class="nav">
                      <a href="list.html">목록으로</a>
                      <a href="write.html">새 글 쓰기</a>
                    </div>
                
                    <table>
                      <thead>
                        <tr>
                          <th>번호</th>
                          <th>제목</th>
                          <th>작성자</th>
                          <th>작성일시</th>
                          <th>작업</th>
                        </tr>
                      </thead>
                      <tbody>
                """;

        // 반복문, 게시글 개수만큼 반복합니다. 게시글이 2개라면 첫번째 글 출력, 두번째 글 출력됩니다.
        for(PostDto post : posts){
            result += """
                    <tr>
                      <td>%s</td>
                      <td>
                        <a href="detail.html?id=%s">%s</a>
                      </td>
                      <td>%s</td>
                      <td>%s</td>
                      <td>
                        <a href="list.html" class="btn btn-danger">삭제</a>
                      </td>
                    </tr>
                    """.formatted( // HTML 안의 %s를 번호, 제목, 작성자, 작성시간으로 바꾸어넣는다. 그래서 그 데이터가 화면에 출력됨
                    post.getId(),
                    post.getId(),
                    post.getTitle(),
                    post.getAuthor(),
                    post.getCreatedAt()
            );
        }


        result += """   
                      </tbody>
                    </table>
                  </div>
                </body>
                </html>
                
                """;

        return result;
    }

    // 게시글 상세 조회하는 컨트롤러
    @GetMapping("/01/board/detail.html")
    @ResponseBody
    public String getDetail(@RequestParam("id") int id){
        PostDto post = getPosts().get(id-1); // <- id=1이라면 리스트에서 0번째 게시글을 가져옵니다. 왜 id-1나면 리스트는 0부터 시작하기 때문이다.
        String result = """
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                  <meta charset="UTF-8">
                  <title>스프링 게시판 - 상세 보기</title>
                  <link rel="stylesheet" href="/board/css/common.css">
                  <link rel="stylesheet" href="/board/css/detail.css">
                </head>
                <body>
                  <div class="container">
                    <h1>게시글 상세 정보</h1>
                    <div class="nav">
                      <a href="list.html">목록으로</a>
                      <a href="write.html">새 글 쓰기</a>
                    </div>
                
                    <table style="margin-bottom: 20px;">
                      <tr>
                        <th style="width: 60px;">번호</th>
                        <td>%s</td>
                      </tr>
                      <tr>
                        <th>제목</th>
                        <td>%s</td>
                      </tr>
                      <tr>
                        <th>작성자</th>
                        <td>%s</td>
                      </tr>
                      <tr>
                        <th>작성일시</th>
                        <td>%s</td>
                      </tr>
                      <tr>
                        <th>내용</th>
                        <td style="white-space: pre-wrap;">%s</td>
                      </tr>
                    </table>
                
                    <div>
                      <a href="edit.html" class="btn">수정하기</a>
                      <a href="list.html" class="btn btn-secondary">목록으로</a>
                    </div>
                  </div>
                </body>
                </html>
                
                """.formatted( // HTML 안의 %s를 번호, 제목, 작성자, 작성시간으로 바꾸어넣는다. 그래서 그 데이터가 화면에 출력됨
                post.getId(),
                post.getTitle(),
                post.getAuthor(),
                post.getCreatedAt(),
                post.getContent()
        );

        return result;
    }

    // 게시글 등록 화면을 요청하는 컨트롤러
    @GetMapping("/01/board/write.html") // 글쓰기 폼을 보여줍니다. 제목, 작성자, 내용, 등록버튼이 있는 html을 그대로 반환한다. 아직 db에는 저장하지 않습니다.
    @ResponseBody
    public String getWriteForm(){
        String result = """
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                  <meta charset="UTF-8">
                  <title>스프링 게시판 - 새 글 쓰기</title>
                  <link rel="stylesheet" href="/board/css/common.css">
                  <link rel="stylesheet" href="/board/css/write.css">
                </head>
                <body>
                  <div class="container">
                    <h1>게시글 등록</h1>
                    <div class="nav">
                      <a href="list.html">목록으로</a>
                      <a href="write.html">새 글 쓰기</a>
                    </div>
                
                    <form action="write" method="POST">
                      <div class="form-group">
                        <label for="title">제목</label>
                        <input type="text" id="title" name="title" placeholder="제목을 입력하세요" required>
                      </div>
                
                      <div class="form-group">
                        <label for="author">작성자</label>
                        <input type="text" id="author" name="author" placeholder="작성자 이름을 입력하세요" required>
                      </div>
                
                      <div class="form-group">
                        <label for="content">내용</label>
                        <textarea id="content" name="content" rows="10" placeholder="내용을 입력하세요" required></textarea>
                      </div>
                
                      <div style="margin-top: 20px;">
                        <button type="submit" class="btn">등록</button>
                        <a href="list.html" class="btn btn-secondary">취소</a>
                      </div>
                    </form>
                  </div>
                </body>
                </html>
                
                """;

        return result;
    }

    // 게시글 수정 화면을 요청하는 컨트롤러
    @GetMapping("/01/board/edit.html") // 수정 폼을 보여주는 메서드입니다. 현재는 예시 데이터를 하드코딩하여 화면에 표시합니다.
    @ResponseBody
    public String getEditForm(){
        String result = """
               <!DOCTYPE html>
               <html lang="ko">
               <head>
                 <meta charset="UTF-8">
                 <title>스프링 게시판 - 글 수정하기</title>
                 <link rel="stylesheet" href="/board/css/common.css">
                 <link rel="stylesheet" href="/board/css/write.css">
               </head>
               <body>
                 <div class="container">
                   <h1>게시글 수정</h1>
                   <div class="nav">
                     <a href="list.html">목록으로</a>
                     <a href="write.html">새 글 쓰기</a>
                   </div>
        
                   <form action="edit" method="POST">
                     <input type="hidden" name="id" value="1">
        
                     <div class="form-group">
                       <label for="title">제목</label>
                       <input type="text" id="title" name="title" value="세 번째 게시글 제목 샘플" required>
                     </div>
        
                     <div class="form-group">
                       <label for="author">작성자</label>
                       <input type="text" id="author" name="author" value="작성자3" required>
                     </div>
        
                     <div class="form-group">
                       <label for="content">내용</label>
                       <textarea id="content" name="content" rows="10" required>이것은 정적으로 추가된 세 번째 게시글의 상세 예시 본문입니다.
               스프링 MVC와 아키텍처 학습을 위해 모의 데이터를 채워두었습니다.</textarea>
                     </div>
        
                     <div style="margin-top: 20px;">
                       <button type="submit" class="btn">수정</button>
                       <a href="detail.html" class="btn btn-secondary">취소</a>
                     </div>
                   </form>
                 </div>
               </body>
               </html>
                
               """;

        return result;
    }


    // 게시글 등록 요청을 처리하는 컨트롤러
    @PostMapping("/01/board/write")
    public String writePost(@RequestParam("title") String title, // @RequestParam("title"): <input name="title">의 값을 받아옵니다.
                            @RequestParam("content") String content, // 내용 값을 받아온다.
                            @RequestParam("author") String author){ // 작성자 값을 받아온다.

        PostDto post = new PostDto(title, content, author); // 새 게시글 객체를 만듭니다.
        log.debug(post.toString()); //콘솔에 PostDto(...)를 출력합니다.

        savePost(post); //저장, 리스트에 추가합니다.

        return "redirect:list.html"; // 브라우저에 list.html로 재요청하라고 응답, 그러면 등록 후 목록 화면으로 이동합니다.
    }

    // 게시글을 등록한다.
    public void savePost(PostDto post){
        PostDto lastPost = getPosts().getLast(); //마지막 게시글을 가져옵니다.
        post.setId(lastPost.getId() + 1);
        post.setCreatedAt(LocalDateTime.now());
        fakePosts.add(post);
    }

    // 게시글 수정 요청을 처리하는 컨트롤러
    @PostMapping("/01/board/edit") // 수정 버튼을 누르면 실행됩니다.
    public String editPost(@ModelAttribute PostDto post){
        log.debug(post.toString());
        updatePost(post);
        return "redirect:detail.html";
    }

    // 게시글을 수정한다.
    public void updatePost(PostDto post){
        PostDto targetPost = null;
        for(PostDto org : getPosts()){
            if(org.getId() == post.getId()){
                targetPost = org;
                break;
            }
        }

        targetPost.setTitle(post.getTitle());
        targetPost.setContent(post.getContent());
        targetPost.setAuthor(post.getAuthor());
    }

    // 게시글 삭제 요청을 처리하는 컨트롤러
    @PostMapping("/01/board/delete")
    public String deletePost(){
        return "삭제 완료 후 보여줄 페이지";
    }

}
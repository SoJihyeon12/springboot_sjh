package net.likelion.bebc25.board02.exception;
// 이 코드는 프로젝트 전체에서 발생하는 특정 예외(Exception)를 한 곳에서 처리하는 클래스입니다.
// 쉽게 말하면, 프로그램에서 에러가 발생했을 때 대신 처리해 주는 관리자입니다.

// 이 클래스는 프로젝트 전체에서 발생하는 IllegalArgumentException을 한 곳에서 처리하는 전역 예외 처리기입니다.
// 예외가 발생하면 오류 메시지를 Model에 담아 templates/error/400.html 페이지를 사용자에게 보여주는 역할을 합니다.

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error/400"; // templates/error/400.html 뷰 페이지를 렌더링
    }
}
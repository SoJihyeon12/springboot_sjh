package net.likelion.bebc25.board03.exception;
// 이 코드는 board02의 GlobalExceptionHandler와 동일한 역할을 합니다.
//즉, board03 프로젝트 전체에서 발생하는 예외를 한 곳에서 처리하는 전역 예외 처리 클래스입니다.

// 이 클래스는 프로젝트 전체에서 발생하는 IllegalArgumentException을 한 곳에서 처리하는 전역 예외 처리기입니다.
// 예외가 발생하면 ex.getMessage()로 오류 메시지를 가져와 Model에 담고, templates/error/400.html 페이지를 사용자에게 보여주는 역할을 합니다.

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
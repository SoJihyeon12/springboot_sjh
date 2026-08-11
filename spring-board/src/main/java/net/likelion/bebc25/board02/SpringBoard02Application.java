package net.likelion.bebc25.board02;
// 이 코드는 Spring Boot 프로젝트(board02)의 시작점(Entry Point) 입니다.
// 프로그램을 실행하면 가장 먼저 실행되는 클래스이며, Spring Boot를 시작하고 웹 서버(Tomcat)를 실행하는 역할을 합니다.

// SpringBoard02Application은 Spring Boot 프로젝트의 시작점이며,
// SpringApplication.run(SpringBoard02Application.class, args); 한 줄이
// Spring 컨테이너 생성 → Bean 등록 → 내장 Tomcat 실행 → 웹 서버 시작 → 사용자 요청 대기까지 모두 수행하는 핵심 코드입니다.


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoard02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoard02Application.class, args);
    }

}
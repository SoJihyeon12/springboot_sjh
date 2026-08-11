package net.likelion.bebc25.board01;
// Spring Boot 애플리케이션의 시작점(Entry Point) 입니다.
//쉽게 말하면,
//프로그램을 실행하면 가장 먼저 실행되는 클래스입니다.
// SpringApplication.run(SpringBoard01Application.class, args); 이 한줄이 Spring 컨테이너 생성 → Bean 등록 → 내장 Tomcat 실행 → 웹 서버 시작까지 모두 수행하는 핵심 코드입니다.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoard01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoard01Application.class, args);
    }

}

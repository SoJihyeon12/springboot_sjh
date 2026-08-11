package net.likelion.bebc25.board03;
// 이 클래스는 Spring Boot 프로젝트의 시작점(메인 클래스) 입니다.
//프로그램을 실행하면 가장 먼저 실행되는 클래스이며, Spring Boot를 시작하고 필요한 객체(Bean)를 생성하고, 내장 Tomcat 서버를 실행하는 역할을 합니다.

// SpringBoard03Application은 Spring Boot 프로젝트의 시작점(메인 클래스) 으로,
//main() 메서드에서 SpringApplication.run()을 호출하여 Spring 컨테이너를 생성하고, Bean을 등록하며, 의존성 주입과 자동 설정을 수행한 뒤
// 내장 Tomcat 서버를 실행하여 웹 애플리케이션이 요청을 받을 수 있도록 준비하는 역할을 합니다.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoard03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoard03Application.class, args);
    }

}
package net.likelion.bebc25.initializr;
// 이 코드는 Spring Boot 프로젝트의 시작점(Entry Point) 입니다.
// 지금까지 배운 일반 Spring에서는 직접 스프링 컨테이너를 생성했습니다.
//
// 하지만 Spring Boot에서는 이런 작업을 자동으로 해줍니다.
// 즉, 이 클래스의 역할은
// Spring Boot를 실행하고, 스프링 컨테이너를 생성하여 애플리케이션을 시작하는 것입니다.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootInitializrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInitializrApplication.class, args);
	}

}

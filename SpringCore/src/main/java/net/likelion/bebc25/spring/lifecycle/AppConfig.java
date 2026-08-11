package net.likelion.bebc25.spring.lifecycle;
// 이 코드는 Spring의 생명주기(Lifecycle) 예제에서 사용하는 설정 클래스(AppConfig) 입니다.
//코드는 매우 짧지만, 스프링 컨테이너를 어떻게 설정할 것인지를 알려주는 중요한 역할을 합니다.
// 이 클래스는 스프링 컨테이너가 어떤 방식으로 Bean을 찾고 관리할지 설정하는 역할을 합니다.

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

}

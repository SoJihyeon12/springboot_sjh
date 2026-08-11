package net.likelion.bebc25.spring.componentscan;
// 이 코드는 Spring의 설정 클래스(AppConfig) 입니다.
//이전의 정적 프록시(Static Proxy) 에서는 @Bean을 사용하여 Driver, Car, LogProxy를 직접 등록했습니다.
//하지만 지금은 컴포넌트 스캔(Component Scan) 을 사용하기 때문에 @Bean 메서드가 하나도 없습니다. 대신 스프링이 자동으로 객체를 찾아서 Bean으로 등록합니다.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 스프링 컨테이너에 알려주는 앱 설정 클래스
@Configuration // 설정(Configuration) 클래스
@EnableAspectJAutoProxy // 스프링 컨테이너에 @Aspect 어노테이션이 붙은 빈들을 찾아서 프록시 처리를 하도록 지시, Spring AOP를 사용하겠습니다.라는뜻
@ComponentScan // 현재 패키지부터 아래 패키지까지 전부 검색하라.라는 뜻
public class AppConfig { // 안에 아무것도 없습니다. 왜냐하면 @ComponentScan이 자동으로 Bean을 등록하기 때문

}

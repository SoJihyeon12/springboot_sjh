package net.likelion.bebc25.spring.aop.springaop;
// 이 코드는 스프링 AOP(Spring AOP)를 사용하기 위한 설정 클래스입니다.
//이전의 동적 프록시(Dynamic Proxy) 예제에서는 Proxy.newProxyInstance()를 직접 사용해서 프록시를 만들었습니다.
//이번에는 스프링이 자동으로 프록시를 만들어 줍니다. 이것이 가장 큰 차이입니다.

// 즉, 동적 프록시에서는 개발자가 프록시를 직접 만들었지만,
// Spring AOP에서는 @EnableAspectJAutoProxy와 @Aspect만 사용하면
// 스프링이 프록시 생성과 메서드 가로채기를 모두 자동으로 처리해 주는 것이 가장 큰 차이점입니다.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 스프링 컨테이너에 알려주는 앱 설정 클래스
@Configuration
@EnableAspectJAutoProxy // 스프링 컨테이너에 @Aspect 어노테이션이 붙은 빈들을 찾아서 프록시 처리를 하도록 지시
public class AppConfig {
    @Bean // 이 메서드가 반환하는 객체가 스프링 빈으로 등록됨 (메서드명인 car가 빈의 이름이 됨)
    public Car car(){ // DI(의존성 주입)
        return new GasolineCar();
//        return new HybridCar();
    }

    @Bean
    public Driver driver(Car car){
        return new Driver(car); // DI
    }

    @Bean
    public LoggingAspect loggingAspect(){ // LoggingAspect을 스프링 빈으로 등록함
        return new LoggingAspect();
    }
}

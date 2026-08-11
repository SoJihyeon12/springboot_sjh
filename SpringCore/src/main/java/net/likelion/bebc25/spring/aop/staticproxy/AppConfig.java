package net.likelion.bebc25.spring.aop.staticproxy;
// 이 코드는 정적 프록시(Static Proxy) 를 사용하는 스프링 설정 클래스입니다.
//이전의 동적 프록시(Dynamic Proxy) 와 Spring AOP와 비교하면 가장 큰 차이점은 프록시 객체(LogProxy)를 개발자가 직접 생성한다는 것입니다.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 컨테이너에 알려주는 앱 설정 클래스
@Configuration // 이 클래스가 스프링 설정 클래스라는 의미입니다. "스프링아, 이 클래스 안에 있는 설정을 읽어서 객체(Bean)를 만들어 줘."라는 뜻
public class AppConfig {
    @Bean // 메서드가 반환하는 객체를 스프링 빈으로 등록 (메서드명인 car가 빈의 이름이 됨)
    public Car car(){
//        Car target = new GasolineCar();
        Car target = new HybridCar(); // 실제 객체(Target) 생성
        Car logProxy = new LogProxy(target); // 프록시 객체 생성
        return logProxy;
    }

    @Bean
    public Driver driver(Car car){
        return new Driver(car); // DI
    }
}

package net.likelion.bebc25.spring.di.setter;
// 이 코드는 Setter Injection(세터 주입) 을 사용하는 스프링 설정 클래스(AppConfig) 입니다.
//이전의 생성자 주입(Constructor Injection) 과 가장 큰 차이점은
//생성자 주입: 객체를 만들면서 의존성을 전달
//세터 주입: 객체를 먼저 만들고, 나중에 Setter 메서드로 의존성을 전달
//이라는 점입니다.

// 즉, 이 AppConfig는 Setter Injection을 사용하여 객체를 먼저 생성한 뒤
// setCar() 메서드를 통해 의존성을 주입하는 스프링 설정 클래스입니다.
// 생성자 주입과 달리 객체 생성과 의존성 주입이 분리되어 있다는 점이 가장 큰 특징입니다.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 컨테이너에 알려주는 앱 설정 클래스
@Configuration
public class AppConfig {
    @Bean // 스프링 빈으로 등록 (메서드명인 car가 빈의 이름이 됨)
    public Car car(){
        return new GasolineCar();
//        return new HybridCar();
    }

    @Bean
    public Driver driver(Car car){
        Driver driver = new Driver(); // DI
        driver.setCar(car); // Setter Injection
        return driver;
    }
}

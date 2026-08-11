package net.likelion.bebc25.spring.di.constructor;
// 이 코드는 생성자 주입(Constructor Injection) 을 사용하는 스프링 설정 클래스(AppConfig) 입니다.
//역할은
//어떤 객체를 만들지 결정하고
//객체들을 서로 연결(DI, 의존성 주입)하여
//스프링 컨테이너에 Bean으로 등록하는 것입니다.

//즉, 이 AppConfig는 객체 생성과 의존성 연결(DI)을 담당하는 스프링 설정 클래스이며,
// Driver가 사용할 Car를 직접 만들지 않고 스프링이 생성자에 자동으로 주입하도록 구성한 예제입니다.

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

//    @Bean
//    public Car car2(){
////        return new GasolineCar();
//        return new HybridCar();
//    }

    @Bean
    public Driver driver(Car car){
        return new Driver(car); // DI
    }
}

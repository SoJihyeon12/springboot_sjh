package net.likelion.bebc25.spring.aop.dynamicproxy;
// 이 코드는 스프링에서 동적 프록시(Dynamic Proxy)를 사용하도록 설정하는 클래스입니다.
// 동적 프록시(Dynamic Proxy)는 원래 객체 대신 중간에서 대신 일을 해주는 객체를 실행 중(runtime)에 자동으로 만들어 주는 기술입니다.
// 쉽게 말하면, 동적 프록시는 진짜 객체 앞에 비서를 하나 두는 것이라고 생각하면 됩니다.
// 기존에는 Driver가 Car 객체를 직접 사용했지만, 여기서는 진짜 자동차(HybridCar) 앞에 프록시 객체를 하나 두어서 메서드 실행 전후에 추가 기능(예: 실행 시간 측정)을 넣을 수 있습니다.

// 즉, Driver는 진짜 자동차(HybridCar)를 직접 사용하는 것이 아니라 프록시 객체를 사용하고,
// 프록시는 필요할 때마다 TimeCheckInvocationHandler를 통해 부가 기능을 수행한 뒤 실제 대상 객체(HybridCar)의 메서드를 호출합니다.
// 이 구조 덕분에 HybridCar의 코드를 수정하지 않고도 실행 시간 측정, 로그 출력, 권한 검사 등 공통 기능을 손쉽게 추가할 수 있습니다.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

// 스프링 컨테이너에 알려주는 앱 설정 클래스
@Configuration // 이 클래스가 스프링 설정 클래스라는 것을 알려줍니다.
public class AppConfig { // 이 클래스는 스프링에게 어떤 객체를 만들고 어떻게 연결(DI)할지 알려주는 클래스
    @Bean // 스프링 빈으로 등록 (메서드명인 car가 빈의 이름이 됨), 메서드가 반환하는 객체를 스프링 컨테이너가 관리하는 객체(빈)로 등록합니다.
    public Car car(){ // 이 메서드가 반환하는 객체가 스프링 빈(Car Bean) 으로 등록됩니다.
//        Car target = new GasolineCar();
        Car target = new HybridCar(); // 진짜 객체(Target) 를 생성하는 부분입니다.
        Car proxyCar = (Car)Proxy.newProxyInstance( //프록시 객체 생성, Proxy.newProxyInstance()는 진짜 객체 대신 사용할 프록시 객체를 생성하는 메서드
                Car.class.getClassLoader(),// 클래스 로더, 클래스(.class 파일)를 JVM 메모리에 읽어오는 역할
                new Class[]{Car.class},    // 구현할 인터페이스 목록, 이 프록시는 Car 인터페이스를 구현하세요.라는 의미
                new TimeCheckInvocationHandler(target) // 로직을 구현한 핸들러, 예를 들어 스타트 엔진, 드라이브, 스탑엔진 메서드가 호출될 때 시간측정, 로그출력, 예외처리, 권한체크같은 부가기능 수행
        );

        return proxyCar; // 프록시 반환, 여기서 반환되는 것은 HybridCar가 아니라 프록시 객체 입니다.
    }

    @Bean
    public Driver driver(Car car){ //스프링이 이미 등록한 Car Bean을 자동으로 넣어줍니다. 여기서의 Car car는 프록시 객체 입니다.
        return new Driver(car); // DI, Driver -> Proxy -> HybridCar 순서로 연결됨
    }
}

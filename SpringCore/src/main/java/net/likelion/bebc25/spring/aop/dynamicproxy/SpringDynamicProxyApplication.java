package net.likelion.bebc25.spring.aop.dynamicproxy;
// 이 코드는 스프링 컨테이너를 생성하고, Driver 빈(Bean)을 가져와 자동차를 운전하는 프로그램입니다.
// 이전에는 new Driver()처럼 직접 객체를 생성했지만, 여기서는 스프링이 객체를 생성하고 관리합니다.

// 즉, 스프링 컨테이너가 객체 생성과 의존성 주입(DI)을 담당하고,
// 동적 프록시가 메서드 호출을 가로채 실행 시간 측정과 같은 부가 기능(AOP)을 수행한 뒤 실제 HybridCar의 메서드를 실행하는 구조입니다.

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDynamicProxyApplication {
    void main(){
        // 1. 스프링 컨테이너 생성(Bean 정보 분석을 위한 Config 객체 지정)
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. driver 빈을 스프링 컨테이너에서 꺼냄
        Driver driver = context.getBean(Driver.class);

        // 3. 비즈니스 로직 실행, Driver의 메서드를 실행합니다.
        driver.driveCar();
    }
}

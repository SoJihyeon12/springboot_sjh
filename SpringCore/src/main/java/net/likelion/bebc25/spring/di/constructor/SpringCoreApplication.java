package net.likelion.bebc25.spring.di.constructor;
// 이 코드는 생성자 주입(Constructor Injection) 예제를 실행하는 메인 클래스입니다.
// 역할은 매우 간단합니다.
// 1. 스프링 컨테이너를 생성한다.
// 2. Driver Bean을 가져온다.
// 3. Driver의 운전 기능을 실행한다.
// 하지만 내부에서는 DI(의존성 주입) 가 자동으로 이루어집니다.

//즉, 이 클래스는 스프링 컨테이너를 생성하고, 생성자 주입(DI)으로 연결된 Driver Bean을 가져와 실행하는 시작점(실행 클래스) 입니다.


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreApplication {
    void main(){
        // 1. 스프링 컨테이너 생성(Bean 정보 분석을 위한 Config 객체 지정)
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. driver 빈을 컨테이너에서 꺼냄
        Driver driver = context.getBean(Driver.class);

        // 3. 비즈니스 로직 실행
        driver.driveCar();
    }
}

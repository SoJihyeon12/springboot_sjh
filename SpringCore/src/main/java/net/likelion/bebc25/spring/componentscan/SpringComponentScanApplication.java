package net.likelion.bebc25.spring.componentscan;
// 이 코드는 컴포넌트 스캔(Component Scan)과 Spring AOP가 제대로 동작하는지 실행하는 메인 클래스입니다.
// 역할은 크게 4단계입니다.
// 1. 스프링 컨테이너 생성
// 2. Driver Bean 가져오기
// 3. Driver 객체 확인
// 4. 비즈니스 로직 실행

// 즉, 이 클래스는 컴포넌트 스캔, 의존성 주입(DI), Spring AOP가 모두 정상적으로 동작하는지 확인하는 실행 클래스이며,
// 개발자는 Driver만 호출하지만 실제 내부에서는 스프링이 만든 프록시가 먼저 실행되어 공통 기능(AOP)을 처리한 뒤 실제 비즈니스 로직을 수행합니다.

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringComponentScanApplication {
    void main(){

        try{ // 예외가 발생할 수 있는 코드를 실행합니다.
            // 1. 스프링 컨테이너 생성(Bean 정보 분석을 위한 Config 객체 지정)
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

            // 2. driver 빈을 컨테이너에서 꺼냄
            Driver driver = context.getBean(Driver.class);

            // Driver 객체 출력
            System.out.println("Driver 객체: " + driver.toString());

            // 3. 비즈니스 로직 실행
            driver.driveCar(100);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

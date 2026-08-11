package net.likelion.bebc25.spring.aop.staticproxy;
// 이 코드는 정적 프록시(Static Proxy) 예제를 실행하는 메인 클래스입니다.
// 역할은 크게 3가지입니다.
// 1.스프링 컨테이너 생성
// 2.Driver 객체(Bean) 가져오기
// 3.자동차 운전(비즈니스 로직) 실행

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStaticProxyApplication {
    void main(){
        // 1. 스프링 컨테이너 생성(Bean 정보 분석을 위한 Config 객체 지정)
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. driver 빈을 컨테이너에서 꺼냄
        Driver driver = context.getBean(Driver.class);

        // 3. 비즈니스 로직 실행
        driver.driveCar();
    }
}

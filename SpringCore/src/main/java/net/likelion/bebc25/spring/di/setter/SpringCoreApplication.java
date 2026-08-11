package net.likelion.bebc25.spring.di.setter;
// 이 코드는 Setter Injection(세터 주입) 의 가장 큰 특징을 보여주는 실행 클래스입니다.
//이전의 생성자 주입(Constructor Injection) 과 다른 점은 프로그램이 실행된 후에도 setCar()를 다시 호출하여 자동차를 바꿀 수 있다는 것입니다.

// 즉, 이 예제는 Setter Injection을 사용하면 객체 생성 이후에도 setCar()를 통해 의존성을 변경할 수 있다는 점을 보여주는 대표적인 예제입니다.
// 이는 생성자 주입과 비교했을 때 가장 큰 차이점입니다.

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

        driver.setCar(new HybridCar());
        driver.driveCar();
    }
}

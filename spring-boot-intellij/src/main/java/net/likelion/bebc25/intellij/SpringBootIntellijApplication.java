package net.likelion.bebc25.intellij;
//이 코드는 Spring Boot 애플리케이션을 실행하고, Spring 컨테이너에서 Driver Bean을 가져와 자동차를 운전한 뒤, 컨테이너를 종료하는 프로그램의 시작점입니다.
// 이전까지 배운 내용을 모두 연결하는 코드라고 생각하면 됩니다.
//@SpringBootApplication → Spring Boot 시작
//@ComponentScan → Driver, GasolineCar, LoggingAspect Bean 등록
//생성자 주입(DI) → Driver에 Car 주입
//AOP → driver.driveCar() 실행 전후에 로그 출력

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootIntellijApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootIntellijApplication.class, args);
        Driver driver = context.getBean(Driver.class);
        driver.driveCar(80);
        context.close();
    }

}

package net.likelion.bebc25.spring.aop.springaop;
// 이 코드는 Spring AOP가 적용된 프로그램을 실행하는 클래스입니다.
// 이전의 SpringDynamicProxyApplication과 거의 비슷하지만, 동적 프록시를 직접 만들지 않고 스프링이 자동으로 프록시를 생성한다는 점이 가장 큰 차이입니다.

// 핵심 정리
// 1. 스프링 컨테이너 생성
// AppConfig를 읽어 스프링 컨테이너를 생성합니다.
// Car, Driver, LoggingAspect를 Bean으로 등록합니다.
// @EnableAspectJAutoProxy를 통해 Spring AOP를 활성화하고 필요한 프록시를 자동으로 생성합니다.

// 2. Driver Bean 가져오기
// 스프링이 생성하고 관리하는 Driver 객체를 가져옵니다.

// 3. Driver 객체 출력
// Driver 객체의 정보를 출력합니다.

// 4. 비즈니스 로직 실행
//Driver의 driveCar() 메서드를 호출합니다.
//매개변수 100은 JoinPoint.getArgs()를 통해 Aspect에서도 확인할 수 있습니다.
//메서드 실행 과정에서 Spring AOP가 프록시를 통해 @Before, @Around, @After를 자동으로 실행한 뒤 실제 Driver.driveCar(100) 메서드를 수행합니다.

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopApplication { // 프로그램을 실행하는 클래스입니다.
    void main(){
        // 1. 스프링 컨테이너 생성(Bean 정보 분석을 위한 Config 객체 지정)
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // AnnotationConfigApplicationContext: @Configuration이 붙은 설정 클래스를 읽어서 스프링 컨테이너를 생성하는 클래스입니다.

        // 2. driver 빈을 컨테이너에서 꺼냄
        Driver driver = context.getBean(Driver.class); // 스프링 컨테이너에서 Driver 객체를 가져와라.

        System.out.println("Driver 객체: " + driver.toString()); // Driver 객체 출력

        // 3. 비즈니스 로직 실행
        driver.driveCar(100);
    }
}

package net.likelion.bebc25.spring.componentscan;
// 이 코드는 컴포넌트 스캔(Component Scan) 을 사용하는 Driver 클래스입니다.
// 이전의 정적 프록시에서는 AppConfig에서 직접 객체를 생성했습니다.
// 하지만 지금은 @Component를 사용하기 때문에 스프링이 자동으로 Driver 객체를 생성하고, Car 객체도 자동으로 주입(DI) 합니다.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 이 어노테이션 덕분에 @ComponentScan이 실행될 떄 Driver를 발견하여 Bean으로 등록합니다. 즉, 개발자가 new Driver();를 직접 하지 않는다.
public class Driver {
    @Autowired // Field Injection(필드 주입)이라고 한다->, @Autowired의 의미는 Car 타입의 Bean을 찾아 자동으로 넣어주세요.이다.
    private Car car; // 다형성

//    Driver(){
//        System.out.println("Driver 기본 생성자 호출됨");
//    }
//
//    // DI
//    @Autowired // 의존성 자동 주입. 생성자가 하나만 있을 경우에는 생략 가능, 이 부분은 생성자 주입(Constructor Injection)
//    Driver(@Qualifier("gasolineCar") Car car){ //@Qualifier 필요한 빈을 직접 지정
//        System.out.println("Constructor Injection 호출됨: " + car);
//        this.car = car;
//    }

//    @Autowired // 생성자의 매개변수에 필요한 Bean을 자동으로 넣어줍니다. Setter Injection(세터 주입)
//    public void setCar(Car car){
//        System.out.println("Setter Injection 호출됨.");
//        this.car = car;
//    }

    public void driveCar(int maxSpeed) {
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}

package net.likelion.bebc25.spring.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Driver {
    @Autowired // Field Injection
    private Car car;

//    Driver(){
//        System.out.println("Driver 기본 생성자 호출됨");
//    }
//
//    // DI
//    @Autowired // 의존성 자동 주입. 생성자가 하나만 있을 경우에는 생략 가능
//    Driver(@Qualifier("gasolineCar") Car car){ //@Qualifier 필요한 빈을 직접 지정
//        System.out.println("Constructor Injection 호출됨: " + car);
//        this.car = car;
//    }

//    @Autowired
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

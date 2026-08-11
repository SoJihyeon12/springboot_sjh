package net.likelion.bebc25.intellij;
// 이 코드는 운전자(Driver) 를 나타내는 클래스입니다.
//운전자는 직접 자동차를 만들지 않고, Spring이 주입(DI, Dependency Injection)해 준 자동차를 운전합니다.
//이 예제는 생성자 주입(Constructor Injection) 을 사용하는 대표적인 예제입니다.

//이 예제의 핵심은 Driver는 자동차를 직접 생성하지 않고, Spring이 생성하여 주입한 Car 객체를 사용한다는 것입니다.
// 이것이 바로 생성자 주입(Constructor Injection) 과 의존성 주입(DI) 의 핵심 개념입니다.

import org.springframework.stereotype.Component;

@Component
public class Driver {
    private final Car car;

    // DI
    Driver(Car car){
        System.out.println("called Constructor Injection: " + car);
        this.car = car;
    }

    public void driveCar(int maxSpeed) {
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}

package net.likelion.bebc25.spring.di.constructor;
// 이 코드는 생성자 주입(Constructor Injection) 을 사용하는 Driver 클래스입니다.
//Driver의 역할은 자동차(Car)를 직접 만드는 것이 아니라, 전달받은(Car) 자동차를 운전하는 것입니다.
//즉,
//GasolineCar를 사용할 수도 있고,
//HybridCar를 사용할 수도 있으며,
//Driver는 어떤 자동차인지 신경 쓰지 않고 Car 인터페이스만 사용합니다. 이것이 DI(의존성 주입) 와 다형성의 핵심입니다.

// 즉, 이 Driver 클래스는 자동차를 직접 생성하지 않고,
// 스프링이 생성자를 통해 주입해 준 Car 객체를 사용하여 운전만 수행하는 클래스입니다.
// 이것이 생성자 주입(Constructor Injection) 과 의존성 주입(DI) 의 대표적인 예입니다.

public class Driver {
    private final Car car;

    // DI
    Driver(Car car){
        System.out.println("called Constructor Injection");
        this.car = car;
    }

    public void driveCar() {
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}

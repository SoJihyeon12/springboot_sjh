package net.likelion.bebc25.spring.aop.staticproxy;
// 이 코드는 운전자(Driver) 를 나타내는 클래스입니다.
// Driver의 역할은 자동차(Car)를 직접 만드는 것이 아니라, 주입(DI)받아서 사용하는 것입니다.
// 정적 프록시 예제에서는 Driver가 실제 HybridCar나 GasolineCar를 사용하는 것이 아니라 LogProxy를 사용한다는 점이 중요합니다.

public class Driver {
    private final Car car;

    // DI(의존성 주입)
    Driver(Car car){ //이 줄이 생성자 주입(Constructor Injection) 입니다.
        System.out.println("called Constructor Injection" + car);
        this.car = car;
    }

    public void driveCar() {
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}

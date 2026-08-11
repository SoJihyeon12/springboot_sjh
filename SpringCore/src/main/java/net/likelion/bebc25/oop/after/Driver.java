package net.likelion.bebc25.oop.after;
// 이 코드는 운전자(Driver)가 자동차를 운전하는 클래스입니다. before와 가장 큰 차이점은 자동차를 직접 만들지 않고, 외부에서 전달받는다(DI, 의존성 주입)는 것입니다.

public class Driver {
    private Car car; // Car 타입의 멤버 변수

    // 생성자 (DI), DI란 필요한 객체를 직접 만들지 않고, 외부에서 전달받는 것
    Driver(Car car){ // Driver 객체를 생성할 때 Car 객체를 전달받는 생성자입니다.
        this.car = car; // 생성자로 전달받은 자동차 객체를 Driver가 사용할 수 있도록 저장하는 코드입니다.
    }

    public void driveCar() { // 자동차를 운전하는 메서드입니다.
        car.startEngine(); // 시동 걸기
        car.drive(); // 주행
        car.stopEngine(); // 시동 끄기
    }
}

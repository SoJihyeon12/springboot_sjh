package net.likelion.bebc25.spring.aop.dynamicproxy;
// 이 코드는 운전자(Driver) 클래스입니다.
// 이전 oop.after.Driver와 거의 비슷하지만,
// final 키워드와 생성자에서 출력문을 추가하여 생성자 주입(DI) 이 어떻게 이루어지는지 확인할 수 있도록 만든 예제입니다.

public class Driver { // Driver라는 클래스를 선언합니다. 자동차를 운전하는 역할을 담당합니다.
    private final Car car; // final을 사용하는 이유는 Driver가 사용하는 자동차가 중간에 바뀌지 않도록 하기 위해서입니다.

    // DI
    Driver(Car car){ // Driver 객체를 생성할 때 Car 객체를 전달받는 생성자입니다.
        System.out.println("called Constructor Injection" + car); // 이 줄은 생성자가 호출되었는지 확인하기 위한 출력문입니다.
        this.car = car; // 생성자로 전달받은 객체를 Driver가 사용할 수 있도록 저장하는 코드입니다.
    }

    public void driveCar() {
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}

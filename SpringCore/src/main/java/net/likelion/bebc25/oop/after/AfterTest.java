package net.likelion.bebc25.oop.after;
// 이 코드는 before 예제의 문제점을 개선한(after) 코드입니다.
// 핵심은 Driver가 더 이상 특정 자동차(GasolineCar, HybridCar)에 직접 의존하지 않고, Car 인터페이스에 의존한다는 것입니다.

public class AfterTest {
    void main(){
//        Car car = new GasolineCar();
        Car car = new HybridCar();  // Car 타입 변수에 HybridCar 객체를 저장한다. 라는 의미, 이것을 다형성(Polymorphism)이라고 합니다.
        Driver driver = new Driver(car); // Driver 객체 생성
        driver.driveCar(); // 자동차 운전
    }
}

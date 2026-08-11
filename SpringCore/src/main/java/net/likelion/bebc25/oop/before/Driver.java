package net.likelion.bebc25.oop.before;
// 이 코드는 Driver가 자동차를 운전하는 역할을 하는 클래스입니다.
// 다만 현재는 HybridCar에 직접 의존하고 있는 구조라는 점이 핵심입니다.
// 만약 다시 가솔린 자동차를 사용하려면 private GasolineCar car = new GasolineCar();로 직접 수정해야 합니다.
// 즉, 자동차 종류가 바뀔 때마다 Driver도 수정해야 하는 구조입니다. 이것이 before 예제의 문제점이며,
// 이후에는 **인터페이스(Car)**를 사용하여 Driver는 수정하지 않고도 GasolineCar, HybridCar, ElectricCar 등을 자유롭게 사용할 수 있도록 개선하는 방법을 배우게 됩니다.

public class Driver { // 운전자를 표현한 클래스입니다.
//    private GasolineCar car = new GasolineCar();
private HybridCar car = new HybridCar(); // Driver 객체가 만들어질 때 HybridCar도 함께 만들어집니다.

    public void driveCar() {
        car.startEngine(); // 자동차의 시동을 겁니다.
        car.drive(); // 자동차를 운전합니다.
        car.stopEngine(); // 시동을 끕니다.
    }
}

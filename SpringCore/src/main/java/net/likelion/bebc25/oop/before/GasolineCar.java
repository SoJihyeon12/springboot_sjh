package net.likelion.bebc25.oop.before;
// 이 코드는 가솔린 자동차를 표현한 GasolineCar 클래스입니다. 자동차가 할 수 있는 시동 걸기, 주행하기, 시동 끄기 기능을 메서드로 구현한 것입니다.

public class GasolineCar {
    public void startEngine(){ // 자동차의 시동을 거는 기능입니다.
        System.out.println("가솔린 엔진에 점화하여 시동을 켭니다.");
    }
    public void drive(){ // 자동차를 운전하는 기능입니다.
        System.out.println("가솔린을 사용하여 주행합니다.");
    }
    public void stopEngine(){ // 자동차의 시동을 끄는 기능입니다.
        System.out.println("가솔린 공급을 차단하여 시동을 끕니다.");
    }
}

package net.likelion.bebc25.oop.before;
// 이 코드는 하이브리드 자동차를 표현한 HybridCar 클래스입니다. 앞에서 본 GasolineCar와 구조는 거의 같지만, 하이브리드 자동차의 동작 방식을 출력하도록 구현되어 있습니다.


public class HybridCar { // HybridCar라는 클래스를 선언합니다.
    public void startEngine(){ // 하이브리드 자동차의 시동을 거는 메서드입니다.
        System.out.println("시스템 전원을 켜서 하이브리드 시동을 켭니다.");
    }
    public void drive(){ // 자동차를 주행시키는 메서드입니다.
        System.out.println("가솔린과 전기를 사용하여 주행합니다.");
    }
    public void stopEngine(){ // 하이브리드 시스템을 종료하는 메서드입니다.
        System.out.println("하이브리드 시스템 종료 처리를 합니다.");
    }
}

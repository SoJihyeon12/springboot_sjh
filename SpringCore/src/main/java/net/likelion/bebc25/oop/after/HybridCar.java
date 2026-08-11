package net.likelion.bebc25.oop.after;
// 이 코드는 Car 인터페이스를 구현한 하이브리드 자동차 클래스입니다.
// GasolineCar와 마찬가지로 Car가 정한 규칙을 따르며,
// 하이브리드 자동차만의 방식으로 시동, 주행, 시동 종료를 구현한 클래스입니다.

//왜 인터페이스를 구현하는가? Driver는 HybridCar나 GasolineCar를 직접 알 필요가 없습니다. HybridCar는 Car 타입으로 사용할 수 있기 때문에(?)


public class HybridCar implements Car { // HybridCar는 Car 인터페이스에서 정의한 기능을 반드시 구현하겠습니다 라는 의미
    @Override // @Override: Car 인터페이스의 startEngine() 메서드를 재정의(구현) 했다는 의미입니다.
    public void startEngine(){ // 시동 거는 메서드
        System.out.println("시스템 전원을 켜서 하이브리드 시동을 켭니다.");
    }
    @Override
    public void drive(){ // 주행 메서드
        System.out.println("가솔린과 전기를 사용하여 주행합니다.");
    }
    @Override
    public void stopEngine(){ // 종료 메서드
        System.out.println("하이브리드 시스템 종료 처리를 합니다.");
    }
}

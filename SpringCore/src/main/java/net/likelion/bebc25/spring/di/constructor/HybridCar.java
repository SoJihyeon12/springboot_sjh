package net.likelion.bebc25.spring.di.constructor;
// 이 코드는 Car 인터페이스를 구현한 하이브리드 자동차 클래스입니다.
//역할은 하이브리드 자동차의 실제 기능(시동 걸기, 주행하기, 시동 끄기) 을 수행하는 것입니다.
//GasolineCar와 구조는 거의 같지만, 실제 동작(출력 내용) 이 하이브리드 자동차에 맞게 구현되어 있습니다.

// 즉, HybridCar는 실제 자동차 기능을 구현하는 Car의 구현체이며, Driver는 이 클래스를 직접 사용하는 것이 아니라 Car 인터페이스를 통해 사용합니다.
// 따라서 AppConfig에서 GasolineCar와 HybridCar를 바꾸기만 해도 Driver 코드는 수정할 필요가 없으며, 이것이 DI(의존성 주입) 와 다형성의 핵심 장점입니다.

public class HybridCar implements Car {
    @Override
    public void startEngine(){
        System.out.println("시스템 전원을 켜서 하이브리드 시동을 켭니다.");
    }
    @Override
    public void drive(){
        System.out.println("가솔린과 전기를 사용하여 주행합니다.");
    }
    @Override
    public void stopEngine(){
        System.out.println("하이브리드 시스템 종료 처리를 합니다.");
    }
}

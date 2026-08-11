package net.likelion.bebc25.spring.di.constructor;
// 이 코드는 Car 인터페이스를 구현한 가솔린 자동차 클래스입니다.
//역할은 실제 자동차 기능(시동 걸기, 주행하기, 시동 끄기) 을 수행하는 것입니다.
//Driver는 자동차를 직접 만들지 않고 Car 인터페이스만 사용하기 때문에, 이 GasolineCar 객체가 주입되면 실제 동작은 이 클래스의 메서드들이 실행됩니다.

// 이 클래스는 실제 자동차 기능(비즈니스 로직)을 담당하는 구현체이며,
// Driver는 이 클래스를 직접 사용하는 것이 아니라 Car 인터페이스를 통해 사용합니다.
// 따라서 AppConfig에서 HybridCar로 변경해도 Driver는 수정할 필요가 없는 것이 DI(의존성 주입) 와 다형성의 핵심 장점입니다.

public class GasolineCar implements Car {
    @Override
    public void startEngine(){
        System.out.println("가솔린 엔진에 점화하여 시동을 켭니다.");
    }
    @Override
    public void drive(){
        System.out.println("가솔린을 사용하여 주행합니다.");
    }
    @Override
    public void stopEngine(){
        System.out.println("가솔린 공급을 차단하여 시동을 끕니다.");
    }
}

package net.likelion.bebc25.spring.aop.staticproxy;
// 이 코드는 Car 인터페이스를 구현한 하이브리드 자동차 클래스입니다.
//정적 프록시(Static Proxy) 예제에서는 실제 자동차 기능을 수행하는 객체(Target) 의 역할을 합니다.
//Driver는 HybridCar를 직접 호출하지 않고 LogProxy를 통해 호출하게 됩니다.

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

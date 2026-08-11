package net.likelion.bebc25.spring.aop.staticproxy;
// 정적 프록시(Static Proxy) 예제에서는 실제 자동차 기능을 수행하는 객체(Target) 의 역할을 합니다.
//Driver는 이 클래스를 직접 호출하는 것이 아니라, LogProxy를 거쳐서 이 클래스의 메서드를 실행하게 됩니다.

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

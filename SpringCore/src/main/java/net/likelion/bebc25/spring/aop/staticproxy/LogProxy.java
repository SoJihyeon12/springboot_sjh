package net.likelion.bebc25.spring.aop.staticproxy;
//이 클래스는 정적 프록시(Static Proxy)의 핵심 클래스입니다.
//쉽게 말하면, 진짜 자동차(HybridCar, GasolineCar) 앞에서 대신 일을 처리하는 대리인(Proxy) 입니다.
//Driver는 HybridCar를 직접 호출하지 않고 LogProxy를 호출합니다. 그러면 LogProxy가 부가 기능(로그 출력) 을 수행한 뒤 실제 자동차(target)를 호출합니다.

public class LogProxy implements Car{
    private final Car target; // 진짜 Car 객체

    public LogProxy(Car target){
        this.target = target;
    }
    @Override
    public void startEngine() {
        System.out.println("[메서드 실행 전] 엔진을 점검합니다.");
        target.startEngine();

    }

    @Override
    public void drive() {
        System.out.println("[메서드 실행 전후] 안전벨트를 맵니다.");
        target.drive();
        System.out.println("[메서드 실행 전후] 안전벨트를 풉니다.");

    }

    @Override
    public void stopEngine() {
        target.stopEngine();
        System.out.println("[메서드 실행 후] 하차합니다.");

    }
}

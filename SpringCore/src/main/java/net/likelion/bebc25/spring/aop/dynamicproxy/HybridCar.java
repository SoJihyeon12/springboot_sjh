package net.likelion.bebc25.spring.aop.dynamicproxy;
// 이 코드는 Car 인터페이스를 구현한 하이브리드 자동차 클래스입니다. 이 클래스의 역할은 하이브리드 자동차가 실제로 어떻게 동작하는지 구현하는 것입니다.
// 동적 프록시(AOP) 예제에서는 이 클래스가 실제 작업을 수행하는 대상(Target) 이라는 점이 중요합니다.

public class HybridCar implements Car {
    @Override // Car 인터페이스의 startEngine() 메서드를 구현(재정의) 했다는 표시입니다. 메서드 이름이나 매개변수를 잘못 작성하면 컴파일 오류가 발생하도록 도와줍니다.
    public void startEngine(){
        System.out.println("시스템 전원을 켜서 하이브리드 시동을 켭니다.");
    }
    @Override // Car 인터페이스의 drive() 메서드를 구현(재정의) 했다는 표시입니다. 메서드 이름이나 매개변수를 잘못 작성하면 컴파일 오류가 발생하도록 도와줍니다.
    public void drive(){
        System.out.println("가솔린과 전기를 사용하여 주행합니다.");
    }
    @Override // Car 인터페이스의 stopEngine() 메서드를 구현(재정의) 했다는 표시입니다. 메서드 이름이나 매개변수를 잘못 작성하면 컴파일 오류가 발생하도록 도와줍니다.
    public void stopEngine(){
        System.out.println("하이브리드 시스템 종료 처리를 합니다.");
    }
}

package net.likelion.bebc25.spring.aop.dynamicproxy;
// 이 코드는 Car 인터페이스를 구현한 가솔린 자동차 클래스입니다. 실제로 자동차가 어떻게 시동을 걸고, 주행하고, 시동을 끄는지를 구현한 실제 객체(Target) 입니다.
// 동적 프록시(AOP) 예제에서는 이 클래스가 실제 작업을 수행하는 대상(Target) 이라는 점이 중요합니다.

public class GasolineCar implements Car { // GasolineCar는 Car 인터페이스가 정한 규칙을 모두 구현하겠습니다. 라는 의미
    @Override // Car 인터페이스의 startEngine() 메서드를 구현했다는 표시입니다. 메서드 이름이나 매개변수를 잘못 작성하면 컴파일러가 오류를 알려줍니다.
    public void startEngine(){
        System.out.println("가솔린 엔진에 점화하여 시동을 켭니다.");
    }
    @Override // Car 인터페이스의 drive() 메서드를 구현했다는 표시입니다. 메서드 이름이나 매개변수를 잘못 작성하면 컴파일러가 오류를 알려줍니다.
    public void drive(){
        System.out.println("가솔린을 사용하여 주행합니다.");
    }
    @Override // Car 인터페이스의 stopEngine() 메서드를 구현했다는 표시입니다. 메서드 이름이나 매개변수를 잘못 작성하면 컴파일러가 오류를 알려줍니다.
    public void stopEngine(){
        System.out.println("가솔린 공급을 차단하여 시동을 끕니다.");
    }
}

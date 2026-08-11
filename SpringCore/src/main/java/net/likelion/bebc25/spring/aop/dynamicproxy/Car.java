package net.likelion.bebc25.spring.aop.dynamicproxy;
//이 코드는 자동차가 반드시 가져야 하는 기능을 정의한 인터페이스(Interface) 입니다.
//앞에서 본 oop.after.Car와 거의 같은 역할을 하지만, 이번에는 동적 프록시(Dynamic Proxy) 에서도 이 인터페이스가 매우 중요한 역할을 합니다.

public interface Car { // 자동차라면 시동을 걸고, 주행하고, 시동을 끄는 기능이 있어야 한다.라는 규칙만 만든 것입니다.
    void startEngine();
    void drive();
    void stopEngine();
}

package net.likelion.bebc25.intellij;
// 이 코드는 자동차(Car)의 기능을 정의한 인터페이스(Interface) 입니다.
//이전 Spring DI 예제에서도 계속 사용했던 Car 인터페이스와 같은 개념입니다.
//인터페이스는
//"이 기능은 반드시 만들어야 합니다."라는 규칙(설계도)을 정의하는 것
//입니다.

public interface Car {
    void startEngine();
    void drive();
    void stopEngine();
}

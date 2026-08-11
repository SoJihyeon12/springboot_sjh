package net.likelion.bebc25.intellij;
// 이 코드는 가솔린 자동차(GasolineCar) 를 나타내는 클래스입니다.
//이 클래스는 이전에 만든 Car 인터페이스를 구현(implements) 한 클래스이며,
//Car에서 약속한
//시동 걸기
//주행하기
//시동 끄기
//기능을 실제로 구현하고 있습니다.
//즉,"Car라는 설계도를 바탕으로 실제 가솔린 자동차를 만든 클래스"

// 즉, GasolineCar는 Car 인터페이스의 실제 구현 클래스이며, Spring이 Bean으로 생성한 뒤 Driver에 주입합니다.
// Driver는 Car 타입만 알고 있기 때문에 구현체가 GasolineCar이든 HybridCar이든 같은 방식으로 사용할 수 있으며, 이것이 인터페이스와 의존성 주입(DI)의 핵심입니다.

import org.springframework.stereotype.Component;

@Component
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

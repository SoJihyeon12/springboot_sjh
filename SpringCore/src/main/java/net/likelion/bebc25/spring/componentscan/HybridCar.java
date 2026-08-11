package net.likelion.bebc25.spring.componentscan;
// 이 코드는 컴포넌트 스캔(Component Scan) 을 사용하는 하이브리드 자동차 클래스입니다.
//이전의 GasolineCar와 거의 비슷하지만, 두 가지 중요한 차이점이 있습니다.
//Bean 이름을 직접 "hCar"로 지정했다.
//@Primary를 사용하여 기본으로 주입될 Bean으로 지정했다.

// 즉, 이 클래스는 실제 자동차 기능을 구현한 Car의 구현체이며,
// @Component("hCar")로 Bean 이름을 hCar로 지정하고,
// @Primary를 통해 Car 타입의 Bean이 여러 개 있을 때 가장 먼저 선택되는 기본 Bean으로 설정한 클래스입니다.


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(/*value=*/"hCar") // 빈의 이름은 hCar로 자동 지정됨, @Component는 스프링이 이 클래스를 Bean으로 등록합니다.
@Primary // 동일 타입의 여러 빈 중에 메인으로 지정, 동일한 타입의 Bean이 여러 개 있으면 이 Bean을 우선 사용하세요.
public class HybridCar implements Car { // Car 인터페이스를 구현한 하이브리드 자동차입니다.
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

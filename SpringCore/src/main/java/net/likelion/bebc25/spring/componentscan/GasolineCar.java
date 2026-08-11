package net.likelion.bebc25.spring.componentscan;
// 이 코드는 컴포넌트 스캔(Component Scan) 을 사용하는 가솔린 자동차 클래스입니다.
// 이전의 정적 프록시에서는 AppConfig에서 직접 객체를 생성해서 Bean으로 등록했습니다.
// 하지만 지금은 @Component를 사용하기 때문에 스프링이 자동으로 GasolineCar 객체를 생성하여 Bean으로 등록합니다.

// 이 클래스는 자동차의 실제 기능만 담당하는 구현체이며,
// @Component 덕분에 스프링이 자동으로 객체를 생성하고 관리합니다.
// 이후 Driver에서 Car 타입을 주입받을 때 후보 Bean 중 하나로 사용됩니다.

import org.springframework.stereotype.Component;

@Component // 빈의 이름은 gasolineCar로 자동 지정됨, @Component는 이 클래스를 스프링이 관리하는 객체(Bean)로 등록하세요.라는뜻, Bean이란? 스프링 컨테이너가 생성하고 관리하는 객체
public class GasolineCar implements Car { // Car 인터페이스를 구현한다는 의미입니다.
    @Override // 부모 인터페이스(Car)의 메서드를 구현했다는 표시입니다.
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

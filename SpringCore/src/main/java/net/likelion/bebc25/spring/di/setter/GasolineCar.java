package net.likelion.bebc25.spring.di.setter;
// 이 코드는 Setter Injection 예제에서 사용하는 GasolineCar 클래스입니다.
//역할은 실제 자동차의 기능(시동 걸기, 주행하기, 시동 끄기) 을 구현하는 것입니다.
//Driver는 자동차를 직접 만들지 않고 Car 인터페이스만 사용합니다. 따라서 AppConfig에서 GasolineCar를 주입하면 실제 실행되는 메서드는 이 클래스의 메서드가 됩니다.

// Setter Injection에서는 이 GasolineCar 객체가 AppConfig에서 생성된 후 driver.setCar(car)를 통해 Driver에 주입됩니다.
// 이후 Driver가 car.startEngine(), car.drive(), car.stopEngine()을 호출하면 실제로는 GasolineCar의 메서드가 실행됩니다.
// 이는 Driver가 구현 클래스가 아닌 Car 인터페이스에 의존하기 때문입니다.

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


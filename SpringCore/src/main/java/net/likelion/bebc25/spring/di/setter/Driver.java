package net.likelion.bebc25.spring.di.setter;
// 이 코드는 Setter Injection(세터 주입) 을 사용하는 Driver 클래스입니다.
//역할은 자동차(Car)를 직접 생성하지 않고, 외부에서 전달받아 운전하는 것입니다.

//이전의 생성자 주입(Constructor Injection) 과 가장 큰 차이점은 아래와 같다.
//생성자 주입: 객체를 만들면서 자동차를 전달받음
//Setter 주입: 객체를 먼저 만들고, 나중에 setCar() 메서드로 자동차를 전달받음

// 즉, 이 Driver 클래스는 객체를 먼저 생성한 뒤 setCar() 메서드를 통해 의존성을 주입받는 Setter Injection 방식의 예제입니다.
// 생성자 주입과 달리 객체 생성과 의존성 주입이 분리되어 있으며, Driver는 자동차를 직접 생성하지 않고 외부에서 주입받아 사용합니다.


public class Driver {
    private Car car;

    // setter injection
    public void setCar(Car car){
        System.out.println("called Setter Injection");
        this.car = car;
    }

    public void driveCar() {
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}

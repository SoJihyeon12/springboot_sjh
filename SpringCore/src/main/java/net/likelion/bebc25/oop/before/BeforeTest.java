package net.likelion.bebc25.oop.before;
// 이 코드는 BeforeTest 클래스에서 Driver 객체를 생성하고 자동차를 운전하는 메서드를 호출하는 예제입니다

//BeforeTest라는 클래스를 선언합니다.
//public이므로 다른 패키지에서도 사용할 수 있습니다.
public class BeforeTest {
    void main(){
        Driver driver = new Driver(); // Driver: Driver 클래스의 자료형입니다. driver: 객체를 저장할 참조 변수입니다. new Driver():Driver 객체를 생성합니다.이때 Driver의 생성자가 실행됩니다.
        driver.driveCar(); // driver.driveCar()를 호출하여 Driver 클래스의 driveCar() 메서드를 실행한다.
    }
}

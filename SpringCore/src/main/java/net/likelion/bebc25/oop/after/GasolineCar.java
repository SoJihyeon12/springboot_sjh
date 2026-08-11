package net.likelion.bebc25.oop.after;

public class GasolineCar implements Car { // GasolineCar는 Car의 규칙을 따르겠습니다 라는 뜻
    @Override // @Override : 부모(인터페이스)의 메서드를 재정의(Override) 했다는 표시입니다. 컴파일러가 메서드 이름이나 매개변수가 인터페이스와 일치하는지 확인해 줍니다.
    public void startEngine(){ // 시동거는 메서드
        System.out.println("가솔린 엔진에 점화하여 시동을 켭니다.");
    }
    @Override
    public void drive(){ // 주행하는 메서드
        System.out.println("가솔린을 사용하여 주행합니다.");
    }
    @Override
    public void stopEngine(){ // 시동 끄는 메서드
        System.out.println("가솔린 공급을 차단하여 시동을 끕니다.");
    }
}

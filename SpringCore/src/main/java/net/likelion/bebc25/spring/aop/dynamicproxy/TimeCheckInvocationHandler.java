package net.likelion.bebc25.spring.aop.dynamicproxy;
// 이 클래스는 동적 프록시(Dynamic Proxy)의 핵심입니다.
// 쉽게 말하면 진짜 자동차(HybridCar, GasolineCar) 대신 앞에서 메서드 호출을 가로채는 역할을 합니다.

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeCheckInvocationHandler implements InvocationHandler { // "InvocationHandler를 구현하는 클래스"
    private final Car target; // 진짜 Car 객체

    TimeCheckInvocationHandler(Car target){
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { // target의 모든 메서드에 대해서 호출됨, Object proxy: 프록시 객체 자신, Method method: 현재 호출된 메서드, Object[] args: 메서드의 매개변수
        System.out.println("[동적 프록시] 메서드 실행 전: " + method.getName());

        long start = System.currentTimeMillis(); // 시작 시간, 현재 시간을 밀리초 단위로 저장
        Object result = method.invoke(target, args); // target의 메서드 호출, 진짜 메서드 실행, Method 객체를 이용해서 실제 메서드를 실행한다.
        long end = System.currentTimeMillis(); // 종료 시간

        System.out.println("[동적 프록시] 메서드 실행 후: " + method.getName() + " (시간: " + (end-start) + "ms)"); // 실행 후 출력

        return result; // 결과 반환
    }
}

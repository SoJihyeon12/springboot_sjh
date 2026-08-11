package net.likelion.bebc25.spring.aop.springaop;
// 이 클래스는 Spring AOP에서 공통으로 실행할 기능(횡단 관심사, Aspect) 을 정의하는 클래스입니다.
// Driver의 메서드가 실행될 때 "실행 전", "실행 후", "실행 전후"에 자동으로 실행되는 코드를 모아놓은 클래스입니다.
// 이전 예제에서는 TimeCheckInvocationHandler가 이 역할을 했습니다.

// @Aspect: 이 클래스가 AOP의 공통 기능(횡단 관심사)을 담당함을 나타냅니다.
//@Pointcut: AOP를 적용할 메서드의 범위를 지정합니다. 여기서는 springaop 패키지의 Driver 클래스의 모든 메서드가 대상입니다.
//@Before: 대상 메서드가 실행되기 직전에 실행됩니다.
//@After: 대상 메서드가 끝난 후에 실행됩니다.
//@Around: 대상 메서드의 실행 전과 후를 모두 감싸는 Advice입니다.
//joinPoint.proceed(): 실제 대상 메서드를 실행하는 코드로, 이전 동적 프록시 예제의 method.invoke(target, args)와 같은 역할을 합니다.

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect // 횡단 관심사 클래스 정의, @Aspect 이 클래스가 AOP에서 공통 기능을 담당하는 클래스라는 뜻
public class LoggingAspect {

    @Pointcut("execution(* net.likelion.bebc25.spring.aop.springaop.*Driver.*(..))") // Pointcut이란? "어떤 메서드에 AOP를 적용할지"를 지정하는 규칙입니다. execution(): 메서드 실행 시점
    private void springaopPackageMethods(){ } // 실제로 실행되는 메서드가 아닙니다. 이 메서드는 Pointcut 이름을 만들기 위한 것입니다.

    //    @Before("execution(* net.likelion.bebc25.spring.aop.springaop.*Driver.*(..))")
    @Before("springaopPackageMethods()")
    public void logBefore(JoinPoint joinPoint){ // 메서드 수행 전에 로그 메세지 출력, Pointcut에 해당하는 메서드가 실행되기 전에 실행됩니다.
        System.out.println("[AOP 로그 before] 메서드 실행 전에 처리할 코드를 작성합니다.");
        Object[] args = joinPoint.getArgs(); // 현재 메서드의 매개변수를 가져옵니다.
        System.out.println(Arrays.toString(args));
    }

    @After("springaopPackageMethods()")
    public void logAfter(){ // 메서드 수행 후에 로그 메세지 출력, 메서드 실행이 끝난 후 실행됩니다.
        System.out.println("[AOP 로그 after] 메서드 실행 후에 처리할 코드를 작성합니다.");
    }

    @Around("springaopPackageMethods()") // 가장 강력한 Advice입니다. 실행 전과 실행 후를 모두 제어할 수 있습니다.
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable { // 메서드 수행 전/후에 로그 메세지 출력
        System.out.println("[AOP 로그 around] 메서드 실행 전에 처리할 코드를 작성합니다.");
        joinPoint.proceed(); // 대상 메서드를 호출한다.
        System.out.println("[AOP 로그 around] 메서드 실행 후에 처리할 코드를 작성합니다.");
    }
}
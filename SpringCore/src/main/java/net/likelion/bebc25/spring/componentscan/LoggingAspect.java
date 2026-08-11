package net.likelion.bebc25.spring.componentscan;
//이 코드는 Spring AOP(Aspect-Oriented Programming) 에서 공통 기능(횡단 관심사, Cross-cutting Concern) 을 담당하는 클래스입니다.
//쉽게 말하면, Driver는 자동차를 운전하는 실제 업무(비즈니스 로직) 를 수행합니다.
//LoggingAspect는 로그 출력처럼 여러 곳에서 공통으로 필요한 기능을 담당합니다.
//이전의 정적 프록시(LogProxy) 에서는 개발자가 프록시 클래스를 직접 만들었지만, Spring AOP에서는 @Aspect만 작성하면 스프링이 프록시를 자동으로 만들어 줍니다.

// 즉, 이 LoggingAspect는 Driver의 메서드 실행 전·후에 로그를 출력하는 공통 기능을 담당하며,
// 스프링이 자동으로 생성한 프록시를 통해 Driver의 메서드를 가로채어(AOP) 필요한 작업을 수행하는 클래스입니다.


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect // 횡단 관심사 클래스 정의, 이 클래스는 AOP의 공통 기능(Aspect)을 담당합니다. 가장 중요한 어노테이션
@Component // 이 클래스도 Bean으로 등록합니다.
public class LoggingAspect { // 로그를 담당하는 Aspect 클래스입니다.

    @Pointcut("execution(* net.likelion.bebc25.spring.componentscan.Driver.*(..))")
    private void springaopPackageMethods(){ }

    //    @Before("execution(* net.likelion.bebc25.spring.aop.springaop.*Driver.*(..))")
    @Before("springaopPackageMethods()")
    public void logBefore(JoinPoint joinPoint){ // 메서드 수행 전에 로그 메세지 출력
        System.out.println("[AOP 로그 before] 메서드 실행 전에 처리할 코드를 작성합니다.");
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
    }

    @After("springaopPackageMethods()")
    public void logAfter(){ // 메서드 수행 후에 로그 메세지 출력
        System.out.println("[AOP 로그 after] 메서드 실행 후에 처리할 코드를 작성합니다.");
    }

    @Around("springaopPackageMethods()")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable { // 메서드 수행 전/후에 로그 메세지 출력
        System.out.println("[AOP 로그 around] 메서드 실행 전에 처리할 코드를 작성합니다.");
        joinPoint.proceed(); // 대상 메서드를 호출한다.
        System.out.println("[AOP 로그 around] 메서드 실행 후에 처리할 코드를 작성합니다.");
    }
}
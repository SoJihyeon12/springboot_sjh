package net.likelion.bebc25.intellij;
// 이 코드는 Spring AOP(Aspect Oriented Programming, 관점 지향 프로그래밍) 를 사용하는 클래스입니다.
//쉽게 말하면,원래 메서드를 수정하지 않고, 실행 전이나 실행 후에 공통 기능(로그 출력 등)을 자동으로 추가하는 클래스입니다.

// 이 예제의 핵심은 LoggingAspect가 Driver의 코드를 수정하지 않고도 메서드 실행 전후에 로그를 추가한다는 점입니다.
// 이것이 Spring AOP의 가장 큰 장점이며, 공통 기능(로그, 보안 검사, 트랜잭션 처리 등)을 여러 클래스에 중복 작성하지 않고 한 곳에서 관리할 수 있게 해 줍니다.

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect // 횡단 관심사 클래스 정의
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* net.likelion.bebc25.intellij.*Driver.*(..))")
    private void springaopPackageMethods(){ }

    @Before("springaopPackageMethods()")
    public void logBefore(JoinPoint joinPoint){ // 메서드 수행 전에 로그 메세지 출력
        log.info("[AOP 로그 before] 메서드 실행 전에 처리할 코드를 작성합니다.");
    }

    @After("springaopPackageMethods()")
    public void logAfter(){ // 메서드 수행 후에 로그 메세지 출력
        log.info("[AOP 로그 after] 메서드 실행 후에 처리할 코드를 작성합니다.");
    }

    @Around("springaopPackageMethods()")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable { // 메서드 수행 전/후에 로그 메세지 출력
        log.debug("[AOP 로그 around] 메서드 실행 전에 처리할 코드를 작성합니다.");
        joinPoint.proceed(); // 대상 메서드를 호출한다.
        log.debug("[AOP 로그 around] 메서드 실행 후에 처리할 코드를 작성합니다.");
    }
}
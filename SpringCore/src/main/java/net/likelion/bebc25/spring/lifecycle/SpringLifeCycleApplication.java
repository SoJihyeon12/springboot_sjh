package net.likelion.bebc25.spring.lifecycle;
// 이 코드는 Spring Bean의 생명주기(Lifecycle) 를 확인하기 위한 실행 클래스입니다.
// 역할은 다음과 같습니다.
// 1. 스프링 컨테이너를 생성한다.
// 2. TempFileSupport2 Bean을 가져온다.
// 3. 로그를 기록한다.
// 4. 스프링 컨테이너를 종료한다.
// 5.Bean의 소멸 메서드가 실행되는 것을 확인한다.
// 즉, 이 예제의 핵심은 Bean이 생성되고 종료될 때 어떤 일이 일어나는지를 배우는 것입니다.

// 즉, 이 클래스는 Spring Bean의 전체 생명주기(생성 → 초기화 → 사용 → 소멸) 를 직접 확인하기 위한 실행 클래스입니다.
// 특히 context.close()를 호출함으로써 Bean이 종료될 때 수행되는 소멸 과정까지 확인할 수 있다는 점이 핵심입니다.

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringLifeCycleApplication {
    void main(){
        try{
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            TempFileSupport2 support = context.getBean(TempFileSupport2.class);
            support.writeLog("사용자가 로그인 함.");
            context.close(); // 스프링 컨테이너 종료
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
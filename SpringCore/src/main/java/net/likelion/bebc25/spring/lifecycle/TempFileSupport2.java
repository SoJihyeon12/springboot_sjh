package net.likelion.bebc25.spring.lifecycle;
//이 코드는 Spring Bean의 생명주기(Lifecycle) 를 인터페이스 방식으로 구현한 예제입니다.
//이전 예제에서는
//@PostConstruct
//@PreDestroy
//를 사용했지만,
//
//이번에는
//InitializingBean
//DisposableBean
//인터페이스를 구현하여 초기화 메서드와 소멸 메서드를 정의합니다.
//
//즉, 이 클래스의 역할은
//Bean이 생성될 때 파일을 열고, Bean이 종료될 때 파일을 닫는 것입니다.

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.Destroyable;

// 임시로 파일을 만들어서 파일에 로그를 출력
@Component
public class TempFileSupport2 implements InitializingBean, DisposableBean {
    @Value("resources/temp.log")
    private String filePath; // 파일 경로

    public TempFileSupport2(){
        System.out.println("생성자 호출됨." + filePath);
    }

    // 네트워크, 파일시스템 연결 같은 무거운 작업을 수행할 초기화 메서드 정의
    // 비즈니스 메서드 호출 전에 실행해야 할 작업
    // 초기화 콜백
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(filePath + "경로의 FileOutputStream 생성.");
    }

    public void writeLog(String msg){
        System.out.println(filePath +"에 로그 저장: " + msg);
    }

    // 소멸 콜백
    @Override
    public void destroy() throws Exception {
        System.out.println(filePath + "경로의 FileOutputStream 닫기.");
    }
}

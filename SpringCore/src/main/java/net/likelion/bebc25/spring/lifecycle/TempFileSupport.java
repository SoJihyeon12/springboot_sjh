package net.likelion.bebc25.spring.lifecycle;
// 이 코드는 Spring Bean의 생명주기(Lifecycle) 를 설명하기 위한 예제입니다.
//특히 Bean이 생성될 때(초기화) 와 Bean이 소멸될 때(종료) 어떤 메서드가 자동으로 실행되는지를 보여줍니다.
//이 클래스의 역할은
//임시 로그 파일을 생성하여 로그를 저장하고, 프로그램 종료 시 파일을 닫는 역할
//이라고 생각하면 됩니다.

//생성자에서는 filePath를 사용할 수 없고(null), @PostConstruct 이후부터는 정상적으로 사용할 수 있다는 점이 이 예제의 가장 중요한 핵심입니다.

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 임시로 파일을 만들어서 파일에 로그를 출력
//@Component
public class TempFileSupport {
    @Value("resources/temp.log")
    private String filePath; // 파일 경로

    public TempFileSupport(){
        System.out.println("생성자 호출됨." + filePath);
    }

    // 네트워크, 파일시스템 연결 같은 무거운 작업을 수행할 초기화 메서드 정의
    // 비즈니스 메서드 호출 전에 실행해야 할 작업
    @PostConstruct // 초기화 콜백
    public void init(){
        System.out.println(filePath + "경로의 FileOutputStream 생성.");
    }

    public void writeLog(String msg){
        System.out.println(filePath +"에 로그 저장: " + msg);
    }

    @PreDestroy // 소멸 콜백
    public void close(){
        System.out.println(filePath + "경로의 FileOutputStream 닫기.");
    }
}

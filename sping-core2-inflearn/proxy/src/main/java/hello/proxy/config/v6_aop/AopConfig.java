package hello.proxy.config.v6_aop;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import hello.proxy.config.v6_aop.aspect.LogTraceAspect;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * spring aop는 프록시 방식으로 부가 기능을 삽입한다.
 * 프록시는 메서드 오버라이딩 개념으로 동작한다. 따라서 생성자나 static 메서드, 필드 값 접근에는 프록시 개념이 적용될 수 없다.
 * 프록시를 사용하는 스프링 aop의 조인 포인트는 메서드 실행으로 제한 된다.
 * 스프링 빈에 등록을 해야 aop가 된다.
 *
 * AspectJ를 사용하면 위와같은 제한이 생기지 않는다.(AspectJ는 컴파일 타임에서 실제로 코드에 부가기능 코드를 넣어준다)
 * 하지만 초기비용이 많이 든다.
 */
@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace){
        return new LogTraceAspect(logTrace);
    }
}

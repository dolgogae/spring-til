package com.sihun.feign.feign.config;

import com.sihun.feign.feign.decoder.DemoFeignErrorDecoder;
import com.sihun.feign.feign.intercepter.DemoFeignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoFeignConfig {

    @Bean
    public DemoFeignInterceptor demoFeignInterceptor(){
        return DemoFeignInterceptor.of();
    }

    @Bean
    public DemoFeignErrorDecoder demoFeignErrorDecoder(){
        return new DemoFeignErrorDecoder();
    }
}

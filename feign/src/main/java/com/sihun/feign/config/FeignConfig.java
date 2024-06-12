package com.sihun.feign.config;

import com.sihun.feign.feign.logger.FeignCustomLogger;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Logger feignLogger(){
        return new FeignCustomLogger();
    }
}

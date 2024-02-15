package com.sihun.springtil.springproxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopProxy {
    @Before("execution(* com.sihun.springtil.*.*(..))")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        System.out.println("Before executing: " + joinPoint.getSignature().getName());
    }
}
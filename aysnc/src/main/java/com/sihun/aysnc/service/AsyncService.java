package com.sihun.aysnc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final EmailService emailService;

    // bean 주입시
    // -> bean으로 주입시에만 async가 동작한다.
    // 반드시 bean 주입으로 async를 사용하여야 한다.
    // async bean을 사용할 땐 public을 사용하여야 한다.
    public void asyncCall_1(){
        System.out.println("[aysyncCall_1] :: " + Thread.currentThread().getName());
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
        /**
         * 비동기로 동작할수 있게 Sub Thread에게 위임
         */
    }

    // 직접 생성시
    // spring 프레임워크로 관리 되지 않는다.
    public void asyncCall_2(){
        System.out.println("[aysyncCall_2] :: " + Thread.currentThread().getName());
        EmailService emailService1 = new EmailService();
        emailService1.sendMail();
        emailService1.sendMailWithCustomThreadPool();
    }

    // 내부 메서드 호출시
    // 프록시 객체가 들어가지 않아서 정상적을 동작하지 않는다.
    public void asyncCall_3(){
        System.out.println("[aysyncCall_3] :: " + Thread.currentThread().getName());
        sendMail();
    }

    @Async
    public void sendMail(){
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }
}

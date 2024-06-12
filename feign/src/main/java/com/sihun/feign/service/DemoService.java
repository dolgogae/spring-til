package com.sihun.feign.service;

import com.sihun.feign.common.dto.BaseRequestInfo;
import com.sihun.feign.common.dto.BaseResponseInfo;
import com.sihun.feign.feign.client.DemoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final DemoFeignClient demoFeignClient;

    public String get(){
        ResponseEntity<BaseResponseInfo> response =
                demoFeignClient.callGet("CustomHeader", "CustomName", 1L);
        System.out.println("Name: " + response.getBody().getName());
        System.out.println("Age: " + response.getBody().getAge());
        System.out.println("Header: " + response.getBody().getHeader());
        return "get";
    }

    public String post(){
        ResponseEntity<BaseResponseInfo> response =
                demoFeignClient.callPost("CustomHeader", BaseRequestInfo.builder()
                                .age(1L)
                                .name("CustomName").build());
        System.out.println("Name: " + response.getBody().getName());
        System.out.println("Age: " + response.getBody().getAge());
        System.out.println("Header: " + response.getBody().getHeader());
        return "get";
    }

    public String errorDecoder(){
        demoFeignClient.callErrorDecoder();
        return "error";
    }

}

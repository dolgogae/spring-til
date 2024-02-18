package com.sihun.feign.feign.intercepter;


import feign.Request.HttpMethod;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // get 요청일 경우
        if(requestTemplate.method().equals(HttpMethod.GET.name())){
            System.out.println("[GET] [DemoFeignInterceptor] queries: " + requestTemplate.queries());
            return;
        }

        // post 요청일 경우
        String encodedRequestBody
                = StringUtils.toEncodedString(requestTemplate.body(), StandardCharsets.UTF_8);
        System.out.println("[POST] [DemoFeignInterceptor] requestBody: " + encodedRequestBody);
        
        // 추가적으로 본인이 필요한 로직 추가
        
        String convertRequestBody = encodedRequestBody;
        requestTemplate.body(convertRequestBody);
    }
}

package com.sihun.proxy.springproxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async
    public CompletableFuture<String> performAsyncTask() {
        // 비동기 작업 수행
        return CompletableFuture.completedFuture("Result");
    }
    @FeignClient("some-service")
    public interface SomeClient {
        @GetMapping("/some/endpoint")
        String getSomeData();
    }
}

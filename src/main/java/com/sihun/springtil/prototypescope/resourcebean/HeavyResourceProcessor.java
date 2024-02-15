package com.sihun.springtil.prototypescope.resourcebean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HeavyResourceProcessor {
    private HeavyResource resource;

    public HeavyResourceProcessor() {
        // 리소스 집약적인 초기화 작업
        this.resource = new HeavyResource();
    }

    public void process() {
        // 복잡한 리소스 처리 로직
    }

    private static class HeavyResource {

    }
}

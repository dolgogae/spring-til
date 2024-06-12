package com.sihun.proxy.springproxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class LazyService {
    public LazyService() {
        System.out.println("LazyService 생성");
    }
}

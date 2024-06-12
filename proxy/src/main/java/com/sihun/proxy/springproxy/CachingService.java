package com.sihun.proxy.springproxy;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CachingService {
    @Cacheable("items")
    public String expensiveOperation(String param){
        // expensive operation
        return "Result";
    }
}

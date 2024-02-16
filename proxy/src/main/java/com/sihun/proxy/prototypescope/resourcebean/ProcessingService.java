package com.sihun.proxy.prototypescope.resourcebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ProcessingService {

    @Autowired
    private ApplicationContext context;

    public void processTask() {
        HeavyResourceProcessor processor = context.getBean(HeavyResourceProcessor.class);
        processor.process();
    }
}

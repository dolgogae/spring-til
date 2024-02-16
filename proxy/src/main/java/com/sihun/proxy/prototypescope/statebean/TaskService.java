package com.sihun.proxy.prototypescope.statebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private ApplicationContext context;

    public UserTask createUserTask() {
        return context.getBean(UserTask.class);
    }
}

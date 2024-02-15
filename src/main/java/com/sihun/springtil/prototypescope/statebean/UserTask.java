package com.sihun.springtil.prototypescope.statebean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Scope("prototype")
public class UserTask {
    private String taskId;
    private Map<String, Object> taskState = new HashMap<>();

    public UserTask() {
        this.taskId = UUID.randomUUID().toString();
    }

    public void addTaskDetail(String key, Object value) {
        taskState.put(key, value);
    }

    // taskId와 taskState의 getter 메서드
}

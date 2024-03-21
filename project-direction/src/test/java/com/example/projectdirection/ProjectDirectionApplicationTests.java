package com.example.projectdirection;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest
public class ProjectDirectionApplicationTests {

    static final GenericContainer MY_REDIS_CONTAINER = new GenericContainer<>("redis:6")
            .withExposedPorts(6379);

    @Before
    public void setup(){
        System.setProperty("spring.redis.host", MY_REDIS_CONTAINER.getHost());
        System.setProperty("spring.redis.port", MY_REDIS_CONTAINER.getMappedPort(6379).toString());
    }

}

package com.example.reflectionspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class ReflectionSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReflectionSpringApplication.class, args);
    }

}

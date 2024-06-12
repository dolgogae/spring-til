package com.example.projectdirection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjectDirectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectDirectionApplication.class, args);
    }

}

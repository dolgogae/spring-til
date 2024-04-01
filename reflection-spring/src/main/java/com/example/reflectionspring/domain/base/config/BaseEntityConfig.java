package com.example.reflectionspring.domain.base.config;

import com.example.reflectionspring.domain.base.mapper.BaseEntityMapper;
import com.example.reflectionspring.domain.base.service.BaseEntityService;
import com.example.reflectionspring.domain.entity1.data.Entity1;
import com.example.reflectionspring.domain.entity1.data.Entity1Part;
import com.example.reflectionspring.domain.entity1.dto.Entity1PartDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseEntityConfig {

    @Bean(name = "entity1BaseService")
    public BaseEntityService<Entity1, Entity1Part, Entity1PartDto> entity1BaseService(){
        return new BaseEntityService<>(
                new BaseEntityMapper<>(Entity1.class, Entity1Part.class, Entity1PartDto.class),
                Entity1.class, Entity1Part.class, Entity1PartDto.class
        );
    }
}

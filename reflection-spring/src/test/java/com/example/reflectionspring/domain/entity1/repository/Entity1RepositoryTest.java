package com.example.reflectionspring.domain.entity1.repository;

import com.example.reflectionspring.ReflectionSpringApplication;
import com.example.reflectionspring.domain.base.dto.BaseCreateDto;
import com.example.reflectionspring.domain.entity1.data.Entity1;
import com.example.reflectionspring.domain.entity1.dto.Entity1PartDto;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = ReflectionSpringApplication.class)
class Entity1RepositoryTest {

    @Autowired
    Entity1Repository entity1Repository;
    ObjectId id = new ObjectId();
    ObjectId parentId = new ObjectId();

    @Test
    void insertTest(){
        // given
        BaseCreateDto<Entity1PartDto> dto = BaseCreateDto.<Entity1PartDto>builder()
                .parentId(parentId)
                .parts(new ArrayList<>())
                .build();
        Entity1 entity1 = new Entity1(dto);

        // when
        Entity1 savedEntity = entity1Repository.insert(entity1);

        entity1Repository.insert(savedEntity);
        // then
    }
}
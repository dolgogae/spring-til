package com.example.reflectionspring.domain.base.mapper;

import com.example.reflectionspring.ReflectionSpringApplication;
import com.example.reflectionspring.domain.base.data.BaseEntity;
import com.example.reflectionspring.domain.base.dto.BaseCreateDto;
import com.example.reflectionspring.domain.base.dto.BaseResponseDto;
import com.example.reflectionspring.domain.entity1.data.Entity1;
import com.example.reflectionspring.domain.entity1.data.Entity1Part;
import com.example.reflectionspring.domain.entity1.dto.Entity1PartDto;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = ReflectionSpringApplication.class)
class BaseEntityMapperTest {

    BaseEntityMapper<Entity1, Entity1Part, Entity1PartDto> baseMapper
            = new BaseEntityMapper<>(Entity1.class, Entity1Part.class, Entity1PartDto.class);

    ObjectId id = new ObjectId();
    ObjectId parentId = new ObjectId();

    @Test
    void toResponseDtoTest(){
        // given

        Entity1 entity1 = getEntity1();

        // when
        BaseResponseDto<Entity1PartDto> result = baseMapper.toResponseDto(entity1);

        // then
        assertEquals(parentId, result.getParentId());
    }

    @Test
    void toPartDtoTest(){
        // given
        Entity1Part entity1Part = Entity1Part.builder()
                .name("name")
                .price(1000L)
                .product("product")
                .build();
        List<Entity1Part> entity1PartList = new ArrayList<>(List.of(entity1Part));

        // when
        List<Entity1PartDto> result = baseMapper.toPartDtoList(entity1PartList);

        // then
        assertEquals(1, result.size());
        Entity1PartDto entity1PartDto = result.get(0);
        assertEquals("name", entity1PartDto.getName());
        assertEquals(1000L, entity1PartDto.getPrice());
        assertEquals("product", entity1PartDto.getProduct());
    }

    private Entity1 getEntity1() {
        ArrayList<Entity1PartDto> partDtos = new ArrayList<>(List.of(Entity1PartDto.builder()
                .name("name")
                .price(1000L)
                .product("product").build()));
        BaseCreateDto<Entity1PartDto> createDto = BaseCreateDto.<Entity1PartDto>builder()
                .parentId(parentId)
                .parts(partDtos)
                .build();
        return new Entity1(createDto);
    }
}
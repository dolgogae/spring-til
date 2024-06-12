package com.example.reflectionspring.domain.entity1.service;

import com.example.reflectionspring.domain.base.dto.BaseCreateDto;
import com.example.reflectionspring.domain.base.dto.BaseResponseDto;
import com.example.reflectionspring.domain.base.service.BaseEntityService;
import com.example.reflectionspring.domain.entity1.data.Entity1;
import com.example.reflectionspring.domain.entity1.data.Entity1Part;
import com.example.reflectionspring.domain.entity1.dto.Entity1PartDto;
import com.example.reflectionspring.domain.entity1.repository.Entity1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Entity1Service {

    private final Entity1Repository entity1Repository;
    private final BaseEntityService<Entity1, Entity1Part, Entity1PartDto> entity1BaseService;

    public BaseResponseDto<Entity1PartDto> getEntity1(ObjectId id){
        BaseResponseDto<Entity1PartDto> responseDto = entity1BaseService.get(id, entity1Repository);
        log.info("[Entity1Service getEntity1] id: {}", id);
        return responseDto;
    }

    public BaseResponseDto<Entity1PartDto> createEntity1(ObjectId parentId, BaseCreateDto<Entity1PartDto> createDto){
        BaseResponseDto<Entity1PartDto> responseDto = entity1BaseService.create(parentId, createDto, entity1Repository);
        log.info("[Entity1Service createEntity1] id: {}, parentId: {}", responseDto.getId(), parentId);
        return responseDto;
    }
}

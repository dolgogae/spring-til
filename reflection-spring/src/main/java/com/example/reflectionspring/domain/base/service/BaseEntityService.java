package com.example.reflectionspring.domain.base.service;

import com.example.reflectionspring.domain.base.data.BaseEntity;
import com.example.reflectionspring.domain.base.dto.BaseCreateDto;
import com.example.reflectionspring.domain.base.dto.BaseResponseDto;
import com.example.reflectionspring.domain.base.mapper.BaseEntityMapper;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BaseEntityService <ENTITY extends BaseEntity<PART>, PART, PART_DTO>{

    private final Class<ENTITY> cEntity;
    private final Class<PART> cPart;
    private final Class<PART_DTO> cPartDto;
    private final BaseEntityMapper<ENTITY, PART, PART_DTO> baseEntityMapper;

    public BaseEntityService(BaseEntityMapper<ENTITY, PART, PART_DTO> baseEntityMapper,
                             Class<ENTITY> cEntity, Class<PART> cPart, Class<PART_DTO> cPartDto) {
        this.baseEntityMapper = baseEntityMapper;
        this.cEntity = cEntity;
        this.cPart = cPart;
        this.cPartDto = cPartDto;
    }

    public BaseResponseDto<PART_DTO> get(ObjectId id, MongoRepository<ENTITY, ObjectId> repository){
        ENTITY entity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("NOT EXIST"));

        return getResponseDto(entity);
    }

    private BaseResponseDto<PART_DTO> getResponseDto(ENTITY entity) {
        BaseResponseDto<PART_DTO> responseDto = baseEntityMapper.toResponseDto(entity);
        List<PART_DTO> partDtoList = baseEntityMapper.toPartDtoList(entity.getParts());
        responseDto.setParts(partDtoList);
        return responseDto;
    }

    public BaseResponseDto<PART_DTO> create(ObjectId parentId, BaseCreateDto<PART_DTO> createDto, MongoRepository<ENTITY, ObjectId> repository){
        try {
            if(!parentId.equals(createDto.getParentId())) {
                throw new RuntimeException("Parent id is not match");
            }

            ENTITY parentEntity = repository.findById(parentId).orElseThrow(() ->
                    new RuntimeException("NOT EXIST"));
            List<PART_DTO> parentEntityPartDto = baseEntityMapper.toPartDtoList(parentEntity.getParts());
            createDto.getParts().addAll(parentEntityPartDto);

            ENTITY entity = cEntity.getDeclaredConstructor(BaseCreateDto.class).newInstance(createDto);
            ENTITY savedEntity = repository.insert(entity);

            return getResponseDto(savedEntity);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

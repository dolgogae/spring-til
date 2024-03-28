package com.example.reflectionspring.domain.base.mapper;

import com.example.reflectionspring.domain.base.dto.BaseResponseDto;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseEntityMapper <ENTITY, PART, PART_DTO>{

    Class<ENTITY> cEntity;
    Class<PART> cPart;
    Class<PART_DTO> cPartDto;

    public BaseEntityMapper(Class<ENTITY> cEntity, Class<PART> cPart, Class<PART_DTO> cPartDto) {
        this.cEntity = cEntity;
        this.cPart = cPart;
        this.cPartDto = cPartDto;
    }

    // 공통 로직을 처리하는 메소드
    private void copyFields(Object source, Object target) throws IllegalAccessException {
        Map<String, Field> sourceFields = getFieldMap(source.getClass());
        Map<String, Field> targetFields = getFieldMap(target.getClass());

        for (Map.Entry<String, Field> entry : sourceFields.entrySet()) {
            String fieldName = entry.getKey();
            Field sourceField = entry.getValue();
            Field targetField = targetFields.get(fieldName);

            if (targetField != null && !List.class.isAssignableFrom(sourceField.getType())) {
                sourceField.setAccessible(true);
                targetField.setAccessible(true);
                Object value = sourceField.get(source);
                targetField.set(target, value);
            }
        }
    }

    public BaseResponseDto<PART_DTO> toResponseDto(ENTITY entity) {
        BaseResponseDto<PART_DTO> result = new BaseResponseDto<>();
        try {
            copyFields(entity, result);
            return result;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PART_DTO> toPartDtoList(List<PART> parts) {
        try {
            List<PART_DTO> result = new ArrayList<>();
            for (PART part : parts) {
                PART_DTO partDto = cPartDto.getDeclaredConstructor().newInstance();
                copyFields(part, partDto);
                result.add(partDto);
            }
            return result;
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Field> getFieldMap(Class<?> clazz) {
        Map<String, Field> fieldMap = new HashMap<>();
        ReflectionUtils.doWithFields(clazz, field -> fieldMap.put(field.getName(), field));
        return fieldMap;
    }
}

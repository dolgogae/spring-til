package com.example.reflectionspring.domain.entity1.data;

import com.example.reflectionspring.domain.base.data.BaseEntity;
import com.example.reflectionspring.domain.base.dto.BaseCreateDto;
import com.example.reflectionspring.domain.entity1.dto.Entity1PartDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collation = "entity1")
public class Entity1 extends BaseEntity<Entity1Part> {
    public Entity1(BaseCreateDto<Entity1PartDto> createDto){
        super();
        this.parentId = createDto.getParentId();
        this.parts = createDto.getParts().stream()
                .map(part -> Entity1Part.builder()
                        .name(part.getName())
                        .price(part.getPrice())
                        .product(part.getProduct())
                        .build()).toList();
    }
}

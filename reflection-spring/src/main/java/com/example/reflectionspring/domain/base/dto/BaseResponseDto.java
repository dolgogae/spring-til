package com.example.reflectionspring.domain.base.dto;

import lombok.*;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDto<T> {
    private ObjectId id;
    private ObjectId parentId;
    private List<T> parts;
}

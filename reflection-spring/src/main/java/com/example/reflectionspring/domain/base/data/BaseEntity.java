package com.example.reflectionspring.domain.base.data;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseEntity<T> {

    protected ObjectId id;
    protected ObjectId parentId;
    protected List<T> parts;
}

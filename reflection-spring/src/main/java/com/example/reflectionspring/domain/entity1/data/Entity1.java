package com.example.reflectionspring.domain.entity1.data;

import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document(collation = "entity1")
public class Entity1 {

    @Id
    private ObjectId id;
    private ObjectId parentId;

}

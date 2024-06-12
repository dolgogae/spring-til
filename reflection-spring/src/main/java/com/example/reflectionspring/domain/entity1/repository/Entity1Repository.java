package com.example.reflectionspring.domain.entity1.repository;

import com.example.reflectionspring.domain.entity1.data.Entity1;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity1Repository extends MongoRepository<Entity1, ObjectId> {
}

package com.example.reflectionspring.domain.base.dto;

import lombok.*;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseCreateDto <T>{
    private ObjectId parentId;
    private List<T> parts;
    // Private constructor to prevent direct instantiation
    private BaseCreateDto(Builder<T> builder) {
        this.parentId = builder.parentId;
        this.parts = builder.parts;
    }

    // Getters
    public ObjectId getParentId() {
        return parentId;
    }

    public List<T> getParts() {
        return parts;
    }

    // Static factory method for the Builder
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    // Builder class
    public static class Builder<T> {
        private ObjectId parentId;
        private List<T> parts;

        // Method to set parentId and return the Builder instance
        public Builder<T> parentId(ObjectId parentId) {
            this.parentId = parentId;
            return this;
        }

        // Method to set parts and return the Builder instance
        public Builder<T> parts(List<T> parts) {
            this.parts = parts;
            return this;
        }

        // Build method to create an instance of BaseCreateDto
        public BaseCreateDto<T> build() {
            return new BaseCreateDto<>(this);
        }
    }
}

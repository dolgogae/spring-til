package com.example.reflectionspring.domain.entity1.data;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Entity1Part {

    private String name;
    private Long price;
    private String product;
}

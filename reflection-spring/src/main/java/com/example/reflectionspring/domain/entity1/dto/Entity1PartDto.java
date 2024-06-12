package com.example.reflectionspring.domain.entity1.dto;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Entity1PartDto {
    private String name;
    private Long price;
    private String product;
}

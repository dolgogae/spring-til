package com.example.mapstruct.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private Long id;
    private String content;
    private String sender;
    private List<String> stringList;


}

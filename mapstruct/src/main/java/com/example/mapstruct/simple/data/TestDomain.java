package com.example.mapstruct.simple.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TestDomain {

    private Long id;
    private String content;

    @Getter
    @Builder
    public static class Entry {
        private String firstName;
        private String lastName;
    }
}

package com.example.mapstruct.test;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Master {
    private Long id;
    private List<Entry> entryList;

    @Getter
    @Builder
    public static class Entry {
        private String name;
        private String context;
    }
}

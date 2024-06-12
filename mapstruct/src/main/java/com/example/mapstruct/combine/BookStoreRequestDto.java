package com.example.mapstruct.combine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookStoreRequestDto {
    private String bookName;
    private String bookAuthor;

    private String storeAddress;
}

package com.example.mapstruct.combine;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookServiceMapper {

    BookServiceMapper INSTANCE = Mappers.getMapper(BookServiceMapper.class);

    @Mapping(source = "book.name", target = "bookName")
    @Mapping(source = "book.author", target = "bookAuthor")
    @Mapping(source = "store.address", target = "storeAddress")
    BookStoreRequestDto toBookStoreRequestDto(Book book, Store store);
}

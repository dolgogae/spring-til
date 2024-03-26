package com.example.mapstruct.combine;

import com.example.mapstruct.MapstructApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = MapstructApplication.class)
class BookServiceMapperTest {

    @Test
    void toBookStoreRequestDtoTest(){
        // given
        Book book = Book.builder()
                .name("book")
                .author("author")
                .account(1L)
                .build();

        Store store = Store.builder()
                .name("name")
                .address("address")
                .build();

        // when
        BookStoreRequestDto result = BookServiceMapper.INSTANCE.toBookStoreRequestDto(book, store);

        // then
        Assertions.assertEquals("book", result.getBookName());
        Assertions.assertEquals("author", result.getBookAuthor());
        Assertions.assertEquals("address", result.getStoreAddress());
    }
}
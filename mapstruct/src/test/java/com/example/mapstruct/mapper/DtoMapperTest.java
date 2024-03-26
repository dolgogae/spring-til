package com.example.mapstruct.mapper;

import com.example.mapstruct.MapstructApplication;
import com.example.mapstruct.simple.data.TestDomain;
import com.example.mapstruct.simple.dto.EntryDto;
import com.example.mapstruct.simple.dto.RequestDto;
import com.example.mapstruct.simple.dto.ResponseDto;
import com.example.mapstruct.simple.mapper.DtoMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = MapstructApplication.class)
class DtoMapperTest {

    @Test
    @DisplayName("RequestDto to ResponseDto mapper 테스트")
    void toResponseDtoTest(){
        // given
        RequestDto request = RequestDto.builder()
                .id(1L)
                .content("content")
                .sender("sender")
                .build();

        // when
        ResponseDto responseDto = DtoMapper.INSTANCE.toResponseDto(request);

        // then
        assertEquals(1L, responseDto.getId());
        assertEquals("content", responseDto.getContent());
        assertEquals("sender", responseDto.getSender());
    }

    @Test
    @DisplayName("TestDomain.Entry to EntryDto mapper 테스트")
    void entryTest(){
        // given
        TestDomain.Entry entry = TestDomain.Entry.builder()
                .firstName("first")
                .lastName("second")
                .build();

        // when
        EntryDto entryDto = DtoMapper.INSTANCE.toEntryDto(entry);

        // then
        assertEquals("first", entryDto.getFirstName());
        assertEquals("second", entryDto.getLastName());
    }
}
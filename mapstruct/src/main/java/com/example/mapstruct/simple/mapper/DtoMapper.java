package com.example.mapstruct.simple.mapper;

import com.example.mapstruct.simple.data.TestDomain;
import com.example.mapstruct.simple.dto.EntryDto;
import com.example.mapstruct.simple.dto.RequestDto;
import com.example.mapstruct.simple.dto.ResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoMapper {
    DtoMapper INSTANCE =  Mappers.getMapper(DtoMapper.class);

    ResponseDto toResponseDto(RequestDto requestDto);

    EntryDto toEntryDto(TestDomain.Entry entry);
}

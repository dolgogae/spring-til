package com.example.mapstruct.test;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MasterServiceMapper {

    MasterServiceMapper INSTANCE = Mappers.getMapper(MasterServiceMapper.class);

    List<Slave> toSlave(List<Master.Entry> entryList);
}

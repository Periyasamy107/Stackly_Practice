package com.example.student.mapper;

import com.example.student.dto.MapStructStdRequestDTO;
import com.example.student.dto.MapStructStdResponseDTO;
import com.example.student.entity.MapStructStdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapStructStdMapper {

    MapStructStdEntity toEntity(MapStructStdRequestDTO requestDTO);

    MapStructStdResponseDTO toResponse(MapStructStdEntity stdEntity);

    MapStructStdEntity updateEntity(MapStructStdRequestDTO requestDTO, @MappingTarget MapStructStdEntity stdEntity);


}

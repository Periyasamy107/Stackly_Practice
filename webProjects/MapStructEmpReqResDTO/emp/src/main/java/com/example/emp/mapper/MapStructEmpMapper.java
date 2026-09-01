package com.example.emp.mapper;

import com.example.emp.dto.MapStructLoginResponseDTO;
import com.example.emp.dto.MapStructRequestDTO;
import com.example.emp.dto.MapStructResponseDTO;
import com.example.emp.entity.MapStructEmpEntity;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface MapStructEmpMapper {

    MapStructEmpEntity toEntity(MapStructRequestDTO requestDTO);

    MapStructResponseDTO toResponse(MapStructEmpEntity employee);

}

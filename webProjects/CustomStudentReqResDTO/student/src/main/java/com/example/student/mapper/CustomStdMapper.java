package com.example.student.mapper;

import com.example.student.dto.CustomStdRequestDTO;
import com.example.student.dto.CustomStdResponseDTO;
import com.example.student.entity.CustomStdEntity;

public class CustomStdMapper {

    public static CustomStdEntity toEntity(CustomStdRequestDTO requestDTO) {
        CustomStdEntity stdEntity = new CustomStdEntity();
        stdEntity.setStudentName(requestDTO.getStudentName());
        stdEntity.setStudentEmail(requestDTO.getStudentEmail());
        stdEntity.setStudentAge(requestDTO.getStudentAge());
        return stdEntity;
    }

    public static CustomStdResponseDTO toResponse(CustomStdEntity stdEntity) {
        CustomStdResponseDTO responseDTO = new CustomStdResponseDTO();
        responseDTO.setStudentName(stdEntity.getStudentName());
        responseDTO.setStudentEmail(stdEntity.getStudentEmail());
        return responseDTO;
    }

    public static CustomStdEntity updateEntity(CustomStdRequestDTO requestDTO, CustomStdEntity stdEntity) {
        stdEntity.setStudentName(requestDTO.getStudentName());
        stdEntity.setStudentEmail(requestDTO.getStudentEmail());
        stdEntity.setStudentAge(requestDTO.getStudentAge());
        return stdEntity;
    }

}

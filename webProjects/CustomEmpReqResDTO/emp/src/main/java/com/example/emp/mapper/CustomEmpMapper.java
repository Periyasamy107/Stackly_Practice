package com.example.emp.mapper;

import com.example.emp.dto.CustomEmpLoginResDTO;
import com.example.emp.dto.CustomEmpRequestDTO;
import com.example.emp.dto.CustomEmpResponseDTO;
import com.example.emp.entity.CustomEmpEntity;

import java.util.Optional;

public class CustomEmpMapper {

    public static CustomEmpEntity toEntity(CustomEmpRequestDTO requestDTO) {
        CustomEmpEntity emp = new CustomEmpEntity();
        emp.setEmpName(requestDTO.getEmpName());
        emp.setEmail(requestDTO.getEmail());
        emp.setPassword(requestDTO.getPassword());
        emp.setDept(requestDTO.getDept());
        emp.setSalary(requestDTO.getSalary());
        return emp;
    }


    public static CustomEmpResponseDTO toResponse(CustomEmpEntity employee) {
        CustomEmpResponseDTO responseDTO = new CustomEmpResponseDTO();
        responseDTO.setEmpId(employee.getEmpId());
        responseDTO.setEmpName(employee.getEmpName());
        responseDTO.setDept(employee.getDept());
        responseDTO.setMessage("Employee saved success...");
        return responseDTO;
    }


    public static CustomEmpLoginResDTO toLoginResponse(Optional<CustomEmpEntity> emp) {
        CustomEmpLoginResDTO resDTO = new CustomEmpLoginResDTO();
        resDTO.setEmpName(emp.get().getEmpName());
        resDTO.setMessage("Login success...");
        return resDTO;
    }

}

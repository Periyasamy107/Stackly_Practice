package com.example.emp.service;

import com.example.emp.dto.CustomEmpLoginReqDTO;
import com.example.emp.dto.CustomEmpLoginResDTO;
import com.example.emp.dto.CustomEmpRequestDTO;
import com.example.emp.dto.CustomEmpResponseDTO;
import com.example.emp.entity.CustomEmpEntity;
import com.example.emp.mapper.CustomEmpMapper;
import com.example.emp.repo.CustomEmpRepository;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomEmpService {

    @Autowired
    private CustomEmpRepository repository;

    public CustomEmpResponseDTO saveEmployee(CustomEmpRequestDTO requestDTO) {
        CustomEmpEntity emp = CustomEmpMapper.toEntity(requestDTO);
        CustomEmpEntity employee = repository.save(emp);
        return CustomEmpMapper.toResponse(employee);
    }

    public Optional<CustomEmpLoginResDTO> loginEmployee(CustomEmpLoginReqDTO reqDTO) {
        Optional<CustomEmpEntity> employee = repository.findByEmailAndPassword(reqDTO.getEmail(), reqDTO.getPassword());
        return Optional.of(CustomEmpMapper.toLoginResponse(employee));
    }

}

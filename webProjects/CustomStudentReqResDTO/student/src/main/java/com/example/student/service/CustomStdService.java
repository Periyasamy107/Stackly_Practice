package com.example.student.service;

import com.example.student.dto.CustomStdRequestDTO;
import com.example.student.dto.CustomStdResponseDTO;
import com.example.student.entity.CustomStdEntity;
import com.example.student.mapper.CustomStdMapper;
import com.example.student.repo.CustomStdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomStdService {

    @Autowired
    private CustomStdRepository repository;

    public CustomStdResponseDTO addStudent(CustomStdRequestDTO requestDTO) {
        CustomStdEntity stdEntity = repository.save(CustomStdMapper.toEntity(requestDTO));
        return CustomStdMapper.toResponse(stdEntity);
    }

    public CustomStdResponseDTO updateStudent(Long studentId, CustomStdRequestDTO requestDTO) {
        CustomStdEntity existingStudent = repository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        repository.save(CustomStdMapper.updateEntity(requestDTO, existingStudent));
        return CustomStdMapper.toResponse(existingStudent);
    }

}

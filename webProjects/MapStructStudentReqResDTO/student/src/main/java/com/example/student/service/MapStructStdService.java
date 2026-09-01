package com.example.student.service;

import com.example.student.dto.MapStructStdRequestDTO;
import com.example.student.dto.MapStructStdResponseDTO;
import com.example.student.entity.MapStructStdEntity;
import com.example.student.mapper.MapStructStdMapper;
import com.example.student.repo.MapStructStdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapStructStdService {

    @Autowired
    private MapStructStdRepository repository;

    @Autowired
    private MapStructStdMapper mapper;

    public MapStructStdResponseDTO addStudent(MapStructStdRequestDTO requestDTO) {
        MapStructStdEntity stdEntity =repository.save(mapper.toEntity(requestDTO));
        return mapper.toResponse(stdEntity);
    }

    public MapStructStdResponseDTO updateStudent(Long studentId, MapStructStdRequestDTO requestDTO) {
        MapStructStdEntity existingStudent = repository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        repository.save(mapper.updateEntity(requestDTO, existingStudent));
        return mapper.toResponse(existingStudent);
    }

}

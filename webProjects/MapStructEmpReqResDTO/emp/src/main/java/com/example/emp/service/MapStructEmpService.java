package com.example.emp.service;

import com.example.emp.dto.MapStructLoginRequestDTO;
import com.example.emp.dto.MapStructLoginResponseDTO;
import com.example.emp.dto.MapStructRequestDTO;
import com.example.emp.dto.MapStructResponseDTO;
import com.example.emp.entity.MapStructEmpEntity;
import com.example.emp.mapper.MapStructEmpMapper;
import com.example.emp.repo.MapStructEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapStructEmpService {

    @Autowired
    private MapStructEmpRepository repository;

    @Autowired
    private MapStructEmpMapper mapper;

    public MapStructResponseDTO saveEmployee(MapStructRequestDTO requestDTO) {
        MapStructEmpEntity emp = repository.save(mapper.toEntity(requestDTO));
        MapStructResponseDTO result = mapper.toResponse(emp);
        result.setMessage("Employee saved success!!!");
        return result;
    }

    public MapStructLoginResponseDTO loginEmployee(MapStructLoginRequestDTO requestDTO) {
        Optional<MapStructEmpEntity> emp = repository.findByEmailAndPassword(requestDTO.getEmail(), requestDTO.getPassword());
        MapStructLoginResponseDTO result =  new MapStructLoginResponseDTO();
        result.setEmpName(emp.get().getEmpName());
        result.setMessage("Login successful!!!");
        return result;
    }

}

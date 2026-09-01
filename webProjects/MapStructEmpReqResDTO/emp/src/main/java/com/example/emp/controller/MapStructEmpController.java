package com.example.emp.controller;

import com.example.emp.dto.MapStructLoginRequestDTO;
import com.example.emp.dto.MapStructLoginResponseDTO;
import com.example.emp.dto.MapStructRequestDTO;
import com.example.emp.dto.MapStructResponseDTO;
import com.example.emp.service.MapStructEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class MapStructEmpController {

    @Autowired
    private MapStructEmpService service;

    @PostMapping("/map-struct/save")
    public MapStructResponseDTO saveEmployee(@RequestBody MapStructRequestDTO requestDTO) {
        return service.saveEmployee(requestDTO);
    }


    @PostMapping("/map-struct/login")
    public MapStructLoginResponseDTO loginEmployee(@RequestBody MapStructLoginRequestDTO requestDTO) {
        return service.loginEmployee(requestDTO);
    }
}

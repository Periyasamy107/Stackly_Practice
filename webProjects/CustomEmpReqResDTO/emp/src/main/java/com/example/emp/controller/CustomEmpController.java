package com.example.emp.controller;

import com.example.emp.dto.CustomEmpLoginReqDTO;
import com.example.emp.dto.CustomEmpLoginResDTO;
import com.example.emp.dto.CustomEmpRequestDTO;
import com.example.emp.dto.CustomEmpResponseDTO;
import com.example.emp.service.CustomEmpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class CustomEmpController {

    private final CustomEmpService service;

    public CustomEmpController(CustomEmpService service) {
        this.service = service;
    }

    @PostMapping("custom/save")
    public CustomEmpResponseDTO saveEmployee(@RequestBody CustomEmpRequestDTO requestDTO) {
        return service.saveEmployee(requestDTO);
    }

    @PostMapping("/custom/login")
    public Optional<CustomEmpLoginResDTO> loginEmployee(@RequestBody CustomEmpLoginReqDTO reqDTO) {
        return service.loginEmployee(reqDTO);
    }
}

package com.example.emp.controller;

import com.example.emp.dto.LoginRequestDTO;
import com.example.emp.dto.LoginResponseDTO;
import com.example.emp.dto.RequestDTO;
import com.example.emp.dto.ResponseDTO;
import com.example.emp.service.NormalEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class NormalEmpController {

    @Autowired
    private NormalEmpService service;

    @PostMapping("/save")
    public ResponseDTO saveEmployee(@RequestBody RequestDTO requestDTO) {
        return service.saveEmployee(requestDTO);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return service.login(loginRequestDTO);
    }

}

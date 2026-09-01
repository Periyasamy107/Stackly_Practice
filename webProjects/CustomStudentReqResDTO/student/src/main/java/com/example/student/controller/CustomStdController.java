package com.example.student.controller;

import com.example.student.dto.CustomStdRequestDTO;
import com.example.student.dto.CustomStdResponseDTO;
import com.example.student.service.CustomStdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class CustomStdController {

    @Autowired
    private CustomStdService service;

    @PostMapping("/custom/save")
    public CustomStdResponseDTO saveStudent(@RequestBody CustomStdRequestDTO requestDTO) {
        return service.addStudent(requestDTO);
    }

    @PutMapping("/custom/update/{studentId}")
    public CustomStdResponseDTO updateStudent(@PathVariable Long studentId, @RequestBody CustomStdRequestDTO requestDTO) {
        return service.updateStudent(studentId, requestDTO);
    }

}

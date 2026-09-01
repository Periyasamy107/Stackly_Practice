package com.example.student.controller;

import com.example.student.dto.NormalStdRequestDTO;
import com.example.student.dto.NormalStdResponseDTO;
import com.example.student.service.NormalStdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class NormalStdController {

    @Autowired
    private NormalStdService service;

    @PostMapping("/normal/save")
    public NormalStdResponseDTO saveStudent(@RequestBody NormalStdRequestDTO requestDTO) {
        return service.addNewStudent(requestDTO);
    }

    @PutMapping("/normal/update/{studentId}")
    public NormalStdResponseDTO updateStudent(@PathVariable Long studentId, @RequestBody NormalStdRequestDTO requestDTO) {
        return service.updateStudent(studentId, requestDTO);
    }

}

package com.example.student.controller;

import com.example.student.dto.MapStructStdRequestDTO;
import com.example.student.dto.MapStructStdResponseDTO;
import com.example.student.service.MapStructStdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.persistenceunit.SpringPersistenceUnitInfoRuntimeHints;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class MapStructStdController {

    @Autowired
    private MapStructStdService service;

    @PostMapping("/map-struct/save")
    public MapStructStdResponseDTO addStudent(@RequestBody MapStructStdRequestDTO requestDTO) {
        return service.addStudent(requestDTO);
    }

    @PutMapping("/map-struct/update/{studentId}")
    public MapStructStdResponseDTO updateStudent(@PathVariable Long studentId, @RequestBody MapStructStdRequestDTO requestDTO) {
        return service.updateStudent(studentId, requestDTO);
    }

}

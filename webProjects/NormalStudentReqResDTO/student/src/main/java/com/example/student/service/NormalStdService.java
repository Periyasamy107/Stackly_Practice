package com.example.student.service;

import com.example.student.dto.NormalStdRequestDTO;
import com.example.student.dto.NormalStdResponseDTO;
import com.example.student.entity.NormalStdEntity;
import com.example.student.repo.NormalStdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NormalStdService {

    @Autowired
    private NormalStdRepository repository;

    public NormalStdResponseDTO addNewStudent(NormalStdRequestDTO stdRequestDTO) {
        NormalStdEntity student = new NormalStdEntity();
        student.setStudentName(stdRequestDTO.getStudentName());
        student.setStudentEmail(stdRequestDTO.getStudentEmail());
        student.setStudentAge(stdRequestDTO.getStudentAge());

        NormalStdEntity savedStudent = repository.save(student);

        NormalStdResponseDTO stdResponseDTO = new NormalStdResponseDTO();
        stdResponseDTO.setStudentName(savedStudent.getStudentName());
        stdResponseDTO.setStudentEmail(savedStudent.getStudentEmail());

        return stdResponseDTO;

    }

    public NormalStdResponseDTO updateStudent(Long studentId, NormalStdRequestDTO stdRequestDTO) {
        NormalStdEntity existingStudent = repository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setStudentName(stdRequestDTO.getStudentName());
        existingStudent.setStudentEmail(stdRequestDTO.getStudentEmail());
        existingStudent.setStudentAge(stdRequestDTO.getStudentAge());

        NormalStdEntity updatedStudent = repository.save(existingStudent);

        NormalStdResponseDTO responseDTO = new NormalStdResponseDTO();

        responseDTO.setStudentName(updatedStudent.getStudentName());
        responseDTO.setStudentEmail(updatedStudent.getStudentEmail());

        return responseDTO;
    }

}

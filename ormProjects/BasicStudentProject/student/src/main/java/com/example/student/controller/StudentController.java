package com.example.student.controller;

import com.example.student.dto.StudentDTO;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/add")
    public Student addStudent(@RequestBody StudentDTO studentDTO) {
        return service.addStudent(studentDTO);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/student/{studentId}")
    public Student findByStudentId(@PathVariable Integer studentId) {
        return service.findByStudentId(studentId);
    }

    @DeleteMapping("/student/{studentId}")
    public String deleteStudentById(@PathVariable Integer studentId) {
        return service.deleteStudentById(studentId);
    }

    @PutMapping("/updateStudent/{studentId}")
    public String updateStudent(@PathVariable Integer studentId, @RequestBody StudentDTO studentDTO) {
        return service.updateStudent(studentId, studentDTO);
    }

    @GetMapping("/count")
    public long getCount() {
        return service.getCount();
    }

    @GetMapping("/getByName/{studentName}")
    public Student findByName(@PathVariable String studentName) {
        return service.findByName(studentName);
    }

    @GetMapping("/countByAge/{studentAge}")
    public long getCountByAge(@PathVariable Integer studentAge) {
        return service.getCountByAge(studentAge);
    }

    @GetMapping("/exists/{studentName}")
    public boolean existsByStudentName(@PathVariable String studentName) {
        return service.existsByStudentName(studentName);
    }


}

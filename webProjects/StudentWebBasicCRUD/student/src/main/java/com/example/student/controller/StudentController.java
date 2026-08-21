package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/web")
public class StudentController {

    private StudentService studentService;

    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@Valid @PathVariable int studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/addStudent")
    public String addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/insertStudent")
    public Student insertStudent(@Valid @RequestBody Student student) {
        return studentService.insertStudent(student);
    }

    @PutMapping("/fullUpdate/{studentId}")
    public String singleStudentUpdate(@Valid @PathVariable int studentId, @RequestBody Student student) {
        return studentService.singleStudentUpdate(studentId, student);
    }

    @PatchMapping("/partialUpdate/{studentId}")
    public String partialUpdate(@Valid @PathVariable int studentId, @RequestBody Student student) {
        return studentService.partialUpdate(studentId, student);
    }

    @DeleteMapping("/removeStudent/{studentId}")
    public String removeStudent(@Valid @PathVariable int studentId) {
        return studentService.removeStudent(studentId);
    }

}

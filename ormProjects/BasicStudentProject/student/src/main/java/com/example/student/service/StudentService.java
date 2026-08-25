package com.example.student.service;

import com.example.student.dto.StudentDTO;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student findByStudentId(Integer studentId) {
        return repo.findById(studentId).orElse(null);
    }

    public String deleteStudentById(Integer studentId) {
        Student student = repo.findById(studentId).orElse(null);
        if(student!=null) {
            repo.deleteById(studentId);
            return "Student deleted successfully.";
        }
        return "Student not found for the ID : " + studentId;
    }

    public String updateStudent(Integer studentId, StudentDTO studentDTO) {
        Student existingStudent = repo.findById(studentId).orElse(null);
        existingStudent.setName(studentDTO.getName());
        existingStudent.setAge(studentDTO.getAge());
        repo.save(existingStudent);
        return "Student updated successfully.";
    }

    public long getCount() {
        return repo.count();
    }

    public Student findByName(String studentName) {
        return repo.findByName(studentName);
    }

    public long getCountByAge(Integer studentAge) {
        return repo.countByAge(studentAge);
    }

    public boolean existsByStudentName(String studentName) {
        return repo.existsByName(studentName);
    }

}

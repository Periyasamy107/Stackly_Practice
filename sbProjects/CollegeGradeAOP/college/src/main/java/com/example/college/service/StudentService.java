package com.example.college.service;

import com.example.college.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void addStudent(Student student) {
        System.out.println("Student added successfully.");
        System.out.println("Student Name : " + student.getStudentName());
    }

    public String calculateGrade(Student student) {
        int marks = student.getMarks();
        if(marks<0 || marks>100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }

        if(marks>=90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public String calculateResult(Student student) {
        int marks = student.getMarks();
        if(marks<0 || marks>100) {
            throw new IllegalArgumentException("Invalid Marks");
        }
        if(marks>=50) {
            return "PASS";
        }
        return "FAIL";
    }

    public Student getStudent(int studentId) {
        return new Student(studentId, "Sam", 30);
    }

}

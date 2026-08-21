package com.example.student.service;

import com.example.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> studentsList = new ArrayList<>(Arrays.asList(
            new Student(1,"Sam","java",33,"sam.java@gmail.com"),
            new Student(2,"Tom","python",26,"tom.python@gmail.com"),
            new Student(3,"Ram","java",44,"ram.java@gmail.com")
    ));

    public List<Student> getAllStudents() {
        return studentsList;
    }

    public Student getStudentById(int studentId) {
        for(Student student : studentsList) {
            if(student.getStudentId()==studentId) {
                return student;
            }
        }
        return null;
    }

    public String addStudent(Student student) {
        studentsList.add(student);
        return "Student added successfully.";
    }

    public Student insertStudent(Student student) {
        studentsList.add(student);
        return student;
    }

    public String singleStudentUpdate(int studentId, Student newStudent) {
        for(Student oldStudent : studentsList) {
            if(oldStudent.getStudentId() == studentId) {
                oldStudent.setStudentId(newStudent.getStudentId());
                oldStudent.setStudentName(newStudent.getStudentName());
                oldStudent.setCourse(newStudent.getCourse());
                oldStudent.setEmail(newStudent.getEmail());
                oldStudent.setAge(newStudent.getAge());
                return "Student single object updated success.";
            }
        }
        return "Student not found for update.";
    }

    public String partialUpdate(int studentId, Student student) {
        for(Student oldStudent : studentsList){
            if(studentId == oldStudent.getStudentId()) {
                oldStudent.setEmail(student.getEmail());
                oldStudent.setCourse(student.getCourse());
                return "Student partial update success.";
            }
        }
        return "Student not found for partial update.";
    }

    public String removeStudent(int studentId) {
        for(Student student : studentsList) {
            if(student.getStudentId() == studentId) {
                studentsList.remove(student);
                return "Single student object removed success.";
            }
        }
        return "Student not found for deletion";
    }

}

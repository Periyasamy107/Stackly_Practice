package com.example.college;

import com.example.college.model.Student;
import com.example.college.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CollegeGradeAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegeGradeAopApplication.class, args);
    }

    @Bean
    CommandLineRunner run(StudentService studentService) {

        return  args -> {
            System.out.println();
            System.out.println("======================================");
            System.out.println("COLLEGE GRADE MANAGEMENT SYSTEM");
            System.out.println("======================================");

            Student student = new Student(101, "Sam", 30);

            System.out.println();
            System.out.println("1. ADD STUDENT");
            studentService.addStudent(student);

            System.out.println();
            System.out.println("2. CALCULATE GRADE");
            String grade = studentService.calculateGrade(student);
            System.out.println("Final Grade : " + grade);

            System.out.println();
            System.out.println("3. CALCULATE RESULT");
            String result = studentService.calculateResult(student);
            System.out.println("Final Result : " + result);

            System.out.println();
            System.out.println("4. GET A STUDENT");
            Student studentDetails = studentService.getStudent(101);
            System.out.println("Student : " + studentDetails);
        };

    }
}

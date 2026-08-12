package com.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppConfig {

    @Bean
    public Student getStudent() {
        Student student = new Student();
        student.setId(100);
        student.setName("Lina");
        return student;
    }

    @Bean
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        Student std1 = new Student();
        std1.setId(1000);
        std1.setName("Yolish");

        Student std2 = new Student();
        std2.setId(2000);
        std2.setName("William");

        students.add(std1);
        students.add(std2);

        return students;
    }



}

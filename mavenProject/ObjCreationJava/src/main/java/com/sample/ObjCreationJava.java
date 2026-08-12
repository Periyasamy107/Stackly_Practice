package com.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ObjCreationJava {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Student student = context.getBean(Student.class);
        student.display();

        System.out.println();

        List<Student> students = (List<Student>)context.getBean("getStudents");

        students.forEach(student1 -> student1.display());

    }

}

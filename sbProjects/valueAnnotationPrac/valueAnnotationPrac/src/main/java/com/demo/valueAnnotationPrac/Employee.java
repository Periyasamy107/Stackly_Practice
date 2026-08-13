package com.demo.valueAnnotationPrac;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Value("111")
    private int empId;

    @Value("Lioni")
    private String name;

    @Value("#{department.deptName}")
    private String depName;

    @Value("#{department.deptId}")
    private int depId;

    @Value("#{department.basicSalary + (department.basicSalary * 0.10)}")
    private double salary;

    @Value("#{systemProperties['user.name']}")
    private String userName;

    @PostConstruct
    public void display() {
        System.out.println("Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", depName='" + depName + '\'' +
                ", depId=" + depId +
                ", salary=" + salary +
                ", userName='" + userName + '\'' +
                '}');
    }
}

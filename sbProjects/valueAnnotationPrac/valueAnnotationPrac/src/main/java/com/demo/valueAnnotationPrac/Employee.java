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
        System.out.println();
        System.out.println("Employee : ");
        System.out.println("=============================");
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Department Name : " + depName);
        System.out.println("Department ID : " + depId);
        System.out.println("Employee Salary : " + salary);
        System.out.println("System User Name : " + userName);
        System.out.println();
    }
}

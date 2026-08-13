package com.demo.valueAnnotationPrac;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Department {

    @Value("IT")
    private String deptName;

    @Value("100")
    private int deptId;

    @Value("30000")
    private double basicSalary;

    public String getDeptName() {
        return deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}

package com.demo.lombokEmpPayroll.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payroll {
    private String payrollId;
    private Employee employee;
    private Salary salary;
    private double grossSalary;
    private double netSalary;
}

package com.demo.lombokEmpPayroll.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Salary {
    private String salaryId;
    private double basicSalary;
    private double hra;
    private double allowance;
    private double deduction;
    private double pf;
    private double insurance;
}

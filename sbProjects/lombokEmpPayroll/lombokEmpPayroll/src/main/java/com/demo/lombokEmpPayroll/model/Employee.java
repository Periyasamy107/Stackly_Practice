package com.demo.lombokEmpPayroll.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String employeeId;
    private String employeeName;
    private String department;
    private String designation;
}

package com.example.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomEmpRequestDTO {

    private String empName;
    private String email;
    private String password;
    private String dept;
    private double salary;

}

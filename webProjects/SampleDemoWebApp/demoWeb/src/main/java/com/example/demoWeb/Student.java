package com.example.demoWeb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private int studentId;
    private String studentName;
    private int age;
    private int marks;
    private String email;
}

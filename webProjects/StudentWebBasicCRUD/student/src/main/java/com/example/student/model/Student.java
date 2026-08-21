package com.example.student.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @NotNull(message = "id field cannot be null")
    @NotBlank(message = "id field cannot be blank")
    private int studentId;

    @NotBlank(message = "name field cannot be blank")
    private String studentName;

    @NotBlank(message = "course field cannot be blank")
    private String course;

    @Min(value = 18, message = "age should be greater than 18")
    private int age;

    @Email(message = "email should have the right format")
    @NotBlank(message = "email field cannot be blank")
    private String email;

}

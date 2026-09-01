package com.example.student.dto;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.hibernate.SpringImplicitNamingStrategy;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NormalStdRequestDTO {

    private String studentName;
    private String studentEmail;
    private int studentAge;


}

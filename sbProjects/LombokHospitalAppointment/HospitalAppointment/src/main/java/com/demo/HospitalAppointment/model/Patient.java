package com.demo.HospitalAppointment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Patient {
    private String patientId;
    private String patientName;
    private int age;
    private String gender;
}

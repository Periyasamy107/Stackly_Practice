package com.demo.HospitalAppointment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Doctor {
    private String doctorId;
    private String doctorName;
    private String specialization;
    private double consultationFee;
}

package com.demo.HospitalAppointment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Appointment {
    private String appointmentId;
    private Doctor doctor;
    private Patient patient;
    private String appointmentDate;
    private String appointmentTime;
}

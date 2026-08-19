package com.example.hospital.service;

import com.example.hospital.annotation.RequiresRole;
import com.example.hospital.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @RequiresRole("RECEPTIONIST")
    public void registerPatient(Patient patient) {
        System.out.println("Patient registered : " + patient.getPatientName());
    }

    @RequiresRole("DOCTOR")
    public Patient viewPatient(int patientId) {
        return new Patient(patientId, "Sam", 35, "Fever");
    }

    @RequiresRole("DOCTOR")
    public void updatePatient(Patient patient) {
        System.out.println("Patient updated : " + patient.getPatientName());
    }

    @RequiresRole("ADMIN")
    public void deletePatient(int patientId) {
        System.out.println("Patient deleted : " + patientId);
    }

}

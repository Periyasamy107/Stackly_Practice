package com.example.hospital;

import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalPatientAopApplication {

	public static void main(String[] args) {
        SpringApplication.run(HospitalPatientAopApplication.class, args);
	}

    @Bean
    CommandLineRunner run(PatientService service) {

        return args -> {
          Patient patient = new Patient(101,"Sam",35,"Fever");
            System.out.println("===================================");
            System.out.println("HOSPITAL PATIENT MANAGEMENT SYSTEM");
            System.out.println("===================================");

            System.out.println("\n1. Register Patient");
            try {
                service.registerPatient(patient);
            } catch (Exception e) {
                System.out.println("Operation Failed: " + e.getMessage());
            }

            System.out.println("\n2. View Patient");
            try {
                Patient patientDetails = service.viewPatient(101);
                System.out.println("Patient: " + patientDetails);
            } catch (Exception e) {
                System.out.println("Operation Failed: " + e.getMessage());
            }

            System.out.println("\n3. Update Patient");
            try {
                service.updatePatient(patient);
            } catch (Exception e) {
                System.out.println("Operation Failed: " + e.getMessage());
            }

            System.out.println("\n4. Delete Patient");
            try {
                service.deletePatient(101);
            } catch (Exception e) {
                System.out.println("Operation Failed: " + e.getMessage());
            }

        };

    }

}

package com.demo.HospitalAppointment.service;

import com.demo.HospitalAppointment.model.Appointment;
import com.demo.HospitalAppointment.model.Doctor;
import com.demo.HospitalAppointment.model.Patient;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


@Service
public class HospitalAppointmentService {

    public void displayAppointments(Appointment appointment) {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("       Patient Details : ");
        System.out.println("----------------------------------------");
        System.out.println("Patient ID : " + appointment.getPatient().getPatientId());
        System.out.println("Patient Name : " + appointment.getPatient().getPatientName());
        System.out.println("Patient Age : " + appointment.getPatient().getAge());
        System.out.println("Patient Gender : " + appointment.getPatient().getGender());
        System.out.println();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("       Doctor Details : ");
        System.out.println("----------------------------------------");
        System.out.println("Doctor ID : " + appointment.getDoctor().getDoctorId());
        System.out.println("Doctor Name : " + appointment.getDoctor().getDoctorName());
        System.out.println("Specialization : " + appointment.getDoctor().getSpecialization());
        System.out.println("Consulting Fee : " + appointment.getDoctor().getConsultationFee());
        System.out.println();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("       Appointment Details : ");
        System.out.println("----------------------------------------");
        System.out.println("Appointment ID : " + appointment.getAppointmentId());
        System.out.println("Doctor Name : " + appointment.getDoctor().getDoctorName());
        System.out.println("Doctor Specialization : " + appointment.getDoctor().getSpecialization());
        System.out.println("Patient Name : " + appointment.getPatient().getPatientName());
        System.out.println("Patient Age : " + appointment.getPatient().getAge());
        System.out.println("Patient Gender : " + appointment.getPatient().getGender());
        System.out.println("Appointment Date : " + appointment.getAppointmentDate());
        System.out.println("Appointment Time : " + appointment.getAppointmentTime());
        System.out.println();


    }

    @PostConstruct
    public void output() {
        Patient patient = Patient.builder()
                .patientId("Patient01")
                .patientName("Parvathi")
                .age(45)
                .gender("Female")
                .build();

        Doctor doctor = Doctor.builder()
                .doctorId("Doctor01")
                .doctorName("Dinegaran")
                .specialization("Surgury")
                .consultationFee(500)
                .build();

        Appointment appointment = Appointment.builder()
                .appointmentId("Appointment01")
                .patient(patient)
                .doctor(doctor)
                .appointmentDate("17-08-2026")
                .appointmentTime("11:30 AM")
                .build();

        HospitalAppointmentService service = new HospitalAppointmentService();

        service.displayAppointments(appointment);

    }

}

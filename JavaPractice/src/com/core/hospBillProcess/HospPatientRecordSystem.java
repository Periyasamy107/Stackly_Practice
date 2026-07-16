package com.core.hospBillProcess;

import java.util.Scanner;

public class HospPatientRecordSystem {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  HOSPITAL PATIENT BILL PROCESS SYSTEM");
        System.out.println("========================================");
        System.out.println();

        String[] diseases = {"Cardiology", "Neurology", "Orthopedics"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("1) " + diseases[0]);
        System.out.println("2) " + diseases[1]);
        System.out.println("3) " + diseases[2]);
        System.out.print("Please select 1/2/3 : ");
        int diseaseSelection = scanner.nextInt();

        int dieseaseTreatmentFees = 0;
        String selectDisease = "";

        if(diseaseSelection == 1) {
            dieseaseTreatmentFees = 35000;
            selectDisease = diseases[0];
        } else if (diseaseSelection == 2) {
            dieseaseTreatmentFees = 40000;
            selectDisease = diseases[1];
        } else if (diseaseSelection == 3){
            dieseaseTreatmentFees = 50000;
            selectDisease = diseases[2];
        }

        System.out.println();
        System.out.print("Number of days stayed : ");
        int days = scanner.nextInt();
        System.out.println();

        HospitalPatient hospitalPatient = new HospitalPatient();

        hospitalPatient.setId(34);
        hospitalPatient.setName("Ram");
        hospitalPatient.setDisease(selectDisease);

        hospitalPatient.display(dieseaseTreatmentFees, days);

        scanner.close();

        System.out.println("----------------------------------------");
    }

}

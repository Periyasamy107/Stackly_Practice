package com.core.hospBillProcess;

public class HospitalPatient {

    public static final int DAY_CHARGE = 1000;

    int id;
    String name;
    String disease;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDisease() {
        return this.disease;
    }

    public int bill(int dieseaseTreatmentFees, int days) {
        return dieseaseTreatmentFees + (DAY_CHARGE * days);
    }

    public void display(int dieseaseTreatmentFees, int days) {
        System.out.println("ID : " + getId());
        System.out.println("Name : " + getName());
        System.out.println("Disease : " + getDisease());
        System.out.println("Total Bill : " + bill(dieseaseTreatmentFees, days));
    }
}
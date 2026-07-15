package com.java.empSalary;

public class Manager extends Employee {
    double bonus = 5000;

    Manager(int id, String name, double basicSalary) {
        super(id, name, basicSalary);
    }

    public double calculateSalary(double basicSalary) {
        return basicSalary + 10000 + bonus;
    }

    public void display() {
        super.display();
    }
}
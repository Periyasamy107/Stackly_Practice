package com.java.empSalary;

public class Developer extends Employee {
    double bonus = 3000;

    Developer(int id, String name, double basicSalary) {
        super(id, name, basicSalary);
    }

    public double calculateSalary(double basicSalary) {
        return basicSalary + 10000 + bonus;
    }

    public void display() {
        super.display();
    }
}

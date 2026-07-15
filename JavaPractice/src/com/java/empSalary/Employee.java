package com.java.empSalary;

public class Employee {
    int id;
    String name;
    double basicSalary;

    Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary(double basicSalary) {
        return basicSalary + 10000;
    }

    public void display() {
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Basic Salary : " + basicSalary);
        System.out.println("Net Salary : " + calculateSalary(basicSalary));
    }

}

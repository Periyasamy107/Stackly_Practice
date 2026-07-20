package com.stream;

public class EmployeeBase {

    int id;
    String name;
    double salary;

    EmployeeBase(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }

}
package com.example.payroll.service;

import com.example.payroll.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {

    public void addEmployee(Employee employee) {
        if(employee.getBasicSalary()<=0) {
            throw new IllegalArgumentException("Basic Salary Must Be Greate Than Zero");
        }
        System.out.println("Employee Added : " + employee.getEmployeeName());
    }

    public double calculateNetSalary(Employee employee) {
        if(employee.getBasicSalary()<=0) {
            throw new IllegalArgumentException("Invalid Basic Salary");
        }
        double grossSalary = employee.getBasicSalary() + employee.getAllowance();
        double tax = grossSalary * 0.10;
        return grossSalary - tax;
    }

    public String generatePayslip(Employee employee) {
        double grossSalary = employee.getBasicSalary() + employee.getAllowance();
        double tax = grossSalary * 0.10;
        double netSalary = grossSalary - tax;
        return "Employee : " + employee.getEmployeeName() +
                ", Gross Salary : " + grossSalary +
                ", Tax : " + tax +
                ", Net Salary : " + netSalary;
    }

}

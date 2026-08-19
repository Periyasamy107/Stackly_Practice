package com.example.payroll;

import com.example.payroll.model.Employee;
import com.example.payroll.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePayrollAopApplication implements CommandLineRunner {

    @Autowired
    private PayrollService payrollService;

	public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollAopApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee(101,"Sam",15000,5000);
        System.out.println("\nEMPLOYEE PAYROLL SYSTEM");
        System.out.println("\n1. Add Employee");
        payrollService.addEmployee(employee);

        System.out.println("\n2. Calculate Net Salary");
        double netSalary = payrollService.calculateNetSalary(employee);
        System.out.println("Net Salary : " + netSalary);

        System.out.println("\n3. Generate The Payslip");
        String payslip = payrollService.generatePayslip(employee);
        System.out.println(payslip);
    }
}

package com.demo.lombokEmpPayroll;

import com.demo.lombokEmpPayroll.model.Employee;
import com.demo.lombokEmpPayroll.model.Payroll;
import com.demo.lombokEmpPayroll.model.Salary;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService {

    public static void displayEmployeePayrollDetails(Payroll payroll) {

        System.out.println();
        System.out.println("==========================");
        System.out.println("Employee Details:");
        System.out.println("==========================");
        System.out.println("Employee ID : " + payroll.getEmployee().getEmployeeId());
        System.out.println("Employee Name : " + payroll.getEmployee().getEmployeeName());
        System.out.println("Department : " + payroll.getEmployee().getDepartment());
        System.out.println("Designation : " + payroll.getEmployee().getDesignation());
        System.out.println();

        System.out.println("==========================");
        System.out.println("Salary Details:");
        System.out.println("==========================");
        System.out.println("Salary ID : " + payroll.getSalary().getSalaryId());
        System.out.println("Basic Salary : " + payroll.getSalary().getBasicSalary());
        System.out.println("HRA : " + payroll.getSalary().getHra());
        System.out.println("Allowance : " + payroll.getSalary().getAllowance());
        System.out.println("Deduction : " + payroll.getSalary().getDeduction());
        System.out.println("PF : " + payroll.getSalary().getPf());
        System.out.println("Insurance : " + payroll.getSalary().getInsurance());
        System.out.println();

        System.out.println("==========================");
        System.out.println("Payroll Details:");
        System.out.println("==========================");
        System.out.println("Payroll ID : " + payroll.getPayrollId());
        System.out.println("Gross Salary : " + payroll.getGrossSalary());
        System.out.println("Net Salary : " + payroll.getNetSalary());
        System.out.println();

    }


    @PostConstruct
    public void display() {
        Employee employee = Employee.builder()
                .employeeId("E01")
                .employeeName("Sam")
                .department("IT")
                .designation("Java Developer")
                .build();

        Salary salary = Salary.builder()
                .salaryId("S01")
                .basicSalary(15000)
                .hra(3000)
                .allowance(5000)
                .deduction(2500)
                .pf(1500)
                .insurance(400)
                .build();

        Payroll payroll = Payroll.builder()
                .payrollId("P01")
                .employee(employee)
                .salary(salary)
                .grossSalary(salary.getBasicSalary() +
                        salary.getHra() +
                        salary.getAllowance() +
                        salary.getDeduction() +
                        salary.getPf() +
                        salary.getInsurance()
                )
                .netSalary((salary.getBasicSalary() +
                        salary.getHra() +
                        salary.getAllowance() +
                        salary.getDeduction() +
                        salary.getPf() +
                        salary.getInsurance())
                        -
                        (salary.getPf() + salary.getInsurance() + salary.getDeduction()))
                .build();
        displayEmployeePayrollDetails(payroll);
    }

}

package com.java.basic1;

import java.util.Scanner;

public class EmpSalaryProcessingUsingArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("===================================================");
        System.out.println("  EMPLOYEE SALARY PROCESSING PROGRAM USING ARRAY   ");
        System.out.println("===================================================");

        System.out.print("Number of employees : ");
        int emps = scanner.nextInt();
        System.out.print("Number of months : ");
        int months = scanner.nextInt();

        int[][] salaries = new int[emps][months];

        for(int i=0; i<emps; i++) {
            for(int j=0; j<months; j++) {
                System.out.print("Employee "+(i+1)+" month "+(j+1)+" salary is : ");
                int salary = scanner.nextInt();
                salaries[i][j] = salary;
            }
            System.out.println();
        }

        int highestSalaryEmployee = 1;
        int individualHighestMonth = 1;
        int highestSalary = salaries[0][0];
        int[] employeesOverallSalary = new int[emps];

        for(int i=0; i<emps; i++) {
            int temp = 0;
            for(int j=0; j<months; j++) {
                temp += salaries[i][j];
                if(salaries[i][j] > highestSalary) {
                    highestSalary = salaries[i][j];
                    highestSalaryEmployee = i+1;
                    individualHighestMonth = j+1;
                }
            }
            employeesOverallSalary[i] = temp;
        }

        int highestSalaryEmployeeOverall = 1;
        int highestSalaryOverall = 0;

        for(int i=0; i<employeesOverallSalary.length; i++) {
            if(employeesOverallSalary[i] > highestSalaryEmployeeOverall) {
                highestSalaryEmployeeOverall = employeesOverallSalary[i];
                highestSalaryOverall = i+1;
            }
        }

        System.out.println("Employee "+highestSalaryEmployee+" is paid the highest salary of "+highestSalary+" on "+ individualHighestMonth +" month");
        System.out.println("Employee "+highestSalaryOverall+" is paid the highest salary of "+highestSalaryEmployeeOverall+" on the "+months+" months basis.");

        System.out.println("-----------------------------------------------------------------------------------");
        scanner.close();

    }
}

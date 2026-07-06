package com.java.basic;

import java.util.Scanner;


public class EmpPayrollProcessingSystem {

	public static void main(String[] args) {

		/** =========================================================================
		 *                     EMPLOYEE PAYROLL PAYMENT SYSTEM
		 *  =========================================================================
		 *  
		 *  Objective:
		 *  ------------
		 *  
		 *  1. Employee Details
		 *  2. Basic Salary
		 *  3. Allowances
		 *  4. Deductions
		 *  5. Gross Salary
		 *  6. Net Salary
		 *  
		 *  =========================================================================
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		
		/*======================================================
         * EMPLOYEE DETAILS
         *======================================================
         */
		
		System.out.println("Employee Details");
		System.out.println("-----------------------");
		
		System.out.print("Employee ID             : " );
		int empID = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Employee Name           : ");
		String empName = scanner.nextLine();
		
		System.out.print("Employee Department     : ");
		String empDept = scanner.nextLine();
		
		System.out.print("Employee Designation    : ");
		String empDesig = scanner.nextLine();
		
		System.out.print("Years Of Experiencing   : ");
		int empYOE = scanner.nextInt();
		
		System.out.print("Basic Salary (Rupees)   : ");
		double basicSalary = scanner.nextDouble();
		
		scanner.close();
		
		
		/*======================================================
         * ALLOWANCES
         *======================================================
         *
         * DA  = 20%  (Dearness Allowance)
         * HRA = 15%  (House Rent Allowance)
         * MA  = 5%   (Medical Allowance)
         * TA  = 8%   (Travel Allowance)
         * SA  = 10%  (Special Allowance)
         * 
         */
		
		double da  = basicSalary * 0.20;
		double hra = basicSalary * 0.15;
		double ma  = basicSalary * 0.05;
		double ta  = basicSalary * 0.08;
		double sa  = basicSalary * 0.10;
		
		
		/*======================================================
         * BONUS
         *======================================================
         */
		
		double bonus = 0;
		
		if(empYOE <= 2 && empDesig.toLowerCase().contains("associate") && empDept.toLowerCase().equals("it")) {
			bonus = basicSalary * 0.02;
		} else if (empYOE <= 2 && empDesig.toLowerCase().contains("associate") && empDept.toLowerCase().equals("development")) {
			bonus = basicSalary * 0.03;
		} else if (empYOE >= 3 && empYOE <= 5 && empDesig.toLowerCase().contains("junior") && empDept.toLowerCase().equals("it")) {
			bonus = basicSalary * 0.04;
		} else if (empYOE >= 3 && empYOE <= 5 && empDesig.toLowerCase().contains("junior") && empDept.toLowerCase().equals("development")) {
			bonus = basicSalary * 0.05;
		} else if (empYOE >= 5 && empYOE <= 10 && empDesig.toLowerCase().contains("senior") && empDept.toLowerCase().equals("it")) {
			bonus = basicSalary * 0.07;
		} else if (empYOE >= 5 && empYOE <= 10 && empDesig.toLowerCase().contains("senior") && empDept.toLowerCase().equals("development")) {
			bonus = basicSalary * 0.09;
		} else {
			bonus = basicSalary * 0.15;
		}
		
		
		
		/*======================================================
         * GROSS SALARY
         *======================================================
         *
         * GS = DA + HRA + MA + TA + SA + BONUS
         */
		
		double gs = da + hra + ma + ta + sa + bonus;
		
		
		/*======================================================
         * DEDUCTIONS
         *======================================================
         *
         * PF  = 12% of Basic Salary  (Provident Fund)
         * ESI = 0.75% of Basic Salary  (Employee State Insurance)
         * 
         */
		
		double pf  = basicSalary * 0.12;
		double esi = basicSalary * 0.0075;
		
		
		/*======================================================
         * PROFESSIONAL TAX
         *======================================================
         */
		
		double professionalTax;
		
		if(gs <= 15000) {
			professionalTax = 0;
		} else if (gs <= 30000) {
			professionalTax = 150;
		} else if (gs <= 60000) {
			professionalTax = 200;
		} else {
			professionalTax = 250;
		}
		
		
		/*======================================================
         * INCOME TAX
         *======================================================
         */
		
		double incomeTax;
		
		if(gs <= 500000) {
			incomeTax = 0;
		} else if (gs <= 1000000) {
			incomeTax = gs * 0.05;
		} else if (gs <= 1500000) {
			incomeTax = gs * 0.10;
		} else {
			incomeTax = gs * 0.20;
		}
		
		
		/*======================================================
         * INSURANCE DEDUCTION
         *======================================================
         */
		
		double insuranceDeduction = 300.00;
		
		
		/*======================================================
         * TOTAL DEDUCTIONS
         *======================================================
         */
		
		double totalDeductions = pf + esi + professionalTax + incomeTax + insuranceDeduction;
		
		
		/*======================================================
         * NET SALARY
         *======================================================
         */
		
		double netSalary = gs - totalDeductions;

		
		
		
		
		System.out.println();
		System.out.println("=========================================================================");
		System.out.println("                    XYZ Technologiex Pvt Ltd");
		System.out.println("=========================================================================");
		
		System.out.println();
		System.out.println("Company Details:");
		System.out.println("----------------------------------------------");
		System.out.println("Company Name : XYZ Technologies Pvt Ltd");
		System.out.println("Location     : Chennai");
		System.out.println("Payroll Month : June 2026");
		
		
		System.out.println();
		System.out.println("Employee Details:");
		System.out.println("----------------------------------------------");
		System.out.println("Employee ID    : " + empID);
		System.out.println("Employee Name  : " + empName);
		System.out.println("Department     : " + empDept);
		System.out.println("Designation    : " + empDesig);
		System.out.println("Experience     : " + empYOE);
		
		
		System.out.println();
		System.out.println("Employee Earnings:");
		System.out.println("----------------------------------------------");
		System.out.println("Dearness Allowance    (DA)  : " + da);
		System.out.println("House Rent Allowance  (HRA) : " + hra);
		System.out.println("Medical Allowance     (MA)  : " + ma);
		System.out.println("Travel Allowance      (TA)  : " + ta);
		System.out.println("Special Allowance     (SA)  : " + sa);
		System.out.println("Performance Bonus           : " + bonus);
		
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("Gross Salary          (GS)  : " + gs);
		System.out.println("----------------------------------------------");
		
		System.out.println();
		System.out.println("Deduction Details:");
		System.out.println("----------------------------------------------");
		System.out.println("Provident Fund             (PF)  : " + pf);
		System.out.println("Employee State Insurance   (ESI) : " + esi);
		System.out.println("Professional Tax                 : " + professionalTax);
		System.out.println("Income Tax                       : " + incomeTax);
		System.out.println("Insurance Deduction              : " + insuranceDeduction);
		
		System.out.println();
		System.out.println("Total Deductions                 : " + totalDeductions);
		
		System.out.println();
		System.out.println("Salary Summary:");
		System.out.println("----------------------------------------------");
		System.out.println();
		System.out.println("Employee State Insurance   (ESI) : " + esi);
		System.out.println("Gross Salary               (GS)  : " + gs);
		System.out.println("Total Deductions                 : " + totalDeductions);
		System.out.println("Net Salary                 (NS)  : " + netSalary);
		System.out.println("----------------------------------------------");
		
		System.out.println();
		System.out.println("Payroll Status  : Payroll Processed Successfully");
		System.out.println("Generated By    : Payment Processing System");
		
		System.out.println();
		System.out.println("=====================================================================");
		System.out.println("This is auto generated process. You don't have to do anything.");
		System.out.println("=====================================================================");
		
		
	}

}

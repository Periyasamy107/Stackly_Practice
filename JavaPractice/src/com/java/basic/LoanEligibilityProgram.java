package com.java.basic;

import java.util.Scanner;

public class LoanEligibilityProgram {

	public static void main(String[] args) {

		/**=====================================================
		 *            SIMPLE LOAN ELIGIBILITY PROGRAM 
		 * =====================================================
		 * 
		 * Objective:
		 * -----------
		 * 
		 * 1) Getting the input from the user 
		 *    i) Employee Name
		 *    ii) Employee Salary
		 *    iii) Working Status
		 *    iv) Cibil Score
		 * 
		 * 2) Output is going to be the "Eligiblity of the Employee"
		 * 
		 */
		
		System.out.println();
		System.out.println("==================================================");
		System.out.println("            LOAN ELIGIBILITY PROGRAM              ");
		System.out.println("==================================================");
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Your Name             : ");
		String employeeName = scanner.nextLine();
		
		System.out.print("Enter Your Salary (CTC)     : ");
		long employeeSalary = scanner.nextLong();
		
		System.out.print("Working Status (true/false) : ");
		boolean hasEmployee = scanner.nextBoolean();
		
		System.out.print("Enter Your CIBIL Scroe      : ");
		int cibilScore = scanner.nextInt();
		
		scanner.close();
		
		System.out.println();
		System.out.println("--------------------------------------------------");
		
		if(employeeSalary >= 500000 && hasEmployee && cibilScore >= 500) {
			System.out.println("Loan Eligibility Status     : Yes, Eligible");
		} else {
			System.out.println("Loan Eligibility Status     : No, Not Eligible");
		}
		
		System.out.println("--------------------------------------------------");	
		
	}

}

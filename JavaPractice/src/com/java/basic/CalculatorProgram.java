package com.java.basic;

import java.util.Scanner;

public class CalculatorProgram {

	public static void main(String[] args) {
			
		/**=====================================
		 *         CALCULATOR PROGRAM
		 * =====================================
		 * 
		 * Objective:
		 * -----------
		 * 
		 * 1. Take the operator as an input (ex +,-,*,/,%)
		 * 2. Based on the operator perform the calculation
		 * 
		 */
		
		System.out.println();
		System.out.println("=====================================");
		System.out.println("         CALCULATOR PROGRAM          ");
		System.out.println("=====================================");
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first number         : ");
		int numberOne = scanner.nextInt();
		
		System.out.print("Enter the second number        : ");
		int numberTwo = scanner.nextInt();
		
		System.out.print("Enter the operator (+,-,*,/,%) : ");
		char operator = scanner.next().charAt(0);
		
		scanner.close();
		
		System.out.println();
		System.out.println("-------------------------------------");
		
		switch(operator) {
			case '+':
				int addition = numberOne + numberTwo;
				System.out.println("Addition of " + numberOne + " and " + numberTwo + " is : " + addition);
				break;
			case '-':
				int subtraction = numberOne - numberTwo;
				System.out.println("Subtraction of " + numberOne + " and " + numberTwo + " is : " + subtraction);
				break;
			case '*':
				int multiplication = numberOne * numberTwo;
				System.out.println("Multiplication of " + numberOne + " and " + numberTwo + " is : " + multiplication);
				break;
			case '/':
				int division = numberOne / numberTwo;
				System.out.println("Division of " + numberOne + " and " + numberTwo + " is : " + division);
				break;
			case '%':
				int modulus = numberOne % numberTwo;
				System.out.println("Modulus of " + numberOne + " and " + numberTwo + " is : " + modulus);
				break;
			default:
				System.out.println("Please enter a valid operator.");
				break;
		}
		
		System.out.println("-------------------------------------");
			
		
	}

}

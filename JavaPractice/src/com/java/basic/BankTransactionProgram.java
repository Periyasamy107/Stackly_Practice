package com.java.basic;

import java.util.Scanner;

public class BankTransactionProgram {

	public static void main(String[] args) {

		/** =====================================================
		 *               BANK TRANSACTION PROGRAM
		 *  =====================================================
		 *  
		 *  Objective
		 *  ----------
		 *  
		 *  1. Give the options (deposit, withdraw) to the user
		 *  2. Based on that perform the calculation 
		 */
		
		System.out.println();
		System.out.println("==================================================");
		System.out.println("           BANK TRANSACTION PROGRAM               ");
		System.out.println("==================================================");
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Available Options are 1) Deposit  2) Withdraw");
		System.out.print("Please enter the options either 1 or 2 : ");
		int options = scanner.nextInt();
		
		int balance = 1000;
		
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println("  Initial Balance : " + balance);
		
		switch(options) {
			case 1 -> {
				System.out.print("  Enter the amount : ");
				int amount = scanner.nextInt();
				balance += amount;
				System.out.println("  Current Balance : " + balance);
			}
			case 2 -> {
				System.out.print("  Enter the amount : ");
				int amount = scanner.nextInt();
				if(amount>balance) {
					System.out.println("  Insufficient Balance");
				} else {
					balance -= amount;
					System.out.println("  Current Balance : " + balance);
				}
			}
			default -> {
				System.out.println("  Please enter either 1 or 2.");
			}
		}
		
		scanner.close();
		System.out.println("--------------------------------------------------");
	
	}

}

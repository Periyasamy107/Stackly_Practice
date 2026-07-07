package com.java.basic;

import java.util.Scanner;

public class DaysInAMonth {

	public static void main(String[] args) {
		
		/** ===================================================
		 *      CALCULATE THE DAYS BASED ON THE MONTH 
		 *  ===================================================
		 *  
		 *  Objective:
		 *  -----------
		 *  
		 *  1. Getting the input from the user as an integer
		 *  2. Based on that calculate the number of days in that month
		 *  3. For February, check if it is leap year or not
		 *
		 */
		
		System.out.println();
		System.out.println("==========================================");
		System.out.println("   No of days in a given month program    ");
		System.out.println("==========================================");
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number between 1 and 12 : ");
		int month = scanner.nextInt();
		
		System.out.println();
		System.out.println("------------------------------------------");
		
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			
			System.out.println("Number of the days is : " + 31);
			break;
			
		case 4:
		case 6:
		case 9:
		case 11:
			
			System.out.println("Number of the days is : " + 30);
			break;
			
		case 2:
			
			System.out.print("Please enter the year : ");
			int year = scanner.nextInt();
			
			if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
				System.out.println("Number of the days is : " + 29);
			} else {
				System.out.println("Number of the days is : " + 28);
			}
			break;
		default:
			System.out.println("Please enter the number between 1 and 12");
			break;
		}
		
		scanner.close();
		
		System.out.println("------------------------------------------");
		
	}

}

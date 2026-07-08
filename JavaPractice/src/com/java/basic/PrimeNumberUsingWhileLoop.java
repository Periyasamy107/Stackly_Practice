package com.java.basic;

import java.util.Scanner;

public class PrimeNumberUsingWhileLoop {

	public static void main(String[] args) {

		/** =================================================
		 *        PRIME NUMBER FINDING USING WHILE LOOP 
		 *  =================================================
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		System.out.println("=================================================");
		System.out.println("      PRIME NUMBER FINDING USING WHILE LOOP ");
		System.out.println("=================================================");
		System.out.println();
		
		System.out.print("Enter the Number : ");
		int number = scanner.nextInt();
		
		int i = 2;
		boolean isPrime = true;
		while(i<number) {
			if(number%i==0) {
				isPrime = false;
				break;
			}
			i++;
		}
		
		System.out.println();
		if(isPrime) {
			System.out.println(number + " is a prime number");
		} else {
			System.out.println(number + " is not a prime number");
		}
		
		scanner.close();
		
		System.out.println();
		System.out.println("=================================================");
		
	}

}

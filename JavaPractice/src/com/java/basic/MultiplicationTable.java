package com.java.basic;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {

		/** ==================================
		 *        MULTIPLICATION TABLE
		 *  ==================================
		 */
		
		Scanner scanner  = new Scanner(System.in);
		
		System.out.println();
		System.out.println("=============================");
		System.out.println("    MULTIPLICATION TABLE");
		System.out.println("=============================");
		System.out.println();
		
		System.out.print("Which table need to print ? : ");
		int number = scanner.nextInt();
		
		System.out.println();
		for(int i=1; i<=20; i++) {
			System.out.println(i + " * " + number + " = " + (i * number));
		}
		
		scanner.close();
		
	}

}

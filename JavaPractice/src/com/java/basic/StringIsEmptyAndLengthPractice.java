package com.java.basic;

import java.util.Scanner;

public class StringIsEmptyAndLengthPractice {

	public static void main(String[] args) {

		/**=====================================================
		 *      STRING ISEMPTY AND STRING LENGTH PRACTICE
		 * =====================================================
		 */
		
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter Any String Value : ");
		String text = scanner.nextLine();
		System.out.println();
		
		
		if(!text.isEmpty()) {
			System.out.println("String Length   : " + text.length());
		} else {
			System.out.println("Input is empty");
		}
		
		scanner.close();
		
	}

}

package com.java.basic;

import java.util.Scanner;

public class LoginEmailAndPasswordValidation {

	public static void main(String[] args) {

		/**=====================================================
		 *        LOGIN (EMAIL AND PASSWORD) VALIDATION
		 * =====================================================
		 */
		
		System.out.println("====================================");
		System.out.println("  Getting the input from the user ");
		System.out.println("====================================");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the email    : ");
		String email = scanner.nextLine();
		
		System.out.print("Enter the password : ");
		String password = scanner.nextLine();
		
		scanner.close();
		
		System.out.println();
		System.out.println("------------------------------------");
		
		if(email.contains("@") && email.contains(".") && password.length()==10) {
			System.out.println("User Status : Login Successful.");
		} else {
			System.out.println("User Status : Not A Valid User");
		}
		
		System.out.println("------------------------------------");
		
	}

}

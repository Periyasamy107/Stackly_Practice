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
		
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		String passwordRegex = "^\\d{10}$";
		
		System.out.println();
		System.out.println("------------------------------------");
		
		if(email.matches(emailRegex) && password.matches(passwordRegex)) {
			System.out.println("User Status : Login Successful.");
		} else {
			System.out.println("User Status : Not A Valid User");
		}
		
		System.out.println("------------------------------------");
		
	}

}

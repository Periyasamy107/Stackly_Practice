package com.java.basic;

import java.util.Scanner;

public class NumberPatternProgram {

	public static void main(String[] args) {


		/** ==================================
		 *        NUMBER PATTERN PROGRAM
		 *  ==================================
		 */
		
		System.out.println();
		System.out.println("==================================");
		System.out.println("        NUMBER PATTERN PROGRAM      ");
		System.out.println("==================================");
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1) Number Pattern   2) Name Pattern");
		System.out.print("Please enter either 1 or 2 : ");
		int options = scanner.nextInt();
		scanner.nextLine();
		System.out.println();
		
		switch(options) {
			case 1 -> {				
				System.out.print("Enter the Number : ");
				int number = scanner.nextInt();
				
				// Box Pattern
				System.out.println();
				System.out.println("SQUARE / BOX PATTERN:");
				System.out.println("---------------------");
				for(int i=1; i<=number; i++) {
					for(int j=1; j<=number; j++) {
						System.out.print(i + " ");
					}
					System.out.println();
				}
				
				System.out.println();
				for(int i=1; i<=number; i++) {
					for(int j=1; j<=number; j++) {
						System.out.print(j + " ");
					}
					System.out.println();
				}
				
				
				// Left Angled Pattern
				System.out.println();
				System.out.println("LEFT ANGLED PATTERN:");
				System.out.println("---------------------");
				for(int i=1; i<=number; i++) {
					for(int j=1; j<=i; j++) {
						System.out.print(i + " ");
					}
					System.out.println();
				}
				
				System.out.println();
				for(int i=1; i<=number; i++) {
					for(int j=1; j<=i; j++) {
						System.out.print(j + " ");
					}
					System.out.println();
				}
				
				
				
				// Inverted Left Angled Pattern
				System.out.println();
				System.out.println("INVERTED LEFT ANGLED PATTERN:");
				System.out.println("-----------------------------");
				for(int i=number; i>=1; i--) {
					for(int j=1; j<=i; j++) {
						System.out.print(j + " ");
					}
					System.out.println();
				}
				
				
				// Inverted Right Angled Pattern
				System.out.println();
				System.out.println("INVERTED RIGHT ANGLED PATTERN:");
				System.out.println("------------------------------");
				for(int i=0; i<number; i++) {
					for(int j=1; j<=i; j++) {
						System.out.print("  ");
					}

					for(int k=1; k<=number-i; k++) {
						System.out.print(k + " ");
					}
					
					System.out.println();
				}
				
				
				// Right Angled Pattern
				System.out.println();
				System.out.println("RIGHT ANGLED PATTERN:");
				System.out.println("---------------------");
				for(int i=0; i<number; i++) {
					for(int k=1; k<=number-i-1; k++) {
						System.out.print("  ");
					}
					
					for(int j=0; j<=i; j++) {
						System.out.print((j+1) + " ");
					}

					System.out.println();
				}
				
				
				// Diamond Pattern
				System.out.println();
				System.out.println("DIAMOND PATTERN:");
				System.out.println("-----------------");
				for(int i=1; i<=number; i++) {
				    for(int j1=1; j1<=number-i; j1++) {
				        System.out.print("  ");
				    }
				    
				    for(int k1=1; k1<=i-1; k1++) {
				        System.out.print(k1 + " ");
				    }
				    
				    for(int l1=1; l1<=i; l1++) {
				        System.out.print(l1 + " ");
				    }
				                
				    System.out.println();
				}
				for(int i = number - 1; i >= 1; i--) {        
				        
				    for(int j2=1; j2<=number-i; j2++) {
				        System.out.print("  ");
				    }

				    for(int k2=1; k2<i; k2++) {
				        System.out.print(k2 + " ");
				    }
				    
				    for(int l2=1; l2<=i; l2++) {
				        System.out.print(l2 + " ");
				    }
				    
				    System.out.println();
				}
			}
			
			case 2 -> {
				// NAME PRINTING
				System.out.print("Please enter your name : ");
				String name = scanner.nextLine();
				
				System.out.println();
				System.out.println("NAME PRINTING PATTERN:");
				System.out.println("-----------------------");
	
				for(int i=0; i<=name.length()-1; i++) {
					for(int j=0; j<=i; j++) {
						System.out.print(name.charAt(j) + " ");
					}
					System.out.println();
				}
			}
			
			default -> {
				System.out.println("Please enter either 1 or 2.");
			}
		
		}
		
		scanner.close();
		

	}

}

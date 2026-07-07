package com.java.basic;

import java.util.Scanner;

public class FoodMenuOrderingSystem {

	public static void main(String[] args) {
		
		/** ===================================================
		 * 		    	FOOD MENU ORDERING SYSTEM 
		 *  ===================================================
		 *  
		 *  Objective
		 *  ----------
		 *  
		 *  1. Showing the menu to the user
		 *  2. Serve the food they order
		 *  3. Collect the bill with tax
		 * 
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		System.out.println("====================================================");
		System.out.println("                   Food Ordering System             ");
		System.out.println("====================================================");
		System.out.println();
		
		System.out.println("1) Vegetarian  2) Non-Vegetarian");
		System.out.println();
		System.out.print("Please select 1 or 2 : ");
		int options = scanner.nextInt();
		System.out.println();
		
		switch(options) {
			case 1 -> {
				double dosa = 50;
				double idly = 10;
				double poori = 20;
				double pongal = 30;
				System.out.println("1) Dosa  2) Idly  3) Poori  4) Pongal");
				System.out.println();
				System.out.print("Please select 1 to 4 : ");
				int vegOptions = scanner.nextInt();
				System.out.println();
				System.out.print("How many would you like to have it : ");
				int vegQnty = scanner.nextInt();
				System.out.println();
				
				System.out.println("Food is served...");
				
				double vegSubTotal = switch(vegOptions) {
					case 1 -> dosa * vegQnty;
					case 2 -> idly * vegQnty;
					case 3 -> poori * vegQnty;
					case 4 -> pongal * vegQnty;
					default -> 0;
				};
				
				double vegGrandTotal = vegSubTotal * 1.10;
				
				System.out.println();
				System.out.println("----------------------------------------------------");
				System.out.printf("Total Bill : " + "%.2f", vegGrandTotal);	
				System.out.println();
				System.out.println("----------------------------------------------------");
				
			}
			
			case 2 -> {
				double chickenRise = 100;
				double chickenBiriyani = 180;
				double muttonBiriyani = 350;
				System.out.println("1) Chicken Rise  2) Chicken Biriyani  3) Mutton Biriyani");
				System.out.println();
				System.out.print("Please select 1 to 3 : ");
				int nonVegOptions = scanner.nextInt();
				System.out.println();
				System.out.print("How many would you like to have it : ");
				int nonVegQnty = scanner.nextInt();
				System.out.println();
				
				System.out.println("Food is served...");
				
				double nonVegSubTotal = switch(nonVegOptions) {
					case 1 -> chickenRise * nonVegQnty;
					case 2 -> chickenBiriyani * nonVegQnty;
					case 3 -> muttonBiriyani * nonVegQnty;
					default -> 0;
				};
				
				double nonVegGrandTotal = nonVegSubTotal * 1.10;
				
				System.out.println();
				System.out.println("----------------------------------------------------");
				System.out.printf("Total Bill : " + "%.2f", nonVegGrandTotal);	
				System.out.println();
				System.out.println("----------------------------------------------------");
				
			}
			
			default -> {
				System.out.println();
				System.out.println("----------------------------------------------------");
				System.out.println("Invalid category selected. Please select 1 or 2.");
				System.out.println("----------------------------------------------------");
			}
		}
		
		scanner.close();
		

	}

}

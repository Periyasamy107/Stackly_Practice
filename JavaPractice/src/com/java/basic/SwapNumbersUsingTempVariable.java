package com.java.basic;

public class SwapNumbersUsingTempVariable {

	public static void main(String[] args) {
		
		/**===============================================================
		 *               SWAP TWO NUMBERS USING TEMP VARIABLE 
		 * ===============================================================
		 * 
		 * Declaring and Assigning values for two integers then swap the 
		 * values from one variable to others by using "temp" variable.
		 * 
		 * ===============================================================
		 */
		
		int numberOne = 16;
		int numberTwo = 88;
		int temp;
		
		System.out.println("==========================");
		System.out.println("     BEFORE SWAPPING      ");
		System.out.println(" ------------------------ ");
		System.out.println("  Number One = " + numberOne);
		System.out.println("  Number Two = " + numberTwo);
		
		temp = numberOne + numberTwo;
		numberOne = temp - numberOne;
		numberTwo = temp - numberTwo;
		
		System.out.println();
		System.out.println("     AFTER  SWAPPING      ");
		System.out.println(" ------------------------ ");
		System.out.println("  Number One = " + numberOne);
		System.out.println("  Number Two = " + numberTwo);
		System.out.println();
		System.out.println("==========================");
		
		

	}

}

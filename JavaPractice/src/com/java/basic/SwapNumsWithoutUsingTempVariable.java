package com.java.basic;

public class SwapNumsWithoutUsingTempVariable {

	public static void main(String[] args) {

		/**===============================================================
		 *           SWAP TWO NUMBERS WITHOUT USING TEMP VARIABLE 
		 * ===============================================================
		 * 
		 * Declaring and Assigning values for two integers then swap the 
		 * values from one variable to others by NOT using "temp" variable.
		 * 
		 * ===============================================================
		 */
		
		int numberOne = 111;
		int numberTwo = 76;
		
		System.out.println("==========================");
		System.out.println("     BEFORE SWAPPING      ");
		System.out.println(" ------------------------ ");
		System.out.println("  Number One = " + numberOne);
		System.out.println("  Number Two = " + numberTwo);
		
		numberOne = numberOne + numberTwo;
		numberTwo = numberOne - numberTwo;
		numberOne = numberOne - numberTwo;
		
		System.out.println();
		System.out.println("     AFTER  SWAPPING      ");
		System.out.println(" ------------------------ ");
		System.out.println("  Number One = " + numberOne);
		System.out.println("  Number Two = " + numberTwo);
		System.out.println();
		System.out.println("==========================");
		
	}
}

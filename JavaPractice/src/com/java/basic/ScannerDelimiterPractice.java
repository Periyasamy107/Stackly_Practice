package com.java.basic;

import java.util.Scanner;

public class ScannerDelimiterPractice {

	public static void main(String[] args) {

		// Default Delimiter
		String fruits = "Apple Orange Banana";
		Scanner scanner1 = new Scanner(fruits);
		System.out.println("Default Space Delimiter:");
		System.out.println("=========================");
		System.out.println("Fruits ==> '" + fruits + "'");
		System.out.println();
		while(scanner1.hasNext()) {
			System.out.println(scanner1.next());
		}
		scanner1.close();
		
		
		// Tab Delimiter
		System.out.println();
		String animals = "Dog    Cat    Bird";
		Scanner scanner2 = new Scanner(animals);
		System.out.println("Tab Delimiter:");
		System.out.println("===================");
		System.out.println("Animals ==> '" + animals + "'");
		System.out.println();
		while(scanner2.hasNext()) {
			System.out.println(scanner2.next());
		}
		scanner2.close();
		
		
		// useDelimiter()
		System.out.println();
		String laptopParts = "Monitor,Keyboard,Mouse";
		Scanner scanner3 = new Scanner(laptopParts);
		System.out.println("Comma Delimiter:");
		System.out.println("==================");
		System.out.println("Laptop Parts ==> '" + laptopParts + "'");
		System.out.println();
		scanner3.useDelimiter(",");
		while(scanner3.hasNext()) {
			System.out.println(scanner3.next());
		}
		scanner3.close();
		
		
		// Multiple Delimiter
		System.out.println();
		String programmingLanguages = "Java:Python;c++?c#*Ruby";
		Scanner scanner4 = new Scanner(programmingLanguages);
		System.out.println("Multiple Delimiter:");
		System.out.println("=====================");
		System.out.println("Programming Languages ==> '" + programmingLanguages + "'");
		System.out.println();
		scanner4.useDelimiter("[:;?*]");
		while(scanner4.hasNext()) {
			System.out.println(scanner4.next());
		}
		scanner4.close();
		
	}

}

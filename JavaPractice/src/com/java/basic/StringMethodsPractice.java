package com.java.basic;

public class StringMethodsPractice {

	public static void main(String[] args) {

		/**================================================================
		 *                STRING METHODS PRACTICE PROGRAM
		 * ================================================================
		 * 
		 * Most commonly used java string methods are as follows:
		 * 
		 * 1) length()
		 * 2) charAt()
		 * 3) concat()
		 * 4) toUpperCase()
		 * 5) toLowerCase()
		 * 6) trim()
		 * 7) substring()
		 * 8) contains()
		 * 9) equals()
		 * 10) equalsIgnoreCase()
		 * 11) compareTo()
		 * 12) startsWith()
		 * 13) endsWith()
		 * 14) indexOf()
		 * 15) lastIndexOf()
		 * 16) replace()
		 * 17) replaceAll()
		 * 18) isEmpty()
		 * 19) split()
		 * 20) valueOf()
		 * 
		 */
		
		System.out.println("===================================================");
		System.out.println("      JAVA STRING METHODS PRACTICE");
		System.out.println("===================================================");
		
		String text = "  Java Programming Language  ";
		String anotherText = "java programming language";
		
		System.out.println();
		System.out.println("Original String  : " + text);
		
		// 1) length()
		System.out.println();
		System.out.println("1) length() : " + text.length());
		
		// 2) trim()
		System.out.println();
		System.out.println("2)trim() : " + text.trim());
		
		String trimmedText = text.trim();
		
		// 3) charAt()
		System.out.println();
		System.out.println("3)charAt(5) : " + trimmedText.charAt(5));
		
		// 4) concat()
		System.out.println();
		System.out.println("4)concat() : " + trimmedText.concat(" - Core Java"));
		
		// 5) toUpperCase()
		System.out.println();
		System.out.println("5)toUpperCase() : " + trimmedText.toUpperCase());
		
		// 6) toLowerCase()
		System.out.println();
		System.out.println("6)toLowerCase() : " + trimmedText.toLowerCase());
		
		// 7) substring()
		System.out.println();
		System.out.println("7)substing(5)    : " + trimmedText.substring(5));
		System.out.println("7)substing(5,16) : " + trimmedText.substring(5,16));
		
		// 8) contains()
		System.out.println();
		System.out.println("8)contains() 'Programming'   : " + trimmedText.contains("Programming"));
		
		// 9) equals()
		System.out.println();
		System.out.println("9)equals()   : 'Java' and 'java' =>" + "Java".equals("java"));
		
		// 10) equalsIgnoreCase()
		System.out.println();
		System.out.println("10)equalsIgnoreCase()   : 'Java' and 'java' =>" + "Java".equalsIgnoreCase("java"));
		
		// 11) compareTo()
		System.out.println();
		System.out.println("11)compareTo()   : " + trimmedText.compareTo(anotherText));
		
		// 12) startsWith()
		System.out.println();
		System.out.println("12)startsWith()   : " + trimmedText.startsWith("Java"));
		
		// 13) endsWith()
		System.out.println();
		System.out.println("13)endsWith   : " + trimmedText.startsWith("language"));
		
		// 14) indexOf()
		System.out.println();
		System.out.println("14)indexOf() 'Programming'   : " + trimmedText.indexOf("Programming"));
		
		// 15) lastIndexOf()
		System.out.println();
		System.out.println("15)lastIndexOf() 'a'   : " + trimmedText.lastIndexOf("a"));
		
		// 16) replace()
		System.out.println();
		System.out.println("16)replace()   : " + trimmedText.replace("Java", "Advanced Java"));
		
		// 17) replaceAll()
		System.out.println();
		System.out.println("17)replaceAll()   : " + trimmedText.replaceAll("a", "@"));
		
		// 18) isEmpty()
		System.out.println();
		System.out.println("18)isEmpty()   : " + trimmedText.isEmpty());
		
		// 19) split()
		System.out.println();
		System.out.println("19) split()");
		System.out.println("-------------------");
		String[] words = trimmedText.split(" ");
		for(String word : words) {
			System.out.println(word);
		}
		
		// 20) valueOf()
		System.out.println();
		System.out.println("20) valueOf()");
		System.out.println("-------------------");
		int employeeId = 1005;
		double salary = 15000.50;
		System.out.println(String.valueOf(employeeId));
		System.out.println(String.valueOf(salary));
		
		System.out.println("===================================================");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

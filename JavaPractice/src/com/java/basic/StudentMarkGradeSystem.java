package com.java.basic;

import java.util.Scanner;

public class StudentMarkGradeSystem {

	public static void main(String[] args) {

		/**=====================================================================
		 *            STUDENT MARK GRADE MANAGEMENT SYSTEM
		 * =====================================================================
		 * 
		 * Objective:
		 * ----------
		 * 
		 * 1. Total Mark
		 * 2. Average Mark
		 * 3. Higest Mark
		 * 4. Lowest Mark
		 * 5. Pass / Fail
		 * 6. Grade
		 * 7. Remarks
		 * 
		 * =====================================================================
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("========================================================================");
		System.out.println("               STUDENT MARK GRADE MANAGEMENT SYSTEM");
		System.out.println("========================================================================");
		
		/*===========================================
		 *    STUDENT DETAILS
		 *===========================================
		 */
		System.out.println("\nEnter Student Details");
		System.out.println("---------------------------");
		
		System.out.print("Student ID (int)   : ");
		int studentID = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Student Name       : ");
		String studentName = scanner.nextLine();
		
		System.out.print("Department         : ");
		String department = scanner.nextLine();
		
		System.out.print("Semester           : ");
		int semester = scanner.nextInt();
		scanner.nextLine();
		
		/*===========================================
		 *    SUBJECT MARKS
		 *===========================================
		 */
		System.out.println("\nEnter the Marks (0-100)");
		System.out.println("---------------------------");
		
		System.out.print("Java                 : ");
		int java = scanner.nextInt();
		
		System.out.print("Python               : ");
		int python = scanner.nextInt();
		
		System.out.print("Database             : ");
		int database = scanner.nextInt();
		
		System.out.print("Operating Systems    : ");
		int operatingSystems = scanner.nextInt();
		
		System.out.print("Computer Networks    : ");
		int computerNetworks = scanner.nextInt();
		
		scanner.close();
		
		/*===========================================
		 *    TOTAL MARKS
		 *===========================================
		 */
		int totalMarks = java + python + database + operatingSystems + computerNetworks;
		
		/*===========================================
		 *    AVERAGE MARKS
		 *===========================================
		 */
		int averageMarks = totalMarks / 5;
		
		
		/*===========================================
		 *    HIGHEST MARK
		 *===========================================
		 */
		int highestMark = java;
				
		if(python > highestMark) {
			highestMark = python;
		}
		
		if (database > highestMark) {
			highestMark = database;
		}
		
		if (operatingSystems > highestMark) {
			highestMark = operatingSystems;
		}
		
		if (computerNetworks > highestMark) {
			highestMark = computerNetworks;
		}
		
		/*===========================================
		 *    LOWEST MARK
		 *===========================================
		 */
		int lowestMark = java;
		
		if(python < lowestMark) lowestMark = python ;
		
		if(database < lowestMark) lowestMark = database ;
		
		if(operatingSystems < lowestMark) lowestMark = operatingSystems ;
		
		if(computerNetworks < lowestMark) lowestMark = computerNetworks ;
		
		/*===========================================
		 *    OVERALL PASS / FAIL
		 *===========================================
		 */
		boolean isPass = true;
		
		if ( java < 35 || python < 35 || database < 35 ||
			 operatingSystems < 35 || computerNetworks < 35 ) {
			isPass = false;
		}
		
		/*===========================================
		 *    GRADE CALCULATION
		 *===========================================
		 */
		String grade;
		
		if(!isPass) {
			grade = "F";
		} else if (averageMarks >= 90) {
			grade = "A+";
		} else if (averageMarks >= 80) {
			grade = "A";
		} else if (averageMarks >= 70) {
			grade = "B+";
		} else if (averageMarks >= 60) {
			grade = "B";
		} else if (averageMarks >= 50) {
			grade = "C";
		} else if (averageMarks >= 35) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		/*===========================================
		 *    REMARKS
		 *===========================================
		 */
		String remarks;
		
		switch (grade) {
			case "A+":
				remarks = "Outstanding Performance";
				break;
			case "A":
				remarks = "Excellant Performance";
				break;
			case "B+":
				remarks = "Very Good";
				break;
			case "B":
				remarks = "Good";
				break;
			case "C":
				remarks = "Average";
				break;
			case "D":
				remarks = "Needs Improvement";
				break;
			default:
				remarks = "Fail, Better Luch Next Time";
		}
		
		
		/*===========================================
		 *    RESULT CARD
		 *===========================================
		 */
		
		System.out.println();
		System.out.println("=================================================================");
		System.out.println("                     STUDENT RESULT CARD");
		System.out.println("=================================================================");
		
		System.out.println();
		System.out.println("Student Details:");
		System.out.println("----------------------------------------------");
		System.out.println("Student ID     : " + studentID);
		System.out.println("Student Name   : " + studentName);
		System.out.println("Department     : " + department);
		System.out.println("Semester       : " + semester);
		
		System.out.println();
		System.out.println("Student Marks:");
		System.out.println("----------------------------------------------");
		System.out.println("Java                : " + java);
		System.out.println("Python              : " + python);
		System.out.println("Database            : " + database);
		System.out.println("Operating Systems   : " + operatingSystems);
		System.out.println("Computer Networks   : " + computerNetworks);
		
		System.out.println();
		System.out.println("Academic Summary:");
		System.out.println("----------------------------------------------");
		System.out.println("Total Marks              : " + totalMarks + " / 500");
		System.out.println("Average Marks            : " + averageMarks);
		System.out.println("Highest Mark Scored      : " + highestMark);
		System.out.println("Lowest Mark Gained       : " + lowestMark);
		
		System.out.println();
		System.out.println("Result:");
		System.out.println("----------------------------------------------");
		if(isPass) {
			System.out.println("Result Status   :  PASS");
		} else {
			System.out.println("Result Status   :  FAIL");
		}
		System.out.println("Grade           :  " + grade);
		System.out.println("Remarks         :  " + remarks);
		
		System.out.println();
		System.out.println("=================================================================");	
		
	}

}

package com.java.fileReadAndExp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentDataWriteOperation {

    public static void main(String[] args) {

        System.out.println("==========================================================");
        System.out.println("   MULTI DIMENSIONAL ARRAY - STUDENT MARK GRADE SYSTEM    ");
        System.out.println("==========================================================");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

//        String filePath = "students.txt";
        String filePath = "C:\\Users\\cperi\\OneDrive\\Desktop\\students.txt";

        File file = new File(filePath);
        boolean writeHeader = !file.exists() || file.length() == 0;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {

            if(writeHeader){
                writer.write("===========================================");
                writer.newLine();
                writer.write("         STUDENT MARK GRADE SYSTEM");
                writer.newLine();
                writer.write("===========================================");
                writer.newLine();
            }

            boolean isRunning = true;

            do {
                System.out.println("1) Run the program");
                System.out.println("2) Exit the program");
                System.out.print("Please select 1 or 2 : ");
                int option = scanner.nextInt();
                System.out.println();

                switch (option) {
                    case 1 -> {

                        int students = gettingNoOfStudents(scanner, writer);

                        int subjects = gettingNoOfSubjects(scanner, writer);

                        int[][] marks = new int[students][subjects];

                        System.out.println("----------------------------------------");
                        System.out.println("Please enter the mark between 0 and 100");
                        System.out.println("----------------------------------------");

                        gettingIndividualMark(students, subjects, scanner, marks, writer);

                        gettingTotalMarks(students, subjects, marks, writer);

                        int[] totalMarks = totalMarksMethod(students, subjects, marks);
                        int[] totalPercentage = totalPercentagesMethod(students, subjects, marks);

                        writer.newLine();

                        printingTotalMarks(students, subjects, totalMarks, writer);

                        printingTotalPercentages(totalPercentage, writer);

                        writer.newLine();

                        printingGrade(marks, subjects, totalPercentage, writer);

                    }
                    case 2 -> {
                        System.out.println();
                        isRunning = false;
                        System.out.println("Exiting the program...");
                        System.out.println();
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Please enter 1 or 2.");
                        System.out.println();
                    }
                }
                System.out.println("--------------------------------------------");
                System.out.println();
            } while (isRunning);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        scanner.close();

    }


    static boolean checkingFail(int[][] marks, int studentIndex, int subjects) {
        for(int i=0; i<subjects; i++) {
            if(marks[studentIndex][i] <= 34) {
                return true;
            }
        }
        return false;
    }

    static String grade(int mark, boolean isFail) {
        if(mark>90 && !isFail){
            return "S Grade";
        } else if(mark>80 && !isFail){
            return "A Grade";
        } else if(mark>70 && !isFail){
            return "B Grade";
        } else if(mark>60 && !isFail){
            return "C Grade";
        } else if(mark>50 && !isFail){
            return "D Grade";
        } else if(mark>=35 && !isFail){
            return "E Grade";
        } else {
            return "Fail";
        }
    }


    static int[] totalMarksMethod(int students, int subjects, int[][] marks){
        int[] totalMarks = new int[students];
        for (int i = 0; i < students; i++) {
            int temp = 0;
            for (int j = 0; j < subjects; j++) {
                temp += marks[i][j];
            }
            totalMarks[i] = temp;
        }
        return totalMarks;
    }


    static int[] totalPercentagesMethod(int students, int subjects, int[][] marks){
        int[] totalMarks = new int[students];
        int[] totalPercentage = new int[students];
        for (int i = 0; i < students; i++) {
            int temp = 0;
            for (int j = 0; j < subjects; j++) {
                temp += marks[i][j];
            }
            totalMarks[i] = temp;

            totalPercentage[i] = (totalMarks[i] * 100) / (subjects * 100);
        }
        return totalPercentage;
    }


    static void printingTotalMarks(int students, int subjects, int[] totalMarks, BufferedWriter writer) throws IOException{
        for (int i = 0; i < totalMarks.length; i++) {
            writer.write("Student " + (i + 1) + " Total Marks : " + totalMarks[i] + " / " + (subjects * 100));
            writer.newLine();
        }
    }

    static void printingTotalPercentages(int[] totalPercentage, BufferedWriter writer){
        try{
            writer.newLine();
            for (int i = 0; i < totalPercentage.length; i++) {
                writer.write("Student " + (i + 1) + " Percentage : " + totalPercentage[i] + "%");
                writer.newLine();
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void gettingTotalMarks(int students, int subjects, int[][] marks, BufferedWriter writer) throws IOException{
        for (int i = 0; i < students; i++) {
            writer.write("Student " + (i + 1) + " Marks : ");
            for (int j = 0; j < subjects; j++) {
                writer.write(marks[i][j] + " ");
            }
            writer.newLine();
        }
    }

    static void gettingIndividualMark(int students, int subjects, Scanner scanner, int[][] marks, BufferedWriter writer) {
        try{
            for (int i = 0; i < students; i++) {
                for (int j = 0; j < subjects; j++) {
                    System.out.print("Student " + (i + 1) + " Subject " + (j + 1) + " mark is : ");
                    int temp = scanner.nextInt();
                    if(temp>0 && temp<101) {
                        marks[i][j] = temp;

                        writer.write("Student " + (i + 1) + " Subject " + (j + 1) + " mark is : "+temp);
                        writer.newLine();
                    } else {
                        marks[i][j] = 0;

                        writer.write("Student " + (i + 1) + " Subject " + (j + 1) + " mark is : "+0);
                        writer.newLine();
                    }

                }
                writer.newLine();
                System.out.println();
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }


    static void printingGrade(int[][] marks, int subjects, int[] totalPercentage, BufferedWriter writer) throws IOException{
        for (int i = 0; i < totalPercentage.length; i++) {
            int temp = totalPercentage[i];
            boolean isFail = checkingFail(marks, i, subjects);
            String grade = grade(temp, isFail);
            writer.write("Student " + (i + 1) + " : " + grade);
            writer.newLine();
        }
        writer.write("-------------------------------------------");
        writer.newLine();
    }

    static int gettingNoOfStudents(Scanner scanner, BufferedWriter writer) {
        int students = 0;
        try {
            System.out.print("Students : ");
            students = scanner.nextInt();
            writer.write("Students : " + students);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    static int gettingNoOfSubjects(Scanner scanner, BufferedWriter writer) throws IOException {
        System.out.print("Subjects : ");
        int subjects = scanner.nextInt();
        writer.write("Subjects : "+subjects);
        writer.newLine();
        writer.newLine();
        return subjects;
    }

}


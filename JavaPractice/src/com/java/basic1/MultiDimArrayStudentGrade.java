package com.java.basic1;

import java.util.Scanner;

public class MultiDimArrayStudentGrade {
    public static void main(String[] args) {

        System.out.println("==========================================================");
        System.out.println("   MULTI DIMENSIONAL ARRAY - STUDENT MARK GRADE SYSTEM    ");
        System.out.println("==========================================================");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        do {
            System.out.println("1) Run the program");
            System.out.println("2) Exit the program");
            System.out.print("Please select 1 or 2 : ");
            int option = scanner.nextInt();
            System.out.println();

            switch (option) {
                case 1 -> {
                    System.out.print("Students : ");
                    int students = scanner.nextInt();
                    System.out.print("Subjects : ");
                    int subjects = scanner.nextInt();

                    int[][] marks = new int[students][subjects];

                    System.out.println("----------------------------------------");
                    System.out.println("Please enter the mark between 0 and 100");
                    System.out.println("----------------------------------------");
                    for(int i=0; i<students; i++) {
                        for(int j=0; j<subjects; j++) {
                            System.out.print("Student "+(i+1)+" Subject "+(j+1)+" mark is : ");
                            int temp = scanner.nextInt();
                            marks[i][j] = temp;
                        }
                        System.out.println();
                    }

                    for(int i=0; i<students; i++) {
                        System.out.print("Student "+(i+1)+" Marks : ");
                        for(int j=0; j<subjects; j++) {
                            System.out.print(marks[i][j] + " ");
                        }
                        System.out.println();
                    }

                    // TOTAL MARKS and PERCENTAGE
                    int[] totalMarks = new int[students];
                    int[] totalPercentage = new int[students];
                    for(int i=0; i<students; i++) {
                        int temp = 0;
                        for (int j=0; j<subjects; j++) {
                            temp += marks[i][j];
                        }
                        totalMarks[i] = temp;

                        totalPercentage[i] = (totalMarks[i] * 100) / (subjects * 100);
                    }
                    System.out.println();
                    for (int i=0; i<totalMarks.length; i++) {
                        System.out.println("Student "+(i+1)+" Total Marks : " + totalMarks[i]+" / "+(subjects * 100));
                    }
                    System.out.println();
                    for(int i=0; i<totalPercentage.length; i++) {
                        System.out.println("Student "+(i+1)+" Percentage : " + totalPercentage[i] + "%");
                    }

                    System.out.println();
                    for(int i=0; i<totalPercentage.length; i++) {
                        System.out.print("Student "+(i+1)+" : ");
                        int temp = totalPercentage[i];
                        if(temp>90){
                            System.out.print("S Grade");
                        } else if(temp>80){
                            System.out.print("A Grade");
                        } else if(temp>70){
                            System.out.print("B Grade");
                        } else if(temp>60){
                            System.out.print("C Grade");
                        } else if(temp>50){
                            System.out.print("D Grade");
                        } else if(temp>45){
                            System.out.print("E Grade");
                        } else {
                            System.out.print("Fail");
                        }
                        System.out.println();
                    }
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
//        System.out.println("1) Run the program");
//        System.out.println("2) Exit the program");
//        System.out.print("Please select 1 or 2 : ");
//        int option = scanner.nextInt();
//        System.out.println();
//
//        System.out.print("Students : ");
//        int students = scanner.nextInt();
//        System.out.print("Subjects : ");
//        int subjects = scanner.nextInt();
//
//        int[][] marks = new int[students][subjects];
//
//        System.out.println("----------------------------------------");
//        System.out.println("Please enter the mark between 0 and 100");
//        System.out.println("----------------------------------------");
//        for(int i=0; i<students; i++) {
//            for(int j=0; j<subjects; j++) {
//                System.out.print("Student "+(i+1)+" Subject "+(j+1)+" mark is : ");
//                int temp = scanner.nextInt();
//                marks[i][j] = temp;
//            }
//            System.out.println();
//        }
//
//        for(int i=0; i<students; i++) {
//            System.out.print("Student "+(i+1)+" Marks : ");
//            for(int j=0; j<subjects; j++) {
//                System.out.print(marks[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        // TOTAL MARKS and PERCENTAGE
//        int[] totalMarks = new int[students];
//        int[] totalPercentage = new int[students];
//        for(int i=0; i<students; i++) {
//            int temp = 0;
//            for (int j=0; j<subjects; j++) {
//                temp += marks[i][j];
//            }
//            totalMarks[i] = temp;
//
//            totalPercentage[i] = (totalMarks[i] * 100) / (subjects * 100);
//        }
//        System.out.println();
//        for (int i=0; i<totalMarks.length; i++) {
//            System.out.println("Student "+(i+1)+" Total Marks : " + totalMarks[i]+" / "+(subjects * 100));
//        }
//        System.out.println();
//        for(int i=0; i<totalPercentage.length; i++) {
//            System.out.println("Student "+(i+1)+" Percentage : " + totalPercentage[i] + "%");
//        }
//
//        System.out.println();
//        for(int i=0; i<totalPercentage.length; i++) {
//            System.out.print("Student "+(i+1)+" : ");
//            int temp = totalPercentage[i];
//            if(temp>90){
//                System.out.print("S Grade");
//            } else if(temp>80){
//                System.out.print("A Grade");
//            } else if(temp>70){
//                System.out.print("B Grade");
//            } else if(temp>60){
//                System.out.print("C Grade");
//            } else if(temp>50){
//                System.out.print("D Grade");
//            } else if(temp>45){
//                System.out.print("E Grade");
//            } else {
//                System.out.print("Fail");
//            }
//            System.out.println();
//        }

        scanner.close();

    }
}

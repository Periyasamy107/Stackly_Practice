package com.java.basic1;

import java.util.Scanner;

public class MatrixAddSubMulPractice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================");
        System.out.println("MATRIX ADD SUB MUL PROGRAM");
        System.out.println("===========================");

        System.out.println("1) Run");
        System.out.println("2) Stop");
        System.out.print("Please select 1 or 2 : ");
        int mainOption = scanner.nextInt();

        boolean mainLoopRunning = true;
        do {
            switch (mainOption) {
                case 1 -> {
                    boolean isRunning = true;

                    while(isRunning) {
                        System.out.println("First Matrix");
                        System.out.print("Matrix 1 row : ");
                        int m1Row = scanner.nextInt();
                        System.out.print("Matrix 1 col : ");
                        int m1Col = scanner.nextInt();

                        int[][] matrix1 = new int[m1Row][m1Col];

                        System.out.println();
                        System.out.println("Matrix 1 Values : ");
                        for(int i=0; i<m1Row; i++) {
                            for(int j=0; j<m1Col; j++) {
                                System.out.print("Row "+(i+1)+" Col "+(j+1)+" value is : ");
                                int temp = scanner.nextInt();
                                matrix1[i][j] = temp;
                            }
                        }

                        System.out.println();
                        System.out.println("Second Matrix");
                        System.out.print("Matrix 2 row : ");
                        int m2Row = scanner.nextInt();
                        System.out.print("Matrix 2 col : ");
                        int m2Col = scanner.nextInt();

                        int[][] matrix2 = new int[m2Row][m2Col];

                        System.out.println();
                        System.out.println("Matrix 2 Values : ");
                        for(int i=0; i<m2Row; i++) {
                            for(int j=0; j<m2Col; j++) {
                                System.out.print("Row "+(i+1)+" Col "+(j+1)+" value is : ");
                                int temp = scanner.nextInt();
                                matrix2[i][j] = temp;
                            }
                        }

                        System.out.println();
                        System.out.println("Matrix 1 : ");
                        System.out.println("===========");
                        for(int i=0; i<matrix1.length; i++) {
                            for(int j=0; j<matrix1[0].length; j++) {
                                System.out.print(" "+matrix1[i][j]+" ");
                            }
                            System.out.println();
                        }

                        System.out.println();
                        System.out.println("Matrix 2 : ");
                        System.out.println("===========");
                        for(int i=0; i<matrix2.length; i++) {
                            for(int j=0; j<matrix2[0].length; j++) {
                                System.out.print(" "+matrix2[i][j]+" ");
                            }
                            System.out.println();
                        }

                        System.out.println();
                        System.out.println("1) Addition");
                        System.out.println("2) Subtraction");
                        System.out.println("3) Multiplication");
                        System.out.print("Select the option : ");
                        int option = scanner.nextInt();

                        switch (option) {
                            case 1 -> {
                                int[][] add = new int[m1Row][m1Col];
                                if(m1Row==m2Row && m1Col==m2Col) {
                                    for(int i=0; i<m1Row; i++) {
                                        for(int j=0; j<m1Col; j++) {
                                            add[i][j] = matrix1[i][j] + matrix2[i][j];
                                        }
                                    }
                                }

                                System.out.println();
                                System.out.println("Addition : ");
                                System.out.println("===========");
                                for(int i=0; i<add.length; i++) {
                                    for(int j=0; j<add[0].length; j++) {
                                        System.out.print(" "+add[i][j]+" ");
                                    }
                                    System.out.println();
                                }

                                isRunning = false;
                            }
                            case 2 -> {
                                int[][] sub = new int[m1Row][m1Col];
                                if(m1Row==m2Row && m1Col==m2Col) {
                                    for(int i=0; i<m1Row; i++) {
                                        for(int j=0; j<m1Col; j++) {
                                            sub[i][j] = matrix1[i][j] - matrix2[i][j];
                                        }
                                    }
                                }

                                System.out.println();
                                System.out.println("Subtraction : ");
                                System.out.println("===============");
                                for(int i=0; i<sub.length; i++) {
                                    for(int j=0; j<sub[0].length; j++) {
                                        System.out.print(" "+sub[i][j]+" ");
                                    }
                                    System.out.println();
                                }

                                isRunning = false;
                            }
                            case 3 -> {

                                if(m1Col == m2Row) {
                                    int[][] mul = new int[m1Row][m2Col];

                                    for(int i=0; i<m1Row; i++) {
                                        for(int j=0; j<m2Col; j++) {
                                            for(int k=0; k<m1Col; k++) {
                                                mul[i][j] += matrix1[i][k] * matrix2[k][j];
                                            }
                                        }
                                    }

                                    System.out.println();
                                    System.out.println("multiplication : ");
                                    System.out.println("==================");
                                    for(int i=0; i<mul.length; i++) {
                                        for(int j=0; j<mul[0].length; j++) {
                                            System.out.print(" "+mul[i][j]+" ");
                                        }
                                        System.out.println();
                                    }
                                }
                                isRunning = false;
                            }
                            default ->  {
                                isRunning = false;
                                System.out.println();
                                System.out.println("Please enter 1 or 2 or 3 only!!.....");
                            }
                        }
                    }

                    System.out.println("----------------------------");

                }
                case 2 -> {
                    System.out.println();
                    mainLoopRunning = false;
                    System.out.println("Exiting the program");
                }
                default -> {
                    System.out.println();
                    System.out.println("Please select 1 or 2!!!!.........");
                }
            }
            if(mainOption != 2) {
                System.out.println("1) Run");
                System.out.println("2) Stop");
                System.out.print("Please select 1 or 2 : ");
                mainOption = scanner.nextInt();
            }

        } while(mainLoopRunning);

        scanner.close();

    }
}

package com.java.fileReadAndExp;

import java.io.*;

public class Counting {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("COUNT THE NUMBER OF VOWELS, CONSONENTS, DIGITS");
        System.out.println("  AND SPECIAL CHARACTERS PRESENT IN A FILE");
        System.out.println("===========================================");

        System.out.println();
        writeOperation();
        int [] answer = counts();
        System.out.println("Digits : " + answer[2]);
        System.out.println("Vowels : " + answer[0]);
        System.out.println("Consonents : " + answer[1]);
        System.out.println("Special Digits : " + answer[3]);
        System.out.println();

        System.out.println("-------------------------------------------");

    }


    static void writeOperation() {
        String fileName = "demo.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){

            writer.write("abcABC 123 &*&");
            writer.newLine();

        } catch (IOException ex) {
            System.out.println("Error to write a file : " + ex.getMessage());
        }
    }


    static int[] counts() {
        String fileName = "demo.txt";
        int vowels = 0;
        int consonents = 0;
        int digits = 0;
        int specialCharacters = 0;

        int[] res = new int[4];

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String currentLine;

            System.out.println("File contains : ");
            System.out.println("---------------");
            while((currentLine = reader.readLine()) != null) {
                String words = currentLine.toLowerCase();
                System.out.println(words);
                for(int i=0; i<words.length(); i++) {
                    char ch = words.charAt(i);
                    if(ch == ' ') continue;
                    if(ch>='0' && ch<='9') digits++;
                    else if (ch>='a' && ch<='z') {
                        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
                            vowels++;
                        } else {
                            consonents++;
                        }
                    }
                    else specialCharacters++;
                }
            }
            System.out.println();

            res[0] = vowels;
            res[1] = consonents;
            res[2] = digits;
            res[3] = specialCharacters;

            return res;
        } catch (IOException ex) {
            System.out.println("Error reading a file : " + ex.getMessage());
        }
        return res;
    }


}

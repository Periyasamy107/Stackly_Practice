package com.java.fileReadAndExp;

import java.io.*;

public class NoOfWordsInAFile {
    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("COUNT THE NUMBER OF WORDS PRESENT IN A FILE");
        System.out.println("===========================================");

        System.out.println();
        writeOperation();
        int count = wordsCount();
        System.out.println("Number of words : " + count);
        System.out.println();

        System.out.println("-------------------------------------------");

    }

    static void writeOperation() {
        String fileName = "sample.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){

            writer.write("World is amazing to live");
            writer.newLine();

        } catch (IOException ex) {
            System.out.println("Error to write a file : " + ex.getMessage());
        }
    }


    static int wordsCount() {
        String fileName = "sample.txt";
        int count = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String currentLine;

            System.out.println("File content: ");
            System.out.println("--------------");
            while((currentLine = reader.readLine()) != null) {

                System.out.println(currentLine);
                String[] words = currentLine.split("\\s+");
                count += words.length;
            }
            System.out.println();
            return count;

        } catch (IOException ex) {
            System.out.println("Error reading a file : " + ex.getMessage());
        }
        return 0;
    }

}

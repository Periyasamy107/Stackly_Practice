package com.java.fileReadAndExp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentDataReadOperation {

    public static void main(String[] args) throws IOException {

//        String filePath = "students.txt";

        String filePath = "C:\\Users\\cperi\\OneDrive\\Desktop\\students.txt";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            System.out.println(currentLine);
        }

    }

}


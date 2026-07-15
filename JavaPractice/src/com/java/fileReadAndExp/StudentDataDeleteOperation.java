package com.java.fileReadAndExp;

import java.io.File;
import java.io.IOException;

public class StudentDataDeleteOperation {

    public static void main(String[] args) throws IOException {

//        String filePath = "students.txt";

        String filePath = "C:\\Users\\cperi\\OneDrive\\Desktop\\students.txt";

        File file = new File(filePath);

        boolean isDeleted = file.delete();

        if (isDeleted) {
            System.out.println("File was found and successfully deleted.");
        } else {
            System.out.println("File could not be deleted (it might not exist).");
        }


    }
}


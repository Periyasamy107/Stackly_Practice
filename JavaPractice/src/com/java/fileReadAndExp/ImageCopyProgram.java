package com.java.fileReadAndExp;

import java.io.*;

public class ImageCopyProgram {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println();
        long startTime = System.currentTimeMillis();
        fastCopy();
        long endTime = System.currentTimeMillis();

        System.out.println("Copying the image fast : " + (endTime - startTime) + " ms");
        System.out.println();

        long slowStartTime = System.currentTimeMillis();
        slowCopy();
        long slowEndTime = System.currentTimeMillis();

        System.out.println("Copying the image slow : " + (slowEndTime - slowStartTime) + " ms");
        System.out.println();
        System.out.println("=======================================");

    }


    static void fastCopy() {
        String sourcePath = "C:\\Users\\cperi\\Downloads\\nature.jpg";
        String destinationPath = "C:\\Users\\cperi\\OneDrive\\Desktop\\nature_fast.jpg";

        System.out.println("Image is copying in fast............");

        try(
                BufferedInputStream reader = new BufferedInputStream(new FileInputStream(sourcePath));
                BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(destinationPath))
        ){

            byte[] buffer = new byte[4096];
            int byteRead;

            while((byteRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, byteRead);
            }

            System.out.println("Image copied successfully in fast!!!!!");

        } catch (IOException ex) {
            System.out.println("Error Copying The Image : " + ex.getMessage());
        }
    }


    static void slowCopy() {
        String sourcePath = "C:\\Users\\cperi\\Downloads\\nature.jpg";
        String destinationPath = "C:\\Users\\cperi\\OneDrive\\Desktop\\nature_slow.jpg";

        System.out.println("Image is copying in slow............");

        try(
                FileInputStream reader = new FileInputStream(sourcePath);
                FileOutputStream writer = new FileOutputStream(destinationPath)
        ){

            int singleByte;

            while((singleByte = reader.read()) != -1) {
                writer.write(singleByte);
            }

            System.out.println("Image copied successfully in slow!!!!!");

        } catch (IOException ex) {
            System.out.println("Error Copying The Image : " + ex.getMessage());
        }
    }


}

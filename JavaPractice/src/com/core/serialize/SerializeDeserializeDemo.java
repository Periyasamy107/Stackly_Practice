package com.core.serialize;

import java.io.*;

public class SerializeDeserializeDemo {

    public static void main(String[] args) {

        System.out.println("============================================================================");
        System.out.println("           SERIALIZATION AND DESERIALIZATION PROGRAM PRACTICE");
        System.out.println("============================================================================");
        System.out.println();

        String fileName = "Student.ser";
        Student originalStudent = new Student(1234, "Arun","Arun@5676");

        System.out.println("Before Serialization : " + originalStudent);

        // 1) SERIALIZATION (WRITING OBJECT)
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {

            objectOutputStream.writeObject(originalStudent);
            System.out.println("Object successfully converted into byte stream and saved to : " + fileName);
            System.out.println();
            System.out.println("============================================================================");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();

        // 2) DESERIALIZATION (READING OBJECT)
        try(
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {

            Student deserializedStudent = (Student) objectInputStream.readObject();

            System.out.println("After deserialization : " + deserializedStudent);
            System.out.println("Password field is null, because it marked has 'transient'");

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("----------------------------------------------------------------------------");

    }

}

package com.example.order.common.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class FileUtility {

    private FileUtility() {}

    public static void serialize(Object object, Path filePath) throws IOException {

        createParentDirectories(filePath);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                Files.newOutputStream(filePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING))) {

            outputStream.writeObject(object);
            outputStream.flush();
        }
    }

    public static <T> T deserialize(Path filePath, Class<T> type) throws IOException, ClassNotFoundException {

        if(filePath==null || !Files.exists(filePath)) {
            throw new IOException("File does not exist : " + filePath);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(filePath))) {
            Object object = inputStream.readObject();

            if(!type.isInstance(object)) {
                throw new IOException(
                        "Invalid object type in file. Expected : "
                        + type.getName()
                        + ", Actual : "
                        + object.getClass().getName()
                );
            }

            return type.cast(object);
        }
    }

    public static void writeText(String content, Path filePath) throws IOException {
        try(BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write(content);
        }
    }

    public static String readText(Path filePath) throws IOException {
        if(filePath==null || !Files.exists(filePath)) {
            throw new IOException("File does not exist : " + filePath);
        }

        StringBuilder content = new StringBuilder();
        try(BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }

        return content.toString();
    }

    private static void createParentDirectories(Path filePath) throws IOException {
        if(filePath==null) {
            throw new IllegalArgumentException("File path cannot be null");
        }
        Path parent = filePath.getParent();
        System.out.println("file path : " + parent);
        if(parent!=null) {
            Files.createDirectories(parent);
        }
    }

}

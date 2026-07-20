package com.stream;

import java.util.Arrays;
import java.util.List;

public class FindFirst9 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Pen", "Eraser", "Pencil");

        String name = names.stream()
                .findFirst()
                .get();

        System.out.println(name);

    }
}
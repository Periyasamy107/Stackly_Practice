package com.stream;

import java.util.Arrays;
import java.util.List;

public class MapSqureNums3 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        numbers.stream()
                .map(number -> number * number)
                .forEach(System.out::println);

    }
}
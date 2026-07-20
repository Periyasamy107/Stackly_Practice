package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorted4 {
    public static void main(String[] args){

        List<Integer> numbers = Arrays.asList(45,67,12,90,33);

        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
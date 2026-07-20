package com.stream;

import java.util.Arrays;
import java.util.List;

public class Count6 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(45,67,88,22,100);

        long count = numbers.stream()
                .count();

        System.out.println(count);

    }
}
package com.stream;

import java.util.Arrays;
import java.util.List;

public class Distinct8 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,1,2,3,3,4,8,8);

        numbers.stream()
                .distinct()
                .forEach(System.out::println);

    }
}

package com.stream;

import java.util.Arrays;
import java.util.List;

public class Limit7 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);

        numbers.stream()
                .limit(4)
                .forEach(num -> System.out.println(num));

    }
}

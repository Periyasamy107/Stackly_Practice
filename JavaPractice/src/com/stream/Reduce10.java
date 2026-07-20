package com.stream;

import java.util.Arrays;
import java.util.List;

public class Reduce10 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5,5,10,30);

        int sum = numbers.stream()
                .reduce(0, (a,b) -> a+b);

        System.out.println("Sum is : " + sum);

    }
}
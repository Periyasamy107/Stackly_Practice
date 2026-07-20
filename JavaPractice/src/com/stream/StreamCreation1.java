package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreation1 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ram", "Sam", "Tom", "Lina");

        Stream<String> namesStream = names.stream();

        namesStream.forEach(System.out::println);

    }
}
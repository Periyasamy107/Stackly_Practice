package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect5 {
    public static void main(String[] args) {

        List<String> laptopParts = Arrays.asList("Monitor", "Mouse", "Keyboard");

        List<String> laptopPartsCopy = laptopParts.stream()
                .filter(part -> part.contains("r"))
                .collect(Collectors.toList());

        System.out.println(laptopPartsCopy);

    }
}
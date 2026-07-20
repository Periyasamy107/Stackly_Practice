package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {

        List<Character> chars = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'z', 'y', 'x'));

        Iterator<Character> iterator = chars.iterator();

        System.out.println();

        while(iterator.hasNext()){
            System.out.print(iterator.next()+ ", ");
        }

        System.out.println();

        iterator = chars.iterator();

        while(iterator.hasNext()){
            Character currentChar = iterator.next();
            if(currentChar == 'B' || currentChar == 'y') {
                iterator.remove();
            }
        }

        System.out.println();
        for(Character i : chars) {
            System.out.print(i+", ");
        }

        System.out.println();

    }
}

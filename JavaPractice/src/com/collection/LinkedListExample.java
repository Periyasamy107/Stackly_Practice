package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

    public static void main(String[] args) {

        List<Integer> numbers = new LinkedList<>();

        numbers.add(5);
        numbers.add(8);

        numbers.addFirst(100);
        numbers.addLast(200);

        numbers.add(3,333);

        List<Integer> nums = new ArrayList<>(Arrays.asList(55,53));

        numbers.addAll(nums);

        for(int i=0; i<numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        System.out.println();
        System.out.println("Get First :  " + numbers.getFirst());
        System.out.println("Get Last  :  " + numbers.getLast());

        System.out.println();
        System.out.println("Contains : " + numbers.contains(55));
        System.out.println("Index of : " + numbers.indexOf(100));

        System.out.println();
        System.out.println("number removed : " + numbers.remove(3));
        System.out.println("first removed : " + numbers.removeFirst());
        System.out.println("last removed : " + numbers.removeLast());

        System.out.println();
        for(Integer number : numbers) {
            System.out.println(number);
        }


    }

}

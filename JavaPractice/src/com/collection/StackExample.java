package com.collection;

import java.util.List;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {

        Stack<Integer> numbers = new Stack<>();

        numbers.push(55);
        numbers.push(100);
        numbers.push(1000);
        numbers.push(1);

        System.out.println("First Element : " + numbers.getFirst());
        System.out.println("Last Element : " + numbers.getLast());

        System.out.println();
        for(int i=0; i<numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        System.out.println();
        System.out.println("Remove first element : " + numbers.removeFirst());
        System.out.println("Remove last element : " + numbers.removeLast());

        Stack<Integer> nums = (Stack<Integer>)numbers.clone();

        System.out.println();
        for(Integer num : nums) {
            System.out.println(num);
        }

        System.out.println();
        numbers.clear();
        System.out.println("After clear : " + numbers.isEmpty());





    }
}

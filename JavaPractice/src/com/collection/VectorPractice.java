package com.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class VectorPractice {
    public static void main(String[] args) {

        List<Integer> vectorList = new Vector<>();

        vectorList.add(4);
        vectorList.addFirst(1000);
        vectorList.addLast(2000);

        List<Integer> nums = Arrays.asList(66,77,88);

        vectorList.addAll(nums);

        System.out.println("First element : " + vectorList.getFirst());
        System.out.println("Last element : " + vectorList.getLast());
        System.out.println("Any Element 3 rd index : " + vectorList.get(3));

        System.out.println();
        System.out.println("Looping.......");
        for(int i=0; i<vectorList.size(); i++) {
            System.out.println(vectorList.get(i));
        }
        System.out.println();

        System.out.println("Remove First Element : " + vectorList.removeFirst());
        System.out.println("Remove Last Element : " + vectorList.removeLast());

        vectorList.clear();

        System.out.println();
        System.out.println("After clear the list:::");
        System.out.println("Is Empty : " + vectorList.isEmpty());


    }
}

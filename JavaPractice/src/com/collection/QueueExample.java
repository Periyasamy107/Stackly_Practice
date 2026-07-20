package com.collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {

        Queue<String> names = new LinkedList<>();

        names.add("Bob");
        names.offer("Tom");
        names.add("Lina");
        names.offer("Veena");
        names.offer("Linguvas");
        names.offer("Peenish");

        for(String name : names) {
            System.out.println(name);
        }

        System.out.println();
        System.out.println("Peek : " + names.peek());
        System.out.println("Poll : " + names.poll());

        System.out.println();
        System.out.println(names.toString());

        System.out.println();
        System.out.println("Remove Third Element : " + names.remove(3));

        System.out.println();
        System.out.println("Remove all elements : " + names.removeAll(names));

        System.out.println();
        System.out.println("is empty : " + names.isEmpty());

        System.out.println();
        System.out.println(names.toString());


    }
}

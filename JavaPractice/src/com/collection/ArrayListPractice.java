package com.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Monitor");
        names.add("Keyboard");
        names.add("PC");
        names.add("Desktop");

        for(int i=0; i<names.size(); i++) {
            System.out.println(names.get(i));
        }

        names.set(2,"Price");
        names.set(3,"Mouse");
        names.set(0,"Laptop");

        System.out.println();

        for(String name : names) {
            System.out.println(name);
        }

        System.out.println();
        System.out.println(names.get(3));
        System.out.println(names.get(0));

        System.out.println();
        System.out.println(names.contains("Mouse"));
        System.out.println(names.contains("Paper"));

        System.out.println();
        System.out.println(names.indexOf("Mouse"));
        System.out.println(names.indexOf("Pen"));

        names.remove(1);

        System.out.println();
        for(String name : names) {
            System.out.println(name);
        }

        Object[] namesArray = names.toArray();

        System.out.println();
        for(Object name : namesArray) {
            System.out.println(name);
        }

        names.clear();

        System.out.println();
        System.out.println(names.isEmpty());


    }

}

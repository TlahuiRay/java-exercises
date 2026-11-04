package com.amigoscode._4_datastructures._5_linkedlists;

// Exercise: LinkedList vs ArrayList Performance Comparison
// Understand when to use LinkedList vs ArrayList by measuring operation times.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListVsArrayList {

    public static void main(String[] args) {

        // TODO: 1 - Create both an ArrayList<Integer> and a LinkedList<Integer>
        //           Fill each with 10000 elements (0 to 9999) using a for loop
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
            linkedList.add(i);
        }


        // TODO: 2 - Measure time to add an element at the beginning (index 0) for both lists
        //           Use System.nanoTime() before and after the operation
        //           Perform the add(0, value) operation 1000 times for each list
        //           Print the time taken for each in milliseconds
        //           (divide nanoseconds by 1_000_000 to get milliseconds)
        double start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.add(0,i);
        }
        double end = System.nanoTime();
        System.out.println("Add to beginning - List Time: " + (end- start)/1_000_000);

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(0,i);
        }
        end = System.nanoTime();
        System.out.println("Add to beginning - LinkedList Time: " + (end- start)/1_000_000);

        // TODO: 3 - Measure time to add an element at the end for both lists
        //           Perform the add(value) operation 1000 times for each list
        //           Print the time taken for each
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.add(0,i);
        }
        end = System.nanoTime();
        System.out.println("Add to the end - List Time: " + (end- start)/1_000_000);

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(0,i);
        }
        end = System.nanoTime();
        System.out.println("Add to the end  - LinkedList Time: " + (end- start)/1_000_000);


        // TODO: 4 - Measure time to get an element at the middle index for both lists
        //           Perform get(list.size() / 2) operation 1000 times for each list
        //           Print the time taken for each
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.get(list.size() / 2);
        }
        end = System.nanoTime();
        System.out.println("Retrieve from the middle - List Time: " + (end- start)/1_000_000);

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.get(list.size() / 2);
        }
        end = System.nanoTime();
        System.out.println("Retrieve from the middle  - LinkedList Time: " + (end- start)/1_000_000);


        /* TODO: 5 - Print a summary explaining the differences
                   Use System.out.println() to explain:
                   - Why LinkedList is faster for insertions at the beginning
                   LinkedList is faster because it always know the beginning and the end of its nodes, so its faster
                   to add elements at the beginning and at the end.
                   - Why ArrayList is faster for random access (get by index)
                   ArrayList can calculate faster the location of each element inside and go fetch it directly,
                   LinkedList needs to traverse all the structure every single time.
                   - When you would choose one over the other
                   In most of cases ArrayList will do better than LinkedList, however if you need to do continous insertions
                   at the end or beginning you should use a LinkedList.
        */

    }
}

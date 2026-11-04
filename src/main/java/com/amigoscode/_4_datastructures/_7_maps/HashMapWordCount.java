package com.amigoscode._4_datastructures._7_maps;

// Exercise: Word Frequency Counter using HashMap
// A practical exercise to count word occurrences in a sentence.

import java.util.*;

public class HashMapWordCount {

    public static void main(String[] args) {

        String sentence = "the cat sat on the mat and the cat ate the rat on the mat";

        // TODO: 1 - Split the sentence into an array of words using split(" ")
        String[] array = sentence.split(" ");


        // TODO: 2 - Create a HashMap<String, Integer> called 'wordCount'
        //           Iterate through the words array and count the frequency of each word
        //           Hint: use getOrDefault(word, 0) + 1 to increment the count
        Map<String, Integer> wordCount = new HashMap<>();
        for (String s : array) {
            wordCount.put(s, wordCount.getOrDefault(s, 0) + 1);
        }


        // TODO: 3 - Print each word and its count by iterating over the map
        //           Format: "<word>: <count>"
        for(Map.Entry<String, Integer> e : wordCount.entrySet()){
            System.out.println("<"+e.getKey()+">: <"+e.getValue()+">");
        }

        // TODO: 4 - Find and print the most frequent word
        //           Iterate through the entrySet and track the entry with the highest value
        int maxCount = 0;
        String maxWord = "";
        for(Map.Entry<String, Integer> e : wordCount.entrySet()){
            if(e.getValue() > maxCount){
                maxCount = e.getValue();
                maxWord = e.getKey();
            }
        }
        System.out.println("Max Word: " + maxWord +" Max Count: " +maxCount );


        // TODO: 5 - Find and print all words that appear only once
        //           Iterate through the entrySet and collect entries where value == 1
        for(Map.Entry<String, Integer> e : wordCount.entrySet()){
            if(e.getValue() == 1){
                System.out.println("Only one: " + e.getKey() + " " + e.getValue());
            }
        }

        // TODO: 6 - Sort the map entries by value (frequency) in descending order and print
        //           Hint: create a List from entrySet(), then sort using a Comparator
        //           that compares entry values in reverse order
        List<Map.Entry<String,Integer >> list = new ArrayList<>(wordCount.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> e : list){
            System.out.println("Key:" + e.getKey() + " Value: " + e.getValue());
        }
    }
}

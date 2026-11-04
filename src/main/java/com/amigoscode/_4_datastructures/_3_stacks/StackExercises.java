package com.amigoscode._4_datastructures._3_stacks;

// Exercise: Stack Operations
// Learn how to use the Stack data structure - Last In, First Out (LIFO).

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackExercises {

    public static void main(String[] args) {

        // TODO: 1 - Create a Stack of Strings called 'stack'
        Deque<String> stack = new ArrayDeque<>();


        // TODO: 2 - Push 5 elements onto the stack: "Java", "Python", "C++", "JavaScript", "Go"
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");
        stack.push("JavaScript");
        stack.push("Go");


        // TODO: 3 - Peek at the top element without removing it
        //           Print the result (should be "Go")
        System.out.println("Peek: " + stack.peek());

        // TODO: 4 - Pop an element from the stack and print it
        //           Then print the stack to see the remaining elements
        System.out.println("Pop: " + stack.pop());


        // TODO: 5 - Check if the stack is empty using isEmpty()
        //           Print the result
        System.out.println("Is Empty ? " + stack.isEmpty());

        // --- String Reversal ---
        System.out.println("\n--- String Reversal ---");
        String original = "Hello World";
        // TODO: 6 - Use a Stack to reverse the string 'original'
        //           Push each character onto a stack, then pop them all to build the reversed string
        //           Print both original and reversed strings
        Deque<Character> reverse = new ArrayDeque<>();
        for (int i = 0; i < original.length(); i++) {
            reverse.push(original.charAt(i));
        }
        for (Character c: reverse){
            System.out.print(c + " ");
        }



        // --- Balanced Brackets ---
        System.out.println("\n--- Balanced Brackets ---");
        System.out.println(balanceBracketsChecker("({[()]})"));
        System.out.println(balanceBracketsChecker("({[})"));
        // TODO: 7 - Implement a balanced brackets checker
        //           Use a Stack to check if a string of brackets is balanced
        //           For each char: if opening bracket, push it; if closing bracket, check
        //           that the top of stack is the matching opening bracket
        //           Test with both 'balanced' and 'unbalanced' strings
        //           Print whether each string is balanced or not


    }
    private static boolean balanceBracketsChecker(String str){
        Deque<Character> balanceStack = new ArrayDeque<>();
        int index = 0;
        while(index < str.length()){
            if(str.charAt(index) == '(' || str.charAt(index) == '{' || str.charAt(index) == '['){
                balanceStack.push(str.charAt(index));
                index++;
                continue;
            }

            if (str.charAt(index) == ')' || str.charAt(index) == '}' || str.charAt(index) == ']'){
                char c = balanceStack.pop();
                if((c == '(' && str.charAt(index) == ')') ||
                        (c == '{' && str.charAt(index) == '}') ||
                        (c == '[' && str.charAt(index) == ']')){

                    index++;
                } else
                    return false;
            }
        }
        return true;
    }
}

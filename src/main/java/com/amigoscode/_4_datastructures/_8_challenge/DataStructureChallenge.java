package com.amigoscode._4_datastructures._8_challenge;

// Exercise: Data Structure Challenge
// Combine multiple data structures to solve a real-world problem.
// Manage a collection of students, group them, track recently viewed, and generate reports.

import java.util.*;

public class DataStructureChallenge {

    // TODO: 1 - Create a Student record (or class) with three fields:
    //           String name, int grade, String subject
    //           If using a record: record Student(String name, int grade, String subject) {}
    //           If using a class: include constructor, getters, and a toString() method
    record Student(String name, int grade, String subject){ };


    public static void main(String[] args) {

        // TODO: 2 - Create a List of 10 students with various names, grades, and subjects
        //           Use at least 3 different subjects (e.g., "Math", "Science", "English")
        //           Example: new Student("Alice", 92, "Math")
        List<Student> list = new ArrayList<>();
        list.add(new Student("Student A",85,"Math"));
        list.add(new Student("Student B",91,"History"));
        list.add(new Student("Student C",70,"History"));
        list.add(new Student("Student D",99,"Biology"));
        list.add(new Student("Student F",90,"Math"));
        list.add(new Student("Student G",83,"Economy"));
        list.add(new Student("Student H",65,"Math"));
        list.add(new Student("Student I",78,"Economy"));
        list.add(new Student("Student J",95,"Literature"));
        list.add(new Student("Student K",89,"Math"));


        // TODO: 3 - Use a Map<String, List<Student>> to group students by subject
        //           Iterate through the student list
        //           For each student, use computeIfAbsent() to get or create the list for their subject
        //           Then add the student to that list
        //           Print each subject and its students
        Map<String, List<Student>> groupMap = new HashMap<>();
        for(Student s: list){
            groupMap.computeIfAbsent(s.subject, k->new ArrayList<>()).add(s);
        }
        System.out.println("Map");
        for (Map.Entry<String, List<Student>> e : groupMap.entrySet()){
            System.out.println("Subject: " + e.getKey() + " " + e.getValue());
        }


        // TODO: 4 - Use a Set<String> to find all unique subjects
        //           Iterate through the students and add each subject to the set
        //           Print the unique subjects
        Set<String> uniqueSet = new HashSet<>();
        for(Student s: list){
            uniqueSet.add(s.subject);
        }
        System.out.println("Unique Set");
        System.out.println(uniqueSet);


        // TODO: 5 - Use a Stack<Student> to track the last 3 students "viewed"
        //           Push any 3 students from the list onto the stack
        //           Then pop and print them to show the viewing history (most recent first)
        Deque<Student> stack = new ArrayDeque<>();
        for(int i = 0; i < 3; i++){
            stack.push(list.get(i));
        }
        System.out.println("Stack");
        for(Student s: stack){
            System.out.println(s);
        }


        // TODO: 6 - Sort the student list by grade in descending order using a Comparator
        //           Use list.sort() with Comparator.comparingInt() and .reversed()
        //           Print the sorted list
        list.sort(Comparator.comparingInt(Student::grade).reversed());
        System.out.println("Sorted");
        System.out.println(list);


        // TODO: 7 - Print a summary report:
        //           - Total number of students
        //           - Number of unique subjects (from the Set)
        //           - Highest grade student (first in sorted list)
        //           - Number of students per subject (from the Map)
        System.out.println("Total number of students: " + list.size());
        System.out.println("Number of unique subjects: " + uniqueSet.size() + " | Subjects:" + uniqueSet);
        System.out.println("Highest grade student" + list.getFirst());
        System.out.println("Number of students per subject");
        for (Map.Entry<String, List<Student>> e : groupMap.entrySet()){
            System.out.println(e.getKey() + ", Total:  " + e.getValue().size());
        }

    }
}

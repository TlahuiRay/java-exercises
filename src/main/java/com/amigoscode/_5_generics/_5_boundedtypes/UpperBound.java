package com.amigoscode._5_generics._5_boundedtypes;

import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Upper Bounded Type Parameters
 *
 * This exercise demonstrates bounded type parameters using "extends".
 * When you write <T extends Number>, T can only be Number or its subclasses
 * (Integer, Double, Long, etc.). This lets you call Number methods like
 * doubleValue() on values of type T.
 *
 * Complete the TODOs below.
 */
public class UpperBound {

    // TODO: 1 - Create a static generic method: <T extends Number> double sum(List<T> list)
    //  It should return the sum of all elements as a double.
    //  Use the doubleValue() method on each element (available because T extends Number).
    static <T extends Number> double sum(List<T> list){
        double total = 0;
        for(T t : list){
            total+=t.doubleValue();
        }
        return total;
    }

    // TODO: 2 - Create a static generic method: <T extends Number> T findMax(List<T> list)
    //  It should return the largest element in the list.
    //  Compare elements using doubleValue(). If the list is empty, return null.
    static <T extends Number> T findMax(List<T> list){
        if(list.isEmpty())
            return null;
        T max = list.getFirst();
        for(int i = 1; i < list.size(); i++){
            if(list.get(i).doubleValue() > max.doubleValue())
                max = list.get(i);
        }
        return max;
    }

    // TODO: 3 - Create a generic class NumberBox<T extends Number> with a private T field
    //  called "number" and a constructor that takes T.
    class NumberBox<T extends Number>{
        private T number;

        public NumberBox(T number) {
            this.number = number;
        }
        boolean isPositive(){
            return number.doubleValue() > 0 ? true : false;
        }

        public Integer toInt(){
            return number.intValue();
        }

        public Double toDouble(){
            return number.doubleValue();
        }
    }

    // TODO: 4 - In NumberBox, add an isPositive() method that returns true if the
    //  stored number's doubleValue() is greater than 0.


    // TODO: 5 - In NumberBox, add toInt() and toDouble() conversion methods that
    //  return the stored number as an int (using intValue()) and as a double
    //  (using doubleValue()) respectively.


    public static void main(String[] args) {

        // TODO: 6 - Test sum() and findMax() with:
        //  (a) A List<Integer> e.g., Arrays.asList(1, 2, 3, 4, 5)
        //  (b) A List<Double> e.g., Arrays.asList(1.5, 2.5, 3.5)
        //  Print the results for each.
        //  Also create a NumberBox<Integer> and NumberBox<Double> and test
        //  isPositive(), toInt(), and toDouble().
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> list2 = Arrays.asList(1.5, 2.5, 3.5);
        System.out.println(sum(list1));
        System.out.println(findMax(list1));
        System.out.println(sum(list2));
        System.out.println(findMax(list2));

        // TODO: 7 - Uncomment the line below and observe the compile error.
        //  Then comment it back out and add a comment explaining why it fails.
        //
        //List<String> strings = Arrays.asList("a", "b");
        //double result = sum(strings);  // Why does this not compile?
        //java: method sum in class com.amigoscode._5_generics._5_boundedtypes.UpperBound cannot be applied to given types;
//        required: java.util.List<T>
//        found:    java.util.List<java.lang.String>

    }
}

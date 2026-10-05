package com.amigoscode._2_developers._5_methods;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Variable Arguments (Varargs) Exercises
 *
 * Practice using the varargs syntax (Type... name) which allows methods to accept
 * zero or more arguments of the same type. Internally, varargs are treated as arrays.
 */
public class VarArgs {

    // TODO: 1 - Create a method: int sum(int... numbers)
    //  Returns the sum of all provided numbers.
    //  If no arguments are provided, return 0.
    //  Hint: use a for-each loop to iterate over 'numbers'.
    public int sum(int... numbers){
        int sum = 0;
        for(int val : numbers){
            sum+=val;
        }
        return sum;
    }


    // TODO: 2 - Create a method: String concatenate(String... strings)
    //  Joins all strings with a single space between them.
    //  Example: concatenate("Hello", "World") returns "Hello World"
    //  If no arguments, return an empty string "".
    //  Hint: use StringBuilder or String.join(" ", strings).
    public String concatenate(String... strings){
        StringBuilder builder = new StringBuilder("");
        for(String str : strings )
            builder.append(str + " ");
        return builder.toString();
    }


    // TODO: 3 - Create a method: int findMax(int... numbers)
    //  Returns the largest value among the arguments.
    //  If no arguments are provided, throw an IllegalArgumentException
    //  with the message "At least one number required".
    public int findMax(int... numbers){
        if(numbers.length == 0)
                throw new IllegalArgumentException("At least one number required");
        int largest = 0;
        for(int val: numbers){
            if(val > largest) largest = val;
        }
        return largest;
    }


    // TODO: 4 - Create a method: void printAll(Object... items)
    //  Prints each item on a separate line, prefixed with its index.
    //  Example output:
    //    [0] Hello
    //    [1] 42
    //    [2] true
    public void printAll(Object... items){
        for(int i = 0; i < items.length; i++){
            System.out.println("["+i+"]"+items[i].toString());
        }
    }

    // TODO: 6 - Create a method: String format(String prefix, int... numbers)
    //  The first parameter is a regular String, followed by varargs.
    //  Returns the prefix followed by the numbers in brackets.
    //  Example: format("Values", 1, 2, 3) returns "Values: [1, 2, 3]"
    //  Hint: varargs must be the LAST parameter in the method signature.
    //  Then call the method and print the result here.
    public String format(String prefix, int... numbers){
        StringBuilder numbersBuilder = new StringBuilder("");
        for(int val : numbers )
            numbersBuilder.append(String.valueOf(val) + ", ");
        return prefix + ": ["+ numbersBuilder.toString().trim() +"]";
    }

    public static BigDecimal calculateRentalYield(double monthlyRentalIncome, double propertyPrice) {
        double rentalYield =  ((monthlyRentalIncome * 12) / propertyPrice) * 100;
        return new BigDecimal(rentalYield).setScale(2, RoundingMode.HALF_UP );
    }


    public static void main(String[] args) {
        VarArgs va = new VarArgs();

        System.out.println("=== Sum ===");
        // TODO: 5 - Demonstrate calling sum() with different numbers of arguments:
        System.out.println(va.sum());
        System.out.println(va.sum(5));
        System.out.println(va.sum(1,2,3));

        System.out.println("\n=== Concatenate ===");
        System.out.println(va.concatenate("Java", "is", "awesome"));

        System.out.println("\n=== Find Max ===");
        System.out.println(va.findMax(3, 7, 2, 9, 1));

        System.out.println("\n=== Print All ===");
        va.printAll("Hello", 42, true, 3.14);

        System.out.println("\n=== Mixed Params ===");
        System.out.println(va.format("Values", 1, 2, 3));

        System.out.println("Calculate Rental Yield: " + calculateRentalYield(1300, 250000));

    }
}

package _6kyu;

import java.util.ArrayList;
import java.util.List;

/*
FizzBuzz is often one of the first programming puzzles people learn. Now undo it with reverse FizzBuzz!

Write a function that accepts a string, which will always be a valid section of FizzBuzz.
Your function must return an array that contains the numbers in order to generate the given section of FizzBuzz.

Notes:
If the sequence can appear multiple times within FizzBuzz, return the numbers that generate the first instance of that sequence.
All numbers in the sequence will be greater than zero.
You will never receive an empty sequence.

Examples
reverse_fizzbuzz("1 2 Fizz 4 Buzz")        -->  [1, 2, 3, 4, 5]
reverse_fizzbuzz("Fizz 688 689 FizzBuzz")  -->  [687, 688, 689, 690]
reverse_fizzbuzz("Fizz Buzz")              -->  [9, 10]
 */
public class CW49_ReverseFizzBuzz {
    public static void main(String[] args) {
        System.out.println(reverseFizzBuzz("1 2 Fizz 4 Buzz"));
        System.out.println(reverseFizzBuzz("Fizz 688 689 FizzBuzz"));
        System.out.println(reverseFizzBuzz("Fizz Buzz"));
    }

    public static List<Integer> reverseFizzBuzz(String string) {
        return new ArrayList<>();
    }
}
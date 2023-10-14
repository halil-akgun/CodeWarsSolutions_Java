package _7kyu;

import java.util.stream.IntStream;

/*
Given two integers a and b, which can be positive or negative, find the sum of all the integers
between and including them and return it. If the two numbers are equal return a or b.

Note: a and b are not ordered!

Examples (a, b) --> output (explanation)
(1, 0) --> 1 (1 + 0 = 1)
(1, 2) --> 3 (1 + 2 = 3)
(0, 1) --> 1 (0 + 1 = 1)
(1, 1) --> 1 (1 since both are same)
(-1, 0) --> -1 (-1 + 0 = -1)
(-1, 2) --> 2 (-1 + 0 + 1 + 2 = 2)
Your function should only return a number, not the explanation about how you get that number.
 */
public class CW28_BeginnerSeries3SumOfNumbers {
    public static void main(String[] args) {
        System.out.println(GetSum(-1, 0));
    }

    public static int GetSum(int a, int b) {
        if (b < a) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        return IntStream.rangeClosed(a, b).sum();

        // Unnamed, zoid, oangelina, iskoch, Vladbrim, Marszal, dengtian, jin2clear, Mr. Z, olagz (+ 145)
//        return (a + b) * (Math.abs(a - b) + 1) / 2;
    }
}

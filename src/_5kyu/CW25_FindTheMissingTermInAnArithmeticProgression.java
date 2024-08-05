package _5kyu;

import java.util.stream.IntStream;

/*
An Arithmetic Progression is defined as one in which there is a constant difference between the consecutive terms
of a given series of numbers. You are provided with consecutive elements of an Arithmetic Progression.
There is however one hitch: exactly one term from the original series is missing from the set of numbers
which have been given to you. The rest of the given series is the same as the original AP. Find the missing term.

You have to write a function that receives a list, list size will always be at least 3 numbers.
The missing term will never be the first or last one.

Example
findMissing([1, 3, 5, 9, 11]) == 7
PS: This is a sample question of the facebook engineer challenge on interviewstreet. I found it quite fun
to solve on paper using math, derive the algo that way. Have fun!
 */
public class CW25_FindTheMissingTermInAnArithmeticProgression {
    public static void main(String[] args) {
        System.out.println(findMissing(new int[]{1, 3, 5, 9, 11})); // 7
        System.out.println(findMissing(new int[]{4, 3, 1})); // 2
        System.out.println(findMissing(new int[]{1, 1, 1})); // 1
    }

    public static int findMissing(int[] numbers) {
        int range = numbers[1] - numbers[0] > 0
                ? Math.min(numbers[1] - numbers[0], numbers[numbers.length - 1] - numbers[numbers.length - 2])
                : Math.max(numbers[1] - numbers[0], numbers[numbers.length - 1] - numbers[numbers.length - 2]);
        if (range == 0) return numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] - numbers[i - 1] != range) return numbers[i] - range;
        }
        return 0;

        // ParanoidUser, lsalema, kathrinewhere:
//        return (numbers[0] + numbers[numbers.length - 1]) * (numbers.length + 1) / 2 - IntStream.of(numbers).sum();
    }
}

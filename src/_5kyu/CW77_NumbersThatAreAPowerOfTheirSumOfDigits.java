package _5kyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
The number 81 has a special property, a certain power of the sum of its digits is equal
to 81 (nine squared). Eighty one (81), is the first number in having this property
(not considering numbers of one digit). The next one, is 512. Let's see both cases with the details

8 + 1 = 9 and 9^2 = 81
512 = 5 + 1 + 2 = 8 and 8^3 = 512

We need to make a function that receives a number as argument n and returns the n-th term of this sequence of numbers.

Examples (input --> output)
1 --> 81
2 --> 512
 */
public class CW77_NumbersThatAreAPowerOfTheirSumOfDigits {
    public static void main(String[] args) {
        System.out.println(powerSumDigTerm(1)); // 81
        System.out.println(powerSumDigTerm(2)); // 512
        System.out.println(powerSumDigTerm(30)); // 512
    }

    private static List<Long> results;
    private static final List<Long> distinctResults = new ArrayList<>();

    public static long powerSumDigTerm(int n) {

        if (results == null) {
            results = generatePowerSumNumbers();

            // Sort the obtained results
            Collections.sort(results);

            // Remove duplicate numbers
            for (Long result : results) {
                if (!distinctResults.contains(result)) {
                    distinctResults.add(result);
                }
            }
        }

        return distinctResults.get(n - 1);
    }

    private static List<Long> generatePowerSumNumbers() {
        List<Long> results = new ArrayList<>();

        // Starting from 2, try all possibilities up to large digit sums
        for (int digitSum = 2; digitSum <= 100; digitSum++) { // Digit sum limit up to 100
            for (int power = 2; power < 10; power++) { // Power limit, try for larger powers
                long result = (long) Math.pow(digitSum, power);
                if (sumOfDigits(result) == digitSum) {
                    results.add(result); // Add the number if it satisfies the digit sum condition
                }
            }
        }

        return results;
    }

    private static long sumOfDigits(long number) {
        long sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

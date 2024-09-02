package _5kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
We want to find the numbers higher or equal than 1000 that the sum of every four consecutives digits cannot be higher
than a certain given value. If the number is num = d1d2d3d4d5d6, and the maximum sum of 4 contiguous digits is maxSum, then:
d1 + d2 + d3 + d4 <= maxSum
d2 + d3 + d4 + d5 <= maxSum
d3 + d4 + d5 + d6 <= maxSum

For that purpose, we need to create a function, max_sumDig(), that receives nMax, as the max value of the interval
to study (the range (1000, nMax) ), and a certain value, maxSum, the maximum sum that every four consecutive digits
should be less or equal to. The function should output the following list with the data detailed bellow:
[(1), (2), (3)]
(1) - the amount of numbers that satisfy the constraint presented above
(2) - the closest number to the mean of the results, if there are more than one, the smallest number should be chosen.
(3) - the total sum of all the found numbers

Let's see a case with all the details:
max_sumDig(2000, 3) -------> [11, 1110, 12555]

(1) - There are 11 found numbers: 1000, 1001, 1002, 1010, 1011, 1020, 1100, 1101, 1110, 1200 and 2000
(2) - The mean of all the found numbers is:
      (1000 + 1001 + 1002 + 1010 + 1011 + 1020 + 1100 + 1101 + 1110 + 1200 + 2000) /11 = 1141.36363,
      so 1110 is the number that is closest to that mean value.
(3) - 12555 is the sum of all the found numbers
      1000 + 1001 + 1002 + 1010 + 1011 + 1020 + 1100 + 1101 + 1110 + 1200 + 2000 = 12555

Finally, let's see another cases
max_sumDig(2000, 4) -----> [21, 1120, 23665]
max_sumDig(2000, 7) -----> [85, 1200, 99986]
max_sumDig(3000, 7) -----> [141, 1600, 220756]
 */
public class CW52_HowManyNumbers2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSumDig(2000, 3))); // [11, 1110, 12555]
        System.out.println(Arrays.toString(maxSumDig(2000, 4))); // [21, 1120, 23665]
        System.out.println(Arrays.toString(maxSumDig(2000, 7))); // [85, 1200, 99986]
        System.out.println(Arrays.toString(maxSumDig(3000, 7))); // [141, 1600, 220756]
    }

    public static long[] maxSumDig(long nmax, int maxsm) {
        List<Long> validNumbers = new ArrayList<>();
        for (long i = 1000; i <= nmax; i++) {
            if (isValid(i, maxsm))
                validNumbers.add(i);
        }
        long totalSum = validNumbers.stream().mapToLong(Long::longValue).sum();
        double average = (double) totalSum / validNumbers.size();

        long closestToAverage = validNumbers.stream()
                .min((a, b) -> {
                    double diffA = Math.abs(a - average);
                    double diffB = Math.abs(b - average);
                    return Double.compare(diffA, diffB);
                })
                .orElse(0L);

        return new long[]{validNumbers.size(), closestToAverage, totalSum};
    }

    private static boolean isValid(long number, int maxSum) {
        String numStr = String.valueOf(number);

        // way 1 - slow
//        while (numStr.length() >= 4) {
//            if (Arrays.stream(numStr.substring(numStr.length() - 4).split("")).mapToInt(Integer::parseInt).sum() > maxSum)
//                return false;
//            numStr = String.valueOf(number / 10);
//        }

        // way 2 - fast
        for (int i = 0; i <= numStr.length() - 4; i++) {
            int sumOfDigits = 0;
            for (int j = i; j < i + 4; j++) {
                sumOfDigits += numStr.charAt(j) - '0';
            }
            if (sumOfDigits > maxSum) {
                return false;
            }
        }

        return true;
    }
}

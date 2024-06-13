package _6kyu;

import java.util.ArrayList;
import java.util.List;

/*
If possible, divide the integers 1,2,…,n into two sets of equal sum.

Input
A positive integer n <= 1,000,000.

Output
If it's not possible, return [ ] (Python, Javascript, Swift, Ruby) or ( ) (Python) or [ [],[] ] (Java, C#, C++, Kotlin) or None (Scala).
If it's possible, return two disjoint sets. Each integer from 1 to n must be in one of them.
The integers in the first set must sum up to the same value as the integers in the second set.
The sets can be returned in a tuple, list, or array, depending on language.

Examples:
For n = 8, valid answers include:
[1, 3, 6, 8], [2, 4, 5, 7] (or [[1, 3, 6, 8], [2, 4, 5, 7]])
[8, 1, 3, 2, 4], [5, 7, 6]
[7, 8, 3], [6, 1, 5, 4, 2], and others.

For n = 9 it is not possible. For example, try [6, 8, 9] and [1, 2, 3, 4, 5, 7],
but the first sums to 23 and the second to 22. No other sets work either.
 */
public class CW31_TwoSetsOfEqualSum {
    public static void main(String[] args) {
        List<List<Integer>> result = createTwoSetsOfEqualSum(527612);
        result.forEach(System.out::println);

        // Sum of the first set
        int sumSet1 = result.get(0).stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of Set 1: " + sumSet1);

        // Sum of the second set
        int sumSet2 = result.get(1).stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of Set 2: " + sumSet2);
    }

    private static List<List<Integer>> createTwoSetsOfEqualSum(int n) {

        long totalSum = ((long) n * (n + 1)) / 2;

        if (totalSum % 2 != 0) {
            return List.of(new ArrayList<>(), new ArrayList<>()); // not possible
        }

        long halfSum = totalSum / 2;
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            if (i <= halfSum) {
                set1.add(i);
                halfSum -= i;
            } else {
                set2.add(i);
            }
        }

        return List.of(set1, set2);
    }
}

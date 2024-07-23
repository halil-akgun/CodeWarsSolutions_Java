package _5kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1, 246, 2, 123, 3, 82, 6, 41 are the divisors of number 246. Squaring these divisors we get:
1, 60516, 4, 15129, 9, 6724, 36, 1681. The sum of these squares is 84100 which is 290 * 290.

Task
Find all integers between m and n (m and n integers with 1 <= m <= n) such that the sum of their squared divisors is itself a square.

We will return an array of subarrays or of tuples (in C an array of Pair) or a string.
The subarrays (or tuples or Pairs) will have two elements: first the number the squared
divisors of which is a square and then the sum of the squared divisors.

Example:
list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
list_squared(42, 250) --> [[42, 2500], [246, 84100]]
The form of the examples may change according to the language, see "Sample Tests".

Note
In Fortran - as in any other language - the returned string is not permitted to contain any redundant
trailing whitespace: you can use dynamically allocated character strings.
 */
public class CW17_Integers_RecreationOne {
    public static void main(String[] args) {
        System.out.println(listSquared(1, 250)); // [[1, 1], [42, 2500], [246, 84100]]
        System.out.println(listSquared(42, 250)); // [[42, 2500], [246, 84100]]
    }

    public static String listSquared(long m, long n) {
        List<long[]> resultList = new ArrayList<>();

        for (long i = m; i <= n; i++) {
            long sum = sumOfSquaredDivisorsIfSquare(i);
            if (sum != -1) {
                resultList.add(new long[]{i, sum});
            }
        }

        long[][] result = new long[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return Arrays.deepToString(result);
    }

    private static long sumOfSquaredDivisorsIfSquare(long num) {
        List<Long> list = new ArrayList<>();

        for (long i = 1; i <= num; i++) {
            if (num % i == 0) {
                list.add(i * i);
            }
        }

        long sum = list.stream().reduce(0L, Long::sum);

        return Math.pow((int) Math.sqrt(sum), 2) == sum ? sum : -1;
    }
}

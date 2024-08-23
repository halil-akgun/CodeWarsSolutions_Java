package _5kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
A natural number is called k-prime if it has exactly k prime factors, counted with multiplicity. For example:

k = 2  -->  4, 6, 9, 10, 14, 15, 21, 22, ...
k = 3  -->  8, 12, 18, 20, 27, 28, 30, ...
k = 5  -->  32, 48, 72, 80, 108, 112, ...

A natural number is thus prime if and only if it is 1-prime.

Task:
Complete the function count_Kprimes (or countKprimes, count-K-primes, kPrimes) which is given parameters k,
start, end (or nd) and returns an array (or a list or a string depending on the language - see "Solution"
and "Sample Tests") of the k-primes between start (inclusive) and end (inclusive).

Example:
countKprimes(5, 500, 600) --> [500, 520, 552, 567, 588, 592, 594]

Notes:
The first function would have been better named: findKprimes or kPrimes :-)
In C some helper functions are given (see declarations in 'Solution').
For Go: nil slice is expected when there are no k-primes between start and end.

Second Task: puzzle (not for Shell)
Given a positive integer s, find the total number of solutions of the equation a + b + c = s,
where a is 1-prime, b is 3-prime, and c is 7-prime.

Call this function puzzle(s).

Examples:
puzzle(138)  -->  1  because [2 + 8 + 128] is the only solution
puzzle(143)  -->  2  because [3 + 12 + 128] and [7 + 8 + 128] are the solutions
 */
public class CW43_kPrimes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countKprimes(5, 500, 600))); // [500, 520, 552, 567, 588, 592, 594]
        System.out.println(Arrays.toString(countKprimes(5, 5550222, 5553596)));
        System.out.println(Arrays.toString(countKprimes(2, 0, 100)));
        System.out.println(puzzle(138)); // 1
        System.out.println(puzzle(143)); // 2
    }

    static Map<Long, Long> cache = new HashMap<>();

    public static long[] countKprimes(int k, long start, long end) {
        List<Long> list = new ArrayList<>();
        if (start == 0) start = 1;
        for (long i = start; i <= end; i++) {
            if (countPrimeFactors(i) == k) {
                list.add(i);
            }
        }
        return list.stream().mapToLong(Long::longValue).toArray();
    }

    public static int puzzle(int s) {
        countKprimes(1, 2, s); // for cache
        long[] threePrimes = countKprimes(3, 2, s);
        long[] sevenPrimes = countKprimes(7, 2, s);

        int count = 0;
        for (long i : sevenPrimes) {
            for (long j : threePrimes) {
                long k = s - i - j;
                if (k > 0 && cache.getOrDefault(k, 0L) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static long countPrimeFactors(long n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        long original = n;
        long count = 0;

        // way 1 (slow)
//        for (long i = 2; i <= n; i++) {
//            while (n % i == 0) {
//                cont++;
//                n /= i;
//            }
//        }

        // way 2 - chatGPT
        // First, we check for divisibility by 2, as eliminating even factors quickly is more efficient.
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        // Now, we test the remaining number with prime numbers starting from 3.
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                count++;
                n /= i;
            }
        }
        // If n is still greater than 2, it indicates that n is a prime number.
        if (n > 2) {
            count++;
        }

        cache.put(original, count);
        return count;
    }
}

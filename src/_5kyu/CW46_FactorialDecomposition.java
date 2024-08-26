package _5kyu;

import java.util.HashMap;
import java.util.TreeMap;

/*
The aim of the kata is to decompose n! (factorial n) into its prime factors.

Examples:
n = 12; decomp(12) -> "2^10 * 3^5 * 5^2 * 7 * 11"
since 12! is divisible by 2 ten times, by 3 five times, by 5 two times and by 7 and 11 only once.
n = 22; decomp(22) -> "2^19 * 3^9 * 5^4 * 7^3 * 11^2 * 13 * 17 * 19"
n = 25; decomp(25) -> 2^22 * 3^10 * 5^6 * 7^3 * 11^2 * 13 * 17 * 19 * 23
Prime numbers should be in increasing order. When the exponent of a prime is 1 don't put the exponent.

Notes
the function is decomp(n) and should return the decomposition of n! into its prime factors in increasing order of the primes, as a string.
factorial can be a very big number (4000! has 12674 digits, n can go from 300 to 4000).
In Fortran - as in any other language - the returned string is not permitted to contain any redundant trailing
whitespace: you can use dynamically allocated character strings.
 */
public class CW46_FactorialDecomposition {
    public static void main(String[] args) {
        System.out.println(decomp(12)); // "2^10 * 3^5 * 5^2 * 7 * 11"
        System.out.println(decomp(22)); // "2^19 * 3^9 * 5^4 * 7^3 * 11^2 * 13 * 17 * 19"
        System.out.println(decomp(25)); // "2^22 * 3^10 * 5^6 * 7^3 * 11^2 * 13 * 17 * 19 * 23"
        System.out.println(decomp(4000));
    }

    static HashMap<Integer, Integer> primeFactorCounts = new HashMap<>();

    public static String decomp(int n) {
        primeFactorCounts.clear();
        for (int i = 2; i <= n; i++) {
            calculatePrimeFactors(i);
        }

        TreeMap<Integer, Integer> sortedPrimeFactors = new TreeMap<>(primeFactorCounts);

        StringBuilder result = new StringBuilder();
        for (int i : sortedPrimeFactors.keySet()) {
            if (sortedPrimeFactors.get(i) == 1) {
                result.append(" * ").append(i);
            } else if (sortedPrimeFactors.get(i) > 1) {
                result.append(" * ").append(i).append("^").append(sortedPrimeFactors.get(i));
            }
        }
        return result.substring(3);

        // Jomopipi, kirill998, yathindra, M_Andreev, Tirajiqta, Kuzmanov_Mario, Ivan534635, SpringtrapGamer25, atilafikret, dobrin2003, Springtrap1234 (+ 9):
//        int[] exponentsOfPrimes = new int[n+1];
//        while (n>1) {
//            int x = n--;
//            for (int i=2; i<=Math.sqrt(x); i++)
//                if (x % i == 0) {
//                    x /= i;
//                    exponentsOfPrimes[i]++;
//                    i = 1; // i-- is better
//                }
//            exponentsOfPrimes[x]++;
//        }
//        StringBuilder result = new StringBuilder();
//        for (int i = 2; i < exponentsOfPrimes.length; i++) {
//            if (exponentsOfPrimes[i] == 0) continue;
//            if (exponentsOfPrimes[i] == 1) result.append(i + " * ");
//            if (exponentsOfPrimes[i] >  1) result.append(i + "^" + exponentsOfPrimes[i] + " * ");
//        }
//        return result.substring(0,result.length()-3);
    }

    private static void calculatePrimeFactors(int num) {
        // First, we check for divisibility by 2, as eliminating even factors quickly is more efficient.
        while (num % 2 == 0) {
            primeFactorCounts.put(2, primeFactorCounts.getOrDefault(2, 0) + 1);
            num /= 2;
        }
        // Now, we test the remaining number with prime numbers starting from 3.
        for (int i = 3; i * i <= num; i += 2) {
            while (num % i == 0) {
                primeFactorCounts.put(i, primeFactorCounts.getOrDefault(i, 0) + 1);
                num /= i;
            }
        }
        // If n is still greater than 2, it indicates that n is a prime number.
        if (num > 2) {
            primeFactorCounts.put(num, primeFactorCounts.getOrDefault(num, 0) + 1);
        }
    }
}

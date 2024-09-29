package _5kyu;

/*
Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :
"(p1**n1)(p2**n2)...(pk**nk)"

with the p(i) in increasing order and n(i) empty if n(i) is 1.

Example: n = 86240 should return "(2**5)(5)(7**2)(11)"
 */
public class CW75_PrimesInNumbers {
    public static void main(String[] args) {
        System.out.println(factors(86240)); // (2**5)(5)(7**2)(11)
    }

    public static String factors(int n) {

        StringBuilder result = new StringBuilder();

        int count = 0;

        // First, we check for divisibility by 2, as eliminating even factors quickly is more efficient.
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        result.append(formatPrimeFactor(2, count));

        // Now, we test the remaining number with prime numbers starting from 3.
        for (int i = 3; i * i <= n; i += 2) {
            count = 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }
            result.append(formatPrimeFactor(i, count));
        }

        // If n is still greater than 2, it indicates that n is a prime number.
        if (n > 2) {
            result.append(formatPrimeFactor(n, 1));
        }

        return result.toString();
    }

    private static String formatPrimeFactor(int prime, int exponent) {
        if (exponent == 0)
            return "";
        else if (exponent == 1)
            return "(" + prime + ")";
        else
            return "(" + prime + "**" + exponent + ")";
    }
}

package _8kyu;

import java.math.BigInteger;

/*
Wilson primes satisfy the following condition. Let P represent a prime number.

Then,
((P-1)! + 1) / (P * P)
should give a whole number.

Your task is to create a function that returns true if the given number is a Wilson prime.
 */
public class CW43_WilsonPrimes {
    public static void main(String[] args) {
        System.out.println(am_i_wilson(563));
    }

    public static boolean am_i_wilson(double n) {
        if (n == 1 || n == 0) return false; // Wilson's theorem applies only to prime numbers
        BigInteger factorial = calculateFactorial(n - 1);
        BigInteger result = factorial.add(BigInteger.ONE);
        BigInteger modulus = BigInteger.valueOf((long) (n * n));
        return isPrime(BigInteger.valueOf((long) n)) && result.mod(modulus).equals(BigInteger.ZERO);


//        long modulus = (long) (n * n);
//        long product = 1;
//        for (long factor = 2; factor < n; factor++)
//            product = (product * factor) % modulus;
//        return product + 1 == modulus;
    }

    private static boolean isPrime(BigInteger n) {
        return n.isProbablePrime(1); // '1', kesinlik parametresini temsil eder. arttikca kesinlik artar
    }

    private static BigInteger calculateFactorial(double v) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= v; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}

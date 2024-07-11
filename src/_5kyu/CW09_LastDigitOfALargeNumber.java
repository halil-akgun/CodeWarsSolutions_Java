package _5kyu;

import java.math.BigInteger;

/*
Define a function that takes in two non-negative integers 𝑎 and 𝑏 and returns the last decimal digit of 𝑎^𝑏.
Note that 𝑎 and 𝑏 may be very large!

For example, the last decimal digit of 9^7 is 9, since 9^7=4782969. The last decimal digit of (2^200)^2^300, which has over 10^92 decimal digits, is 6. Also, please take 0^0  to be 1.

You may assume that the input will always be valid.

Examples
lastDigit(new BigInteger("4"), new BigInteger("1")) // returns 4
lastDigit(new BigInteger("4"), new BigInteger("2")) // returns 6
lastDigit(new BigInteger("9"), new BigInteger("7")) // returns 9
lastDigit(new BigInteger("10"), new BigInteger("10000000000")) // returns 0
 */
public class CW09_LastDigitOfALargeNumber {
    public static void main(String[] args) {
        System.out.println(lastDigit(new BigInteger("4"), new BigInteger("1"))); // 4
        System.out.println(lastDigit(new BigInteger("4"), new BigInteger("2"))); // 6
        System.out.println(lastDigit(new BigInteger("9"), new BigInteger("7"))); // 9
        System.out.println(lastDigit(new BigInteger("10"), new BigInteger("10000000000"))); // 0
        System.out.println(lastDigit(new BigInteger("1602391852"), new BigInteger("1945723917"))); // 2
        System.out.println(lastDigit(new BigInteger("1191956864"), new BigInteger("1916269976"))); // 6
    }

    public static int lastDigit(BigInteger n1, BigInteger n2) {

        /*
            pay attention to the digits in the ones place

            ...0^n  ->  0 0 0...
            ...1^n  ->  1 1 1...
            ...2^n  ->  2 4 8 16	32 4 8 16
            ...3^n  ->  3 9 27 21	3 9 27 21
            ...4^n  ->  4 16 24 16	24 16 24 16
            ...5^n  ->  5 25 125...
            ...6^n  ->  6 36 36...
            ...7^n  ->  7 49 63 21	7 49 63 21
            ...8^n  ->  8 64 32 16	48 64 32 16
            ...9^n  ->  9 81 9 81...

            Depending on the value of n1, there can be at most 4 different digits in the ones place.
         */

        if (n1.equals(BigInteger.ZERO) || n2.equals(BigInteger.ZERO)) {
            return 1;
        }

        int a = n1.remainder(BigInteger.TEN).intValue();
        int b = (n2.remainder(BigInteger.valueOf(100)).intValue() % 4) + 4;

        if (a == 0) {
            return 0;
        }

        int result = (int) Math.pow(a, b);

        return BigInteger.valueOf(result).remainder(BigInteger.TEN).intValue();


        // whereslynx, jogchem, Lubchynsky, Vlad-j-code, Husoski, david.pb, Eduardo532, hellnn, pirsu, Harsh-Saparia (+ 22):
//        return n1.modPow(n2, BigInteger.TEN).intValue();
    }
}

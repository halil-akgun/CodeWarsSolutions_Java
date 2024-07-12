package _5kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
The number 1089 is the smallest one, non palindromic, that has the same prime factors that its reversal. Thus,

prime factorization of 1089 with 3, 3, 11, 11 -------> 3, 11

prime factorization of 9801 with  3, 3, 3, 3, 11, 11 -------> 3, 11
The task for this kata is to create a function same_factRev(), that receives a nMax,
to find all the numbers with the above property, bellow nMax.

the function same_factRev(), will output a sorted list with the found numbers bellow nMax

Let'se some cases

same_factRev(1100) -----> [1089]

same_factRev(2500) -----> [1089, 2178]
(Palindromic numbers are like: 171, 454, 4224, these ones should be discarded)

Happy coding!!

(The sequence of these kind of numbers is registered in OEIS as A110819)
 */
public class CW10_NumbersAndItsReversalHavingSamePrimeFactors {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sameFactRev(1100))); // [1089]
        System.out.println(Arrays.toString(sameFactRev(2500))); // [1089, 2178]
    }

    public static int[] sameFactRev(int nMax) {

        List<Integer> result = new ArrayList<>();

        for (int i = 1089; i < nMax; i++) {
            if (!isPalindromic(i) && hasSamePrimeFactors(i)) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static boolean isPalindromic(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        return String.valueOf(n).contentEquals(sb.reverse());
    }

    private static boolean hasSamePrimeFactors(int n) {
        Set<Integer> set1 = primeFactorizationSet(n);
        Set<Integer> set2 = primeFactorizationSet(Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString()));
        return set1.equals(set2) && set1.size() > 1;
    }

    private static Set<Integer> primeFactorizationSet(int n) {
        Set<Integer> set = new HashSet<>();

        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }

        if (n > 1) {
            set.add(n);
        }

        return set;
    }
}

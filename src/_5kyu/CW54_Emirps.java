package _5kyu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
If you reverse the word "emirp" you will have the word "prime". That idea is related with the purpose of this kata:
we should select all the primes that when reversed are a different prime (so palindromic primes should be discarded).

For example: 13, 17 are prime numbers and the reversed respectively are 31, 71 which are also primes,
so 13 and 17 are "emirps". But primes 757, 787, 797 are palindromic primes, meaning that the reversed number is
the same as the original, so they are not considered as "emirps" and should be discarded.

The emirps sequence is registered in OEIS as A006567

Your task
Create a function that receives one argument n, as an upper limit, and the return the following array:

[number_of_emirps_below_n, largest_emirp_below_n, sum_of_emirps_below_n]

Examples
find_emirp(10)
[0, 0, 0] ''' no emirps below 10 '''
find_emirp(50)
[4, 37, 98] ''' there are 4 emirps below 50: 13, 17, 31, 37; largest = 37; sum = 98 '''
find_emirp(100)
[8, 97, 418] ''' there are 8 emirps below 100: 13, 17, 31, 37, 71, 73, 79, 97; largest = 97; sum = 418 '''
 */
public class CW54_Emirps {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEmirp(10))); // [0, 0, 0]
        System.out.println(Arrays.toString(findEmirp(50))); // [4, 37, 98]
        System.out.println(Arrays.toString(findEmirp(100))); // [8, 97, 418]
        System.out.println(Arrays.toString(findEmirp(200))); // [15, 199, 1489]
    }

    public static long[] findEmirp(long n) {

        Set<Long> primeNumbers = generatePrimesBelow((long) Math.pow(10, String.valueOf(n).length()));
        Set<Long> emirps = primeNumbers.stream()
                .filter(t -> t <= n && !isPalindromic(t) && primeNumbers.contains(reverseNumber(t)))
                .collect(Collectors.toSet());

        long max = 0;
        long sum = 0;

        for (Long l : emirps) {
            max = Math.max(max, l);
            sum += l;
        }

        return new long[]{emirps.size(), max, sum};
    }

    private static Set<Long> generatePrimesBelow(long limit) {
        Set<Long> primes = new HashSet<>();
        for (long i = 13; i < limit; i += 2) {
            if (isPrime(i)) primes.add(i);
        }
        return primes;
    }

    private static long reverseNumber(long num) {
        return Long.parseLong(new StringBuilder(String.valueOf(num)).reverse().toString());
    }

    private static boolean isPalindromic(long num) {
        StringBuilder numStr = new StringBuilder(String.valueOf(num));
        return numStr.reverse().toString().equals(String.valueOf(num));
    }

    private static boolean isPrime(long num) {

//        if (num < 2) return false;
//        if (num == 2 || num == 3) return true;
        if (num % 2 == 0) return false;

        for (long i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }

        return true;

        // chatGPT
//        if (num < 2) return false;
//        if (num == 2 || num == 3) return true;
//        if (num % 2 == 0 || num % 3 == 0) return false;
//        for (long i = 5; i * i <= num; i += 6) {
//            if (num % i == 0 || num % (i + 2) == 0) return false;
//        }
//        return true;
    }
}

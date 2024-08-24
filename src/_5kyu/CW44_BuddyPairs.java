package _5kyu;

/*
Buddy pairs
You know what divisors of a number are. The divisors of a positive integer n are said to be proper when you consider
only the divisors other than n itself. In the following description, divisors will mean proper divisors.
For example for 100 they are 1, 2, 4, 5, 10, 20, 25, and 50.

Let s(n) be the sum of these proper divisors of n. Call buddy two positive integers such that the sum of
the proper divisors of each number is one more than the other number:
(n, m) are a pair of buddy if s(m) = n + 1 and s(n) = m + 1

For example 48 & 75 is such a pair:
Divisors of 48 are: 1, 2, 3, 4, 6, 8, 12, 16, 24 --> sum: 76 = 75 + 1
Divisors of 75 are: 1, 3, 5, 15, 25 --> sum: 49 = 48 + 1

Task
Given two positive integers start and limit, the function buddy(start, limit) should return the first pair
(n m) of buddy pairs such that n (positive integer) is between start (inclusive) and limit (inclusive);
m can be greater than limit and has to be greater than n

If there is no buddy pair satisfying the conditions, then return "Nothing" or (for Go lang) nil or
(for Dart) null; (for Lua, Pascal, Perl, D) [-1, -1]; (for Erlang {-1, -1}).

Examples
(depending on the languages)
buddy(10, 50) returns [48, 75]
buddy(48, 50) returns [48, 75]
or
buddy(10, 50) returns "(48 75)"
buddy(48, 50) returns "(48 75)"
 */
public class CW44_BuddyPairs {
    public static void main(String[] args) {
        System.out.println(buddy(10, 50)); // (48 75)
        System.out.println(buddy(381, 4318)); // (1050 1925)
        System.out.println(buddy(1071625, 1103735)); // (1081184 1331967)
        System.out.println(buddy(2382, 3679)); // Nothing
        System.out.println(buddy(2177, 4357)); // Nothing
    }

    public static String buddy(long start, long limit) {
        for (long i = start; i <= limit; i++) {
            long a = sumOfDivisors(i);
            long b = sumOfDivisors(a - 1);
            if (i == b - 1 && a - 1 > start) return "(" + i + " " + (a - 1) + ")";
        }
        return "Nothing";
    }

    // divisors
    private static long sumOfDivisors(long num) {
        // way 1 - time out
//        long sum = 0;
//        for (long i = 1; i <= num / 2; i++) {
//            if (num % i == 0) {
//                sum += i;
//            }
//        }
//        return sum;

        // way 2 - chatGPT
        long sum = 1; // 1 is always a divisor, so we include it from the start
        long sqrt = (long) Math.sqrt(num);
        for (long i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return sum;
    }
}

package _5kyu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Consider the sequence a(1) = 7, a(n) = a(n-1) + gcd(n, a(n-1)) for n >= 2:
7, 8, 9, 10, 15, 18, 19, 20, 21, 22, 33, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 69, 72, 73....

Let us take the differences between successive elements of the sequence and get a second sequence
g: 1, 1, 1, 5, 3, 1, 1, 1, 1, 11, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 23, 3, 1....

For the sake of uniformity of the lengths of sequences we add a 1 at the head of g:
g: 1, 1, 1, 1, 5, 3, 1, 1, 1, 1, 11, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 23, 3, 1...

Removing the 1s gives a third sequence: p: 5, 3, 11, 3, 23, 3... where you can see prime numbers.

Task:
Write functions:
1: an(n) with parameter n: returns the first n terms of the series of a(n) (not tested)
2: gn(n) with parameter n: returns the first n terms of the series of g(n) (not tested)
3: countOnes(n) with parameter n: returns the number of 1 in the series gn(n)
    (don't forget to add a `1` at the head) # (tested)
4: p(n) with parameter n: returns an array filled with the n first distinct primes in the same order they are found in the sequence gn (not tested)
5: maxPn(n) with parameter n: returns the biggest prime number of the above p(n) # (tested)
6: anOver(n) with parameter n: returns an array (n terms) of the a(i)/i for every i such g(i) != 1 (not tested but interesting result)
7: anOverAverage(n) with parameter n: returns as an *integer* the average of anOver(n) # (tested)

Note:
You can write directly functions 3:, 5: and 7:. There is no need to write functions 1:, 2:, 4: 6: except out of pure curiosity.
 */
public class CW42_WeirdPrimeGenerator {
    public static void main(String[] args) {
        System.out.println(WeirdPrimeGen.countOnes(10)); // 8
        System.out.println(WeirdPrimeGen.countOnes(100)); // 90
        System.out.println(WeirdPrimeGen.maxPn(5)); // 47
        System.out.println(WeirdPrimeGen.maxPn(7)); // 101
        System.out.println(WeirdPrimeGen.anOverAverage(5)); // 3
    }
}

class WeirdPrimeGen {
    static List<Long> a = new ArrayList<>(List.of(7L));
    static List<Long> g = new ArrayList<>(List.of(1L));
    static List<Long> p;
    static List<Long> anOver;

    public static long countOnes(long n) {
        populateAG(n);
        return g.subList(0, Math.toIntExact(n)).stream().filter(t -> t == 1).count();
    }

    public static long maxPn(long n) {
        populateP(n);
        return p.subList(0, Math.toIntExact(n)).stream().max(Long::compareTo).orElse(0L);
    }

    public static int anOverAverage(long n) {
        populateAnOver(n);
        return (int) anOver.subList(0, Math.toIntExact(n)).stream().mapToLong(Long::longValue).average().orElse(0);
    }

    private static List<Long> an(long n) {
        populateAG(n);
        return a.subList(0, Math.toIntExact(n));
    }

    private static List<Long> gn(long n) {
        populateAG(n);
        return g.subList(0, Math.toIntExact(n));
    }

    private static void populateAG(long n) {
        for (int i = a.size(); i < n; i++) {
            a.add(a.get(i - 1) + gcd(i + 1, a.get(i - 1)));
            g.add(a.get(i) - a.get(i - 1));
        }
    }

    private static void populateP(long n) {
        if (p == null) {
            p = new ArrayList<>();
            Set<Long> seen = new HashSet<>();
            for (Long value : g) {
                if (value != 1 && seen.add(value)) {
                    p.add(value);
                }
            }
        }

        int i = a.size();
        while (p.size() < n) {
            a.add(a.get(i - 1) + gcd(i + 1, a.get(i - 1)));
            g.add(a.get(i) - a.get(i - 1));
            if (g.get(i) != 1 && !p.contains(g.get(i))) {
                p.add(g.get(i));
            }
            i++;
        }
    }

    private static void populateAnOver(long n) {
        if (anOver == null) {
            anOver = new ArrayList<>();
            for (int i = 0; i < g.size(); i++) {
                if (g.get(i) != 1) {
                    anOver.add(a.get(i) / (i + 1));
                }
            }
        }

        int i = a.size();
        while (anOver.size() < n) {
            a.add(a.get(i - 1) + gcd(n, a.get(i - 1)));
            g.add(a.get(i) - a.get(i - 1));
            if (g.get(i) != 1) {
                anOver.add(a.get(i) / (i + 1));
            }
            i++;
        }
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

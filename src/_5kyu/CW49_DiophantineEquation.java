package _5kyu;

import java.util.ArrayList;
import java.util.List;

/*
In mathematics, a Diophantine equation is a polynomial equation, usually with two or more unknowns,
such that only the integer solutions are sought or studied.

In this kata we want to find all integers x, y (x >= 0, y >= 0) solutions of a diophantine equation of the form:
x2 - 4 * y2 = n

(where the unknowns are x and y, and n is a given positive number) in decreasing order of the positive xi.

If there is no solution return [] or "[]" or "". (See "RUN SAMPLE TESTS" for examples of returns).

Examples:
solEquaStr(90005) --> "[[45003, 22501], [9003, 4499], [981, 467], [309, 37]]"
solEquaStr(90002) --> "[]"

Hint:
x2 - 4 * y2 = (x - 2*y) * (x + 2*y)
 */
public class CW49_DiophantineEquation {
    public static void main(String[] args) {
        System.out.println(solEquaStr(90005)); // [[45003, 22501], [9003, 4499], [981, 467], [309, 37]]
        System.out.println(solEquaStr(90002)); // []
        System.out.println(solEquaStr(5)); // [[3, 1]]
        System.out.println(solEquaStr(12)); // [[4, 1]]
        System.out.println(solEquaStr(13)); // [[7, 3]]
        System.out.println(solEquaStr(16)); // [[4, 0]]
    }

    public static String solEquaStr(long n) {

        // way 1 - slow
//        List<String> list = new ArrayList<>();
//
//        for (long i = n; i > 0; i--) {
//            if (n % i != 0) continue;
//            double a = Math.sqrt((double) (n - i * i) / -4);
//            if (a == (int) a)
//                list.add("[" + i + ", " + (int) a + "]");
//        }
//
//        return list.toString();

        // way 2 - fast
        List<String> solutions = new ArrayList<>();

        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                long j = n / i;

                // x = (i + j) / 2
                // y = (j - i) / 4
                if ((i + j) % 2 == 0 && (j - i) % 4 == 0) {
                    long x = (i + j) / 2;
                    long y = (j - i) / 4;
                    solutions.add("[" + x + ", " + y + "]");
                }
            }
        }

        return solutions.toString();
    }
}

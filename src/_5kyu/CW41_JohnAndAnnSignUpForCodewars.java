package _5kyu;

import java.util.ArrayList;
import java.util.List;

/*
John and his wife Ann have decided to go to Codewars. On the first day
Ann will do one kata and John - he wants to know how it is working - 0 kata.

Let us call a(n) - and j(n) - the number of katas done by Ann - and John - at day n.
We have a(0) = 1 and in the same manner j(0) = 0.

They have chosen the following rules:
 - On day n the number of katas done by Ann should be n minus the number of katas done by John at day t,
   t being equal to the number of katas done by Ann herself at day n - 1
 - On day n the number of katas done by John should be n minus the number of katas done by Ann at day t,
   t being equal to the number of katas done by John himself at day n - 1

Whoops! I think they need to lay out a little clearer exactly what there're getting themselves into!

Could you write:
functions ann(n) and john(n) that return the list of the number of katas Ann/John does on the first n days;
functions sum_ann(n) and sum_john(n) that return the total number of katas done by Ann/John on the first n days

Examples:
john(11)  -->  [0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 6]
ann(6)    -->  [1, 1, 2, 2, 3, 3]
sum_john(75)  -->  1720
sum_ann(150)  -->  6930

Note:
Keep an eye on performance.
 */
public class CW41_JohnAndAnnSignUpForCodewars {
    public static void main(String[] args) {
        System.out.println(Johnann.john(11)); // [0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 6]
        System.out.println(Johnann.ann(6)); // [1, 1, 2, 2, 3, 3]
        System.out.println(Johnann.sumJohn(75)); // 1720
        System.out.println(Johnann.sumAnn(150)); // 6930
    }
}

class Johnann {
    /*
        j(n) = n - a(j(n-1))
        a(n) = n - j(a(n-1))
     */
    static List<Long> john = new ArrayList<>(List.of(0L));
    static List<Long> ann = new ArrayList<>(List.of(1L));

    public static List<Long> john(long n) {
        populateLists(n);
        return john.subList(0, Math.toIntExact(n));
    }

    public static List<Long> ann(long n) {
        populateLists(n);
        return ann.subList(0, Math.toIntExact(n));
    }

    public static long sumJohn(long n) {
        populateLists(n);
        return john.subList(0, Math.toIntExact(n)).stream().reduce(0L, Long::sum);
    }

    public static long sumAnn(long n) {
        populateLists(n);
        return ann.subList(0, Math.toIntExact(n)).stream().reduce(0L, Long::sum);
    }

    private static void populateLists(long n) {
        if (n > john.size()) {
            for (long i = john.size(); i < n; i++) {
                john.add(i - ann.get(Math.toIntExact(john.get((int) i - 1))));
                ann.add(i - john.get(Math.toIntExact(ann.get((int) i - 1))));
            }
        }
    }
}

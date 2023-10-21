package _6kyu;

import static java.util.Arrays.stream;

/*
Given an array of integers, find the one that appears an odd number of times.
There will always be only one integer that appears an odd number of times.

Examples
[7] should return 7, because it occurs 1 time (which is odd).
[0] should return 0, because it occurs 1 time (which is odd).
[1,1,2] should return 2, because it occurs 1 time (which is odd).
[0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
[1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
 */
public class CW02_FindTheOddInt {
    public static void main(String[] args) {
        System.out.println(findIt(new int[]{5, 5, 1, 2, -1, -2, 5}));
    }

    public static int findIt(int[] a) {
        int occurs = 0;
        for (int j : a) {
            for (int k : a) {
                if (j == k) occurs++;
            }
            if (occurs % 2 != 0) return j;
            occurs = 0;
        }
        return 0;

        // idubrov, Jack888, liurongr, Jannik0708, IrynaDim, LydiAlvarez, 500kg, Sasha777, Anton7551, ongfr (+ 2)
//        return stream(a).reduce(0, (x, y) -> x ^ y);
    }
}

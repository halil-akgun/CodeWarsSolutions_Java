package _6kyu;

import java.util.Arrays;

/*
There is an array with some numbers. All numbers are equal except for one. Try to find it!

Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
It’s guaranteed that array contains at least 3 numbers.

The tests contain some very huge arrays, so think about performance.
 */
public class CW16_FindTheUniqueNumber {
    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0}));
    }

    public static double findUniq(double[] arr) {
        double repeatedNum = arr[0] == arr[1] ? arr[0] : arr[1] == arr[2] ? arr[1] : arr[0];
        for (double v : arr) {
            if (v != repeatedNum) return v;
        }
        return 0;

        // Kiliosvita, Dadaji, JaGUaRsPork, Gerakles, Bogoslav, user8730369, ElBoina, hrhuynguyen, amit verma (+ 22):
//        Arrays.sort(arr);
//        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
    }
}

package _6kyu;

import java.util.Arrays;
import java.util.stream.LongStream;

/*
Given a triangle of consecutive odd numbers:

             1
          3     5
       7     9    11
   13    15    17    19
21    23    25    27    29
...
find the triangle's row knowing its index (the rows are 1-indexed), e.g.:

odd_row(1)  ==  [1]
odd_row(2)  ==  [3, 5]
odd_row(3)  ==  [7, 9, 11]
Note: your code should be optimized to handle big inputs.
 */
public class CW43_RowOfTheOddTriangle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(oddRow(1)));
        System.out.println(Arrays.toString(oddRow(2)));
        System.out.println(Arrays.toString(oddRow(3)));
    }

    public static long[] oddRow(int n) {

        // way 1
        int num = 1;
        long[] result = new long[n];
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < row + 1; i++) {
                if (row + 1 == n) result[i] = num;
                num += 2;
            }
        }
        return result;

        // way 2
//        return LongStream.iterate(((long) n * n) - (n - 1), t -> t + 2).limit(n).toArray();
    }
}

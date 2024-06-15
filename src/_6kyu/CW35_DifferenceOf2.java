package _6kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
The objective is to return all pairs of integers from a given array of integers that have a difference of 2.

The result array should be sorted in ascending order of values.

Assume there are no duplicate integers in the array. The order of the integers in the input array should not matter.

Examples
[1, 2, 3, 4]  should return [[1, 3], [2, 4]]
[4, 1, 2, 3]  should also return [[1, 3], [2, 4]]
[1, 23, 3, 4, 7] should return [[1, 3]]
[4, 3, 1, 5, 6] should return [[1, 3], [3, 5], [4, 6]]
 */
public class CW35_DifferenceOf2 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(twosDifference(new int[]{1, 2, 3, 4})));
    }

    public static int[][] twosDifference(int[] array) {

        Arrays.sort(array);

        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {

                if (Math.abs(array[i] - array[j]) == 2) {
                    pairs.add(new int[]{array[i], array[j]});
                }
            }
        }

        int[][] result = new int[pairs.size()][2];
        for (int i = 0; i < pairs.size(); i++) {
            result[i] = pairs.get(i);
        }

        return result;
    }
}

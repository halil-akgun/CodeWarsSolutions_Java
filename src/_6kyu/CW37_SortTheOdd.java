package _6kyu;

import java.util.Arrays;

/*
You will be given an array of numbers. You have to sort the odd numbers in ascending order
while leaving the even numbers at their original positions.

Examples
[7, 1]  =>  [1, 7]
[5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */
public class CW37_SortTheOdd {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }

    public static int[] sortArray(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % 2 == 0) continue;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] % 2 == 0) continue;
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

/*  dinglemouse, joaquinsanroman, Cindy Ma, bkoltun33, ethanwlx, hlibbocharov, engocs@gmail.com, Phlycome, dobrin2003, empalor (+ 12):

        // Sort the odd numbers only
        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();

        // Then merge them back into original array
        for (int j = 0, s = 0; j < array.length; j++) {
            if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
        }
*/

        return array;
    }
}

package _5kyu;

import java.util.Arrays;

/*
Input
 - a string strng of n positive numbers (n = 0 or n >= 2)
Let us call weight of a number the sum of its digits. For example 99 will have "weight" 18, 100 will have "weight" 1.

Two numbers are "close" if the difference of their weights is small.

Task:
For each number in strng calculate its "weight" and then find two numbers of strng that have:
 - the smallest difference of weights ie that are the closest
 - with the smallest weights
 - and with the smallest indices (or ranks, numbered from 0) in strng

Output:
 - an array of two arrays, each subarray in the following format:
[number-weight, index in strng of the corresponding number, original corresponding number in strng]

or a pair of two subarrays (Haskell, Clojure, FSharp) or an array of tuples (Elixir, C++)
or a (char*) in C or a string in some other languages mimicking an array of two subarrays or a string
or a matrix in R (2 rows, 3 columns, no columns names)

The two subarrays are sorted in ascending order by their number weights if these weights are different,
by their indexes in the string if they have the same weights.

Examples:
Let us call that function closest

strng = "103 123 4444 99 2000"
the weights are 4, 6, 16, 18, 2 (ie 2, 4, 6, 16, 18)

closest should return [[2, 4, 2000], [4, 0, 103]] (or ([2, 4, 2000], [4, 0, 103])
or [{2, 4, 2000}, {4, 0, 103}] or ... depending on the language)
because 2000 and 103 have for weight 2 and 4, their indexes in strng are 4 and 0.
The smallest difference is 2.
4 (for 103) and 6 (for 123) have a difference of 2 too but they are not
the smallest ones with a difference of 2 between their weights.
....................

strng = "80 71 62 53"
All the weights are 8.
closest should return [[8, 0, 80], [8, 1, 71]]
71 and 62 have also:
- the smallest weights (which is 8 for all)
- the smallest difference of weights (which is 0 for all pairs)
- but not the smallest indices in strng.
....................

strng = "444 2000 445 544"
the weights are 12, 2, 13, 13 (ie 2, 12, 13, 13)

closest should return [[13, 2, 445], [13, 3, 544]] or ([13, 2, 445], [13, 3, 544])
or [{13, 2, 445}, {13, 3, 544}] or ...
444 and 2000 have the smallest weights (12 and 2) but not the smallest difference of weights;
they are not the closest.
Here the smallest difference is 0 and in the result the indexes are in ascending order.
...................

closest("444 2000 445 644 2001 1002") --> [[3, 4, 2001], [3, 5, 1002]] or ([3, 4, 2001],
[3, 5, 1002]]) or [{3, 4, 2001}, {3, 5, 1002}] or ...
Here the smallest difference is 0 and in the result the indexes are in ascending order.
...................

closest("239382 162 254765 182 485944 468751 49780 108 54")
The weights are: 27, 9, 29, 11, 34, 31, 28, 9, 9.
closest should return  [[9, 1, 162], [9, 7, 108]] or ([9, 1, 162], [9, 7, 108])
or [{9, 1, 162}, {9, 7, 108}] or ...
108 and 54 have the smallest difference of weights too, they also have
the smallest weights but they don't have the smallest ranks in the original string.
..................

closest("54 239382 162 254765 182 485944 468751 49780 108")
closest should return  [[9, 0, 54], [9, 2, 162]] or ([9, 0, 54], [9, 2, 162])
or [{9, 0, 54}, {9, 2, 162}] or ...

Notes :
If n == 0 closest("") should return []
 - or ([], []) in Haskell, Clojure, FSharp
 - or [{}, {}] in Elixir or '(() ()) in Racket
 - or {{0,0,0}, {0,0,0}} in C++
 - or "[(), ()]" in Go, Nim,
 - or "{{0,0,0}, {0,0,0}}" in C, NULL in R
 - or "" in Perl.
 */
public class CW32_ClosestAndSmallest {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(closest(""))); // []
        System.out.println(Arrays.deepToString(closest("80 71 62 53"))); // [[8, 0, 80], [8, 1, 71]]
        System.out.println(Arrays.deepToString(closest("444 2000 445 544"))); // [[13, 2, 445], [13, 3, 544]]
        System.out.println(Arrays.deepToString(closest("103 123 4444 99 2000"))); // [[2, 4, 2000], [4, 0, 103]]
        System.out.println(Arrays.deepToString(closest("462835 148 467467 128 183193 139 220167 116 263183 41 52"))); // [13, 1, 148], [13, 5, 139]
    }

    public static int[][] closest(String strng) {

        if (strng.isEmpty()) return new int[0][0];

        String[] numStrings = strng.split(" ");
        int[][] weightedNumbers = new int[numStrings.length][3];

        for (int i = 0; i < numStrings.length; i++) {
            weightedNumbers[i][0] = calculateWeight(numStrings[i]);
            weightedNumbers[i][1] = i;
            weightedNumbers[i][2] = Integer.parseInt(numStrings[i]);
        }

        for (int i = 0; i < weightedNumbers.length - 1; i++) {
            for (int j = i + 1; j < weightedNumbers.length; j++) {
                if ((weightedNumbers[j][0] < weightedNumbers[i][0])
                        || (weightedNumbers[j][0] == weightedNumbers[i][0] && weightedNumbers[j][1] < weightedNumbers[i][1])) {
                    swap(weightedNumbers, i, j);
                }
            }
        }

        int minDifference = Integer.MAX_VALUE;
        int[][] closestPair = new int[2][3];

        for (int i = 1; i < weightedNumbers.length; i++) {
            int diff = Math.abs(weightedNumbers[i - 1][0] - weightedNumbers[i][0]);
            if (diff < minDifference) {
                minDifference = diff;
                closestPair[0] = weightedNumbers[i - 1];
                closestPair[1] = weightedNumbers[i];
            }
        }

        return closestPair;
    }

    private static int calculateWeight(String num) {
        return Arrays.stream(num.split("")).mapToInt(Integer::parseInt).sum();
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

package _5kyu;

import java.util.Arrays;

/*
Input
Range is 0-999
There may be duplicates
The array may be empty

Example
Input: 1, 2, 3, 4
Equivalent names: "one", "two", "three", "four"
Sorted by name: "four", "one", "three", "two"
Output: 4, 1, 3, 2

Notes
Don't pack words together:
e.g. 99 may be "ninety nine" or "ninety-nine"; but not "ninetynine"
e.g 101 may be "one hundred one" or "one hundred and one"; but not "onehundredone"
Don't fret about formatting rules, because if rules are consistently applied it has no effect anyway:
e.g. "one hundred one", "one hundred two"; is same order as "one hundred and one", "one hundred and two"
e.g. "ninety eight", "ninety nine"; is same order as "ninety-eight", "ninety-nine"
 */
public class CW50_Sort_OneThreeTwo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 2, 3, 4}))); // [4, 1, 3, 2]
        System.out.println(Arrays.toString(sort(new int[]{8, 8, 9, 9, 10, 10}))); // [8, 8, 9, 9, 10, 10]
        System.out.println(Arrays.toString(sort(new int[]{9, 999, 99, 304}))); // [9, 999, 99]
    }

    public static int[] sort(final int[] array) {
        String[] numberWords = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            numberWords[i] = a(array[i]);
            for (int j = i - 1; j >= 0; j--) {
                if (numberWords[j + 1].compareTo(numberWords[j]) < 0) {
                    String tempWord = numberWords[j + 1];
                    int tempNumber = array[j + 1];
                    numberWords[j + 1] = numberWords[j];
                    array[j + 1] = array[j];
                    numberWords[j] = tempWord;
                    array[j] = tempNumber;
                }
            }
        }
        return array;
    }

    static String[] zeroToNineteen = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] tens = new String[]{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static String a(int number) {
        if (number < 20) {
            return zeroToNineteen[number];
        }

        if (number < 100) {
            return number % 10 == 0
                    ? tens[number / 10 - 2]
                    : tens[number / 10 - 2] + " " + zeroToNineteen[number % 10];
        }

        int hundreds = number / 100;
        int remainder = number % 100;

        String hundredPart = zeroToNineteen[hundreds] + " hundred";

        if (remainder == 0) {
            return hundredPart;
        }

        String remainderPart = remainder < 20
                ? zeroToNineteen[remainder]
                : tens[remainder / 10 - 2] + (remainder % 10 == 0 ? "" : " " + zeroToNineteen[remainder % 10]);

        return hundredPart + " " + remainderPart;
    }
}

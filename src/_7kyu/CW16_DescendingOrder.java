package _7kyu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Your task is to make a function that can take any non-negative integer as an argument and return it with
its digits in descending order. Essentially, rearrange the digits to create the highest possible number.

Examples:
Input: 42145 Output: 54421
Input: 145263 Output: 654321
Input: 123456789 Output: 987654321
 */
public class CW16_DescendingOrder {
    public static void main(String[] args) {
        System.out.println(sortDesc(56874643));
    }

    public static int sortDesc(final int num) {
        List<String> numList = Arrays.asList(String.valueOf(num).split(""));
        Collections.sort(numList);
        Collections.reverse(numList);
        return Integer.parseInt(String.join("", numList));
    }
}

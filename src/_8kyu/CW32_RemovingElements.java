package _8kyu;

import java.util.Arrays;

/*
Take an array and remove every second element from the array. Always keep the first element and
start removing with the next element.

Example:
["Keep", "Remove", "Keep", "Remove", "Keep", ...] --> ["Keep", "Keep", "Keep", ...]

None of the arrays will be empty, so you don't have to worry about that!
 */
public class CW32_RemovingElements {
    public static void main(String[] args) {
        Object[] arr = {"Keep", "Remove", "Keep", "Remove", "Keep"};
        System.out.println(Arrays.toString(removeEveryOther(arr)));
    }

    public static Object[] removeEveryOther(Object[] arr) {
        int length = arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1;
        Object[] result = new Object[length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }
}

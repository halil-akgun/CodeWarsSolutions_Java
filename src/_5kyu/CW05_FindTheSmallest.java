package _5kyu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
You have a positive number n consisting of digits. You can do at most one operation:
Choosing the index of a digit in the number, remove this digit at that index and insert it
back to another or at the same place in the number in order to find the smallest number you can get.

Task:
Return an array or a tuple or a string depending on the language (see "Sample Tests") with

 - the smallest number you got
 - the index i of the digit d you took, i as small as possible
 - the index j (as small as possible) where you insert this digit d to have the smallest number.

Examples:
smallest(261235) --> [126235, 2, 0] or (126235, 2, 0) or "126235, 2, 0"
126235 is the smallest number gotten by taking 1 at index 2 and putting it at index 0

smallest(209917) --> [29917, 0, 1] or ...

[29917, 1, 0] could be a solution too but index `i` in [29917, 1, 0] is greater than
index `i` in [29917, 0, 1].
29917 is the smallest number gotten by taking 2 at index 0 and putting it at index 1 which gave 029917 which is the number 29917.

smallest(1000000) --> [1, 0, 6] or ...

Note
Have a look at "Sample Tests" to see the input and output in each language
 */
public class CW05_FindTheSmallest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallest(261235))); // [126235, 2, 0]
        System.out.println(Arrays.toString(smallest(209917))); // [29917, 0, 1]
        System.out.println(Arrays.toString(smallest(1000000))); // [1, 0, 6]
    }

    public static long[] smallest(long n) {

        // way 1 (not accepted)
//        String number = String.valueOf(n);
//        Map<Long, int[]> map = new HashMap<>();
//
//        for (int i = 0; i < number.length(); i++) {
//            for (int j = 0; j < number.length(); j++) {
//                StringBuilder temp = new StringBuilder(number);
//                temp.replace(i, i + 1, number.charAt(j) + "");
//                temp.replace(j, j + 1, number.charAt(i) + "");
//
//                long num = Long.parseLong(temp.toString());
//                if (num > 0) {
//                    if (number.charAt(i) < number.charAt(j)) {
//                        map.put(num, new int[]{i, j});
//                    } else {
//                        map.put(num, new int[]{j, i});
//                    }
//                }
//            }
//        }
//
//        TreeMap<Long, int[]> treeMap = new TreeMap<>(map);
//
//        Map.Entry<Long, int[]> entry = treeMap.firstEntry();
//
//        return new long[]{entry.getKey(), entry.getValue()[0], entry.getValue()[1]};


        // way 2
        String number = String.valueOf(n);
        long smallestNumber = n;
        int fromIdx = 0;
        int toIdx = 0;

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            String remaining = number.substring(0, i) + number.substring(i + 1);

            for (int j = 0; j < number.length(); j++) {
                String newNumberStr = remaining.substring(0, j) + digit + remaining.substring(j);
                long newNumber = Long.parseLong(newNumberStr);
                if (newNumber < smallestNumber) {
                    smallestNumber = newNumber;
                    fromIdx = i;
                    toIdx = j;
                }
            }
        }

        return new long[]{smallestNumber, fromIdx, toIdx};
    }
}

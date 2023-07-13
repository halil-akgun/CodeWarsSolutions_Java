package _7kyu;

import java.util.List;

/*
Given an array of ones and zeroes, convert the equivalent binary value to an integer.

Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.

Examples:
Testing: [0, 0, 0, 1] ==> 1
Testing: [0, 0, 1, 0] ==> 2
Testing: [0, 1, 0, 1] ==> 5
Testing: [1, 0, 0, 1] ==> 9
Testing: [0, 0, 1, 0] ==> 2
Testing: [0, 1, 1, 0] ==> 6
Testing: [1, 1, 1, 1] ==> 15
Testing: [1, 0, 1, 1] ==> 11
However, the arrays can have varying lengths, not just limited to 4.
 */
public class CW09_OnesAndZeros {
    public static void main(String[] args) {
        System.out.println(ConvertBinaryArrayToInt(List.of(1, 0, 1, 1)));
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {

//        method 1
//        int ans = 0;
//        int digit = 0;
//        for (int i = binary.size() - 1; i >= 0; i--) {
//            ans += binary.get(i) * Math.pow(2, digit++);
//        }
//        return ans;


//        method 2
        String binaryStr = binary.toString();
        binaryStr = binaryStr.substring(1, binaryStr.length() - 1).replaceAll(", ", "");

        return Integer.parseInt(binaryStr, 2);
    }
}

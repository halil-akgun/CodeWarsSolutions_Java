package _7kyu;

import java.util.Arrays;

/*
In this little assignment, you are given a string of space separated numbers, and have to return the highest and lowest number.

Examples
highAndLow("1 2 3 4 5")  // return "5 1"
highAndLow("1 2 -3 4 5") // return "5 -3"
highAndLow("1 9 3 4 -5") // return "9 -5"

Notes
All numbers are valid Int32, no need to validate them.
There will always be at least one number in the input string.
The Output string must be two numbers separated by a single space, and the highest number is first.
 */
public class CW15_HighestAndLowest {
    public static void main(String[] args) {
        System.out.println(highAndLow("5 9 6 7 -2 2 8 0 4 1"));
    }

    public static String highAndLow(String numbers) {
        Object[] arr = Arrays.stream(numbers.split(" ")).map(Integer::parseInt).sorted().toArray();
        return arr[arr.length - 1] + " " + arr[0];

        /*  ParanoidUser, raka0007, animeshp, Darkness101110, phrancisp0, robitsss, ラップランド, i22s0999:
        var stats = stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        return stats.getMax() + " " + stats.getMin();
         */
    }
}

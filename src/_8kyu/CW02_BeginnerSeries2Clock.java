package _8kyu;

import java.util.Scanner;

/*
Beginner Series #2 Clock
Clock shows h hours, m minutes and s seconds after midnight.
Your task is to write a function which returns the time since midnight in milliseconds.

Example:
h = 0
m = 1
s = 1
result = 61000

Input constraints:
0 <= h <= 23
0 <= m <= 59
0 <= s <= 59
 */
public class CW02_BeginnerSeries2Clock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("hour: ");
        int h = scan.nextInt();
        System.out.print("minute: ");
        int m = scan.nextInt();
        System.out.print("second: ");
        int s = scan.nextInt();

        System.out.println("Passed Time = " + Past(h, m, s));

    }

    public static int Past(int h, int m, int s) {
        int passedTime = 0;
        passedTime += h * 60 * 60 * 1000;
        passedTime += m * 60 * 1000;
        passedTime += s * 1000;
        return passedTime;
    }
}

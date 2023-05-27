/*
Very simple, given an integer or a floating-point number, find its opposite.

Examples:
1: -1
14: -14
-34: 34
 */
public class CW48_OppositeNumber {
    public static void main(String[] args) {
        System.out.println(opposite(3));
    }

    public static int opposite(int number) {
        return number * -1;
    }
}

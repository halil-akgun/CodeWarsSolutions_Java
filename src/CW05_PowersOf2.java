import java.util.Arrays;
import java.util.Scanner;

/*
Complete the function that takes a non-negative integer n as input, and returns a list of all the powers of 2 with
the exponent ranging from 0 to n ( inclusive ).

Examples
n = 0  ==> [1]        # [2^0]
n = 1  ==> [1, 2]     # [2^0, 2^1]
n = 2  ==> [1, 2, 4]  # [2^0, 2^1, 2^2]
 */
public class CW05_PowersOf2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        System.out.println("powersOfTwo(" + n + ") =\n" + Arrays.toString(powersOfTwo(n)));
    }

    public static long[] powersOfTwo(int n) {
        long arr[] = new long[n + 1];
        long a = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                a *= 2;
            }
            arr[i] = a;
            a = 1;
        }
        return arr;
    }
}
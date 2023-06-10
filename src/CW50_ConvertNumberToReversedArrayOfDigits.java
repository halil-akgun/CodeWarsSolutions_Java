import java.util.Arrays;

/*
Given a random non-negative number, you have to return the digits of this number within an array in reverse order.

Example(Input => Output):
35231 => [1,3,2,5,3]
0 => [0]
 */
public class CW50_ConvertNumberToReversedArrayOfDigits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(digitize(35231)));
    }

    public static int[] digitize(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int[] result = new int[sb.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(sb.substring(sb.length() - 1));
            sb.delete(sb.length() - 1, sb.length());
        }
        return result;
    }
}

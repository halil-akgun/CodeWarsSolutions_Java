package _8kyu;

/*
Your task is to find the nearest square number, nearest_sq(n) or nearestSq(n), of a positive integer n.

For example, if n = 111, then nearest\_sq(n) (nearestSq(n)) equals 121, since 111 is closer to 121,
the square of 11, than 100, the square of 10.

If the n is already the perfect square (e.g. n = 144, n = 81, etc.), you need to just return n.
 */
public class CW10_FindNearestSquareNumber {
    public static void main(String[] args) {
        System.out.println(nearestSq(81));
    }

    public static int nearestSq(final int n) {
        int option1 = (int) Math.sqrt(n);
        int option2 = option1 + 1;
        double b = Math.sqrt(n);
        int result;
        if ((double) option1 == b) return option1 * option1;
        else {
            result = option1;
            if ((option2 * option2) - n < n - (option1 * option1)) result = option2;
        }
        return result * result;
    }
}

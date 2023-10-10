package _7kyu;

/*
You might know some pretty large perfect squares. But what about the NEXT one?

Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter.
Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.

If the parameter is itself not a perfect square then -1 should be returned. You may assume the parameter is non-negative.

Examples:(Input --> Output)

121 --> 144
625 --> 676
114 --> -1 since 114 is not a perfect square
 */
public class CW24_FindTheNextPerfectSquare {
    public static void main(String[] args) {
        System.out.println(findNextSquare(625));
    }

    public static long findNextSquare(long sq) {
        double a = Math.sqrt(sq);
        return a == (int) a ? (long) ((a + 1) * (a + 1)) : -1;

        // Pobepto, Maarten_, ThereIsNoCowLevel, ChungGor, aopelts, Stringer, kwiniarski97, hollannikas, Mark-McCracken, dawidRymz (+ 27)
//        return Math.sqrt(sq) % 1 != 0 ? -1 : (long)Math.pow(Math.sqrt(sq)+1,2);
    }
}

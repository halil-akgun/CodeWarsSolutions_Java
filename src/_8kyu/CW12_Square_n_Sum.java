package _8kyu;

/*
Complete the square sum function so that it squares each number passed into it and then sums the results together.

For example, for [1, 2, 2] it should return 9 because 1^2 + 2^2+ 2^2 = 9.
 */
public class CW12_Square_n_Sum {
    public static void main(String[] args) {
        System.out.println(squareSum(new int[]{1, 2, 2}));
    }

    // codewars didn't accept ???
//    public static int squareSum(int[] n) {
//        List<Integer> list = Arrays.stream(n).boxed().toList();
//        return list.stream().map(t -> t * t).reduce(Integer::sum).get();
//    }
    public static int squareSum(int[] n) {
        int sum = 0;
        for (int w : n) {
            sum += w * w;
        }
        return sum;
    }
}

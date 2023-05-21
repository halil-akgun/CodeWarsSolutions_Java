import java.util.Arrays;

/*
Write a function which calculates the average of the numbers in a given list.

Note: Empty arrays should return 0.
 */
public class CW45_CalculateAverage {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 9, 1, 2, 4, 11};
        System.out.println(find_average(arr));
    }

    public static double find_average(int[] array) {
        return Arrays.stream(array).average().orElse(0);
//        return Arrays.stream(array).average().getAsDouble();
    }
}

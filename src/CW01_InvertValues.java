import java.util.Arrays;

public class CW01_InvertValues {
    public static void main(String[] args) {
        /*..
        invert([1,2,3,4,5]) == [-1,-2,-3,-4,-5]
        invert([1,-2,3,-4,5]) == [-1,2,-3,4,-5]
        invert([]) == []
        */
        int brr[] = {3, 5, 7, -1, -8};
        System.out.println("brr = " + Arrays.toString(brr));
        System.out.println("invert(brr) = " + Arrays.toString(invert(brr)));
    }

    public static int[] invert(int[] array) {
        int arr[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i] * -1;
        }
        return arr;
    }
}

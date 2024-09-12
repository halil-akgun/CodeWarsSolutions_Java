package _5kyu;

/*
The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
// should be 6: {4, -1, 2, 1}

Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
If the list is made up of only negative numbers, return 0 instead.

Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */
public class CW61_MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
    }

    public static int sequence(int[] arr) {
        int max = 0, currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                max = Math.max(max, currentSum);
            }
            currentSum = 0;
        }

        return max;


        // chatGPT:
//        int maxSum = 0;
//        int currentSum = 0;
//
//        for (int num : arr) {
//            currentSum = Math.max(num, currentSum + num);
//            maxSum = Math.max(maxSum, currentSum);
//        }
//
//        return maxSum;
    }
}

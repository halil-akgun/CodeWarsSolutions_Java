package extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
Given an array of integers, transform it so that at least a certain number of elements in the array are equal.
To achieve this, you can perform an operation where you select an element in the array and
divide it by the given division parameter using integer division.
What is the minimum number of operations that must be performed to achieve this goal on a certain array?
For example, let's say arr =[1‚ 2, 3, 4, 5].
The desired number of equal elements is denoted as threshold = 3, and the division parameter is d= 2.
If you divide the value 4 once and the value 5 once using integer division, you get the array [1, 2, 3, 2, 2],
which contains 3 equal elements. There is no way to achieve this in less than 2 operations. Therefore, the answer is 2.

Function Description
Complete the function minOperations in the editor below.

minOperations has the following parameter(s):
int arr[n]: an array of integers
int threshold: the minimum number of desired equal elements in the array
int d: the division parameter used to divide an element in a single operation


Returns:
int: the minimum number ofoperations required to have at least thresho/d number of equal elements in the array

Contraints
1 <= n <= 30000
1 <= arr[i] <= 200000
1 <= thresholds <= n
2 <= d <= 1000

Input Format For Custom Testing
The first line contains an integer, n, denoting the size of the array.
Each line i of the n subsequent lines (where 0 <= i <= n) contains an integer that describes arr[i].
The next line contains an integer, threshold, denoting the minimum number of desired elements in the array.
The next line contains an integer, d, denoting the division parameter.

Sample Case
sample Input For Custom Testing :
[4, 1, 2, 3, 4, 4, 3]
Sample Output : 6
Explanation:
In this case,  the arr = [1, 2, 3, 4], threshold = 4, and the division parameter d = 3.
In other words, the minimum required number of equal elements is 4, and in one operation
we can divide a single element by 3 using integer division.
The only way to get all 4 elements to be equal is to divide all of them so they all become 0.
One operation is required to conver 1 to 0, and another single opeartion is required to convert 2 to 0.
Two operations are required to convert 3 to 0, and another two operations are needed to convert 4 to 0.
Therefore, the total number of required operations is 1+1+2+2=6.
 */
public class MinimumOperationsToEqualize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int threshold = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(solution(arr, threshold, d));
    }

    private static int solution(int[] arr, int threshold, int d) {

        // Create a map to store the number of operations needed for each value
        Map<Integer, List<Integer>> operationsMap = new HashMap<>();

        // Iterate through each number in the array
        for (int num : arr) {
            int current = num; // Start with the current number
            int ops = 0; // Initialize operation count

            // Continue until the current number is less than 0
            while (current >= 0) {
                // If the current value is not in the map, add it
                operationsMap.putIfAbsent(current, new ArrayList<>());
                // Add the number of operations needed to reach this value
                operationsMap.get(current).add(ops);

                // If the current value is 0, break the loop
                if (current == 0) break;

                // Update the current value by dividing it by d
                current = current / d;
                // Increment the operation count
                ops++;
            }
        }

        int minOps = Integer.MAX_VALUE;

        // Check if there are enough operations for each value
        for (Map.Entry<Integer, List<Integer>> entry : operationsMap.entrySet()) {
            List<Integer> opsList = entry.getValue();
            // If there are enough operations, take the smallest ones
            if (opsList.size() >= threshold) {
                Collections.sort(opsList); // Sort in ascending order
                int sumOps = 0;
                for (int i = 0; i < threshold; i++) {
                    sumOps += opsList.get(i); // Sum the smallest `threshold` operations
                }
                minOps = Math.min(minOps, sumOps); // Update minimum operations
            }
        }

        // If no equal elements were found, return -1
        return minOps == Integer.MAX_VALUE ? -1 : minOps;
    }
}

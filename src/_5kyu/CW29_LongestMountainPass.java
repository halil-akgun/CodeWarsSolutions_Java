package _5kyu;

/*
You are an adventurous hiker planning to traverse a mountain range. The mountain range is represented by an array
of integers, where each element corresponds to the height of a mountain at that position. Your goal is to find
the longest mountain pass you can take based on your initial energy level.

Problem Description
 - You are given an array of mountains, where each element represents the height of the mountain.
 - A mountain pass is defined as a subarray of the mountain array. The length of a mountain pass is the length of the subarray.
 - You have an initial energy level E.
 - You start at any initial index of your choice.
 - Going up a mountain (i.e., moving from a lower height to a higher height) costs you energy equal to the difference in heights.
 - Going down a mountain or staying at the same height does not cost you any energy.
 - You can only move to the mountains on your right (i.e., the next index).
Your task is to find the longest mountain pass you can take based on your initial energy level. Return the length of
the longest mountain pass and the initial index from where you should start.

Input
 - mountains: An array of integers representing the heights of the mountains.
 - E: An integer representing your initial energy level.
Note: The length of the mountain array can be very large, up to 10^7.

Output
Return a tuple (max_length, start_index), where:
 - max_length: The length of the longest mountain pass you can take.
 - start_index: The initial index from where you should start the mountain pass.
If there are multiple mountain passes with the same length, return the one with the smallest initial index.
 */
public class CW29_LongestMountainPass {
    public static void main(String[] args) {
        System.out.println(longestMountainPass(new int[]{}, 0)); // (0, 0)
        System.out.println(longestMountainPass(new int[]{10, 10, 10}, 0)); // (3, 0)
        System.out.println(longestMountainPass(new int[]{1, 2, 3, 4, 5}, 0)); // (1, 0)
        System.out.println(longestMountainPass(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 3}, 1)); // (10, 0)
        System.out.println(longestMountainPass(new int[]{9, 1, 2, 3, 4, 5, 6, 9}, 7)); // (7, 0)
        System.out.println(longestMountainPass(new int[]{1, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 7)); // (9, 1)
    }

    public static Result longestMountainPass(int[] mountains, int E) {
        int maxLength = 0;
        int bestStartIndex = 0;

        for (int i = 0; i < mountains.length; i++) {
            if (maxLength > mountains.length - i) break;
            int currentLength = calculate(mountains, i, E, 1);
            if (currentLength > maxLength) {
                maxLength = currentLength;
                bestStartIndex = i;
            }
        }

        return new Result(maxLength, bestStartIndex);
    }

    private static int calculate(int[] mountains, int i, int E, int count) {
        if (i > mountains.length - 2) return count;

        if (mountains[i + 1] > mountains[i]) {
            if (E < (mountains[i + 1] - mountains[i])) return count;
            return calculate(mountains, i + 1, E - (mountains[i + 1] - mountains[i]), ++count);
        } else {
            return calculate(mountains, ++i, E, ++count);
        }
    }

    public static class Result {
        int maxLength;
        int startIdx;

        public Result(int maxLength, int startIdx) {
            this.maxLength = maxLength;
            this.startIdx = startIdx;
        }

        @Override
        public String toString() {
            return "(" + maxLength + ", " + startIdx + ")";
        }
    }
}

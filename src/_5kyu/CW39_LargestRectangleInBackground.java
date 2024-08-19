package _5kyu;

import java.util.Stack;

/*
Imagine a photo taken to be used in an advertisement. The background on the left of the motive is whitish
and you want to write some text on that background. So you scan the photo with a high resolution scanner and,
for each line, count the number of pixels from the left that are sufficiently white and suitable for being
written on. Your job is to find the area of the largest text box you can place on those pixels.

Example: In the figure below, the whitish background pixels of the scanned photo are represented by asterisks.
*********************************
*********
*******
******
******
******
**************
**************
**************
***************
*********************

If you count the pixels on each line from the left you get the list (or array, depending on which
language you are using) [33, 9, 7, 6, 6, 6, 14, 14, 14, 15, 21]. The largest reactangle that you can
place on these pixels has an area of 70, and is represented by the dots in the figure below.
*********************************
*********
*******
******
******
******
..............
..............
..............
..............*
..............*******

Write a function that, given a list of the number whitish pixels on each line in the background,
returns the area of the largest rectangle that fits on that background.
 */
public class CW39_LargestRectangleInBackground {
    public static void main(String[] args) {
        System.out.println(new Histogram(33, 9, 7, 6, 6, 6, 14, 14, 14, 15, 21).largestRect()); // 70
        System.out.println(new Histogram().largestRect()); // 0
    }
}

class Histogram {
    private final int[] values;

    public Histogram(int... values) {
        this.values = values;
    }

    public long largestRect() {
        // way 1 (time out)
//        long maxArea = 0;
//        for (long i = 0; i < values.length; i++) {
//            long maxWidth = Integer.MAX_VALUE;
//            for (long j = i; j < values.length; j++) {
//                maxWidth = Math.min(maxWidth, values[(int) j]);
//                maxArea = Math.max(maxArea, maxWidth * (j - i + 1));
//            }
//        }
//        return maxArea;


        // way 2
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i <= values.length; i++) {
            int h = (i == values.length ? 0 : values[i]);
            while (!stack.isEmpty() && h < values[stack.peek()]) {
                int height = values[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, (long) height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}

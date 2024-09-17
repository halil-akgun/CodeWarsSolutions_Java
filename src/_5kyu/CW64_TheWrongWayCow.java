package _5kyu;

import java.util.Arrays;

/*
Have you ever noticed that cows in a field are always facing in the same direction?
Well.... not quite always.
One stubborn cow wants to be different from the rest of the herd - it's that damn Wrong-Way Cow!

Task
Given a field of cows find which one is the Wrong-Way Cow and return her position.

Notes:
There are always at least 3 cows in a herd
There is only 1 Wrong-Way Cow!
Fields are rectangular
The cow position is zero-based [x,y] of her head (i.e. the letter c)
There are no diagonal cows -- they only face North/South/East/West (i.e. up/down/right/left)

Examples
Ex1
cow.cow.cow.cow.cow
cow.cow.cow.cow.cow
cow.woc.cow.cow.cow
cow.cow.cow.cow.cow
Answer: [6,2]

Ex2
c..........
o...c......
w...o.c....
....w.o....
......w.cow
Answer: [8,4]

Notes
The test cases will NOT test any situations where there are "imaginary" cows,
so your solution does not need to worry about such things!

To explain - Yes, I recognise that there are certain configurations where an "imaginary" cow may appear
that in fact is just made of three other "real" cows. In the following field you can see there are 4 real
cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).

But such a field will never be tested by this Kata.

...w...
..cow..
.woco..
.ow.c..
.c.....
 */
public class CW64_TheWrongWayCow {
    int a = 1;
    public static void main(String[] args) {
        CW64_TheWrongWayCow q = new CW64_TheWrongWayCow();
        q.a = 3;
        System.out.println(q.a);
        System.out.println(Arrays.toString(findWrongWayCow(new char[][]{
                {'c', 'o', 'w', '.', '.', 'c', 'o', 'w', '.', '.'},
                {'c', 'o', 'w', '.', '.', 'c', 'o', 'w', '.', '.'},
                {'c', 'o', 'w', '.', '.', 'w', 'o', 'c', '.', '.'},
                {'c', 'o', 'w', '.', '.', 'c', 'o', 'w', '.', '.'},
                {'c', 'o', 'w', '.', '.', 'c', 'o', 'w', '.', '.'}
        }))); // [7, 2]

        System.out.println(Arrays.toString(findWrongWayCow(new char[][]{
                {'c', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'o', '.', '.', '.', 'c', '.', '.', '.', '.', '.'},
                {'w', '.', '.', '.', 'o', '.', 'c', '.', '.', '.'},
                {'.', '.', '.', '.', 'w', '.', 'o', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', 'w', 'c', 'o', 'w'}
        }))); // [7, 4]

        System.out.println(Arrays.toString(findWrongWayCow(new char[][]{
                {'.', '.', '.', 'w', '.', '.', '.'},
                {'.', '.', 'c', 'o', 'w', '.', '.'},
                {'.', 'w', 'o', 'c', 'o', '.', '.'},
                {'.', 'o', 'w', '.', 'c', '.', '.'},
                {'.', 'c', '.', '.', '.', '.', '.'}
        }))); // [2, 1]

        System.out.println(Arrays.toString(findWrongWayCow(new char[][]{
                {'c', 'o', 'w', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', 'w', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', 'o', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', 'c', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'w'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'o'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'c'}
        }))); // [0, 0]
    }

    public static int[] findWrongWayCow(final char[][] field) {
        int[] cowCount = new int[]{0, 0, 0, 0}; // North, East, South, West
        int[][] cowPositions = new int[4][2];
        boolean found = false;

        for (int i = 0; i < field.length; i++) {
            if (found) break;
            for (int j = 0; j < field[i].length; j++) {
                if (i < field.length - 2 && field[i][j] == 'c' && field[i + 1][j] == 'o' && field[i + 2][j] == 'w') {
                    cowCount[0]++;
                    cowPositions[0][0] = j;
                    cowPositions[0][1] = i;
                } else if (j < field[i].length - 2 && field[i][j + 2] == 'c' && field[i][j + 1] == 'o' && field[i][j] == 'w') {
                    cowCount[1]++;
                    cowPositions[1][0] = j + 2;
                    cowPositions[1][1] = i;
                } else if (i < field.length - 2 && field[i + 2][j] == 'c' && field[i + 1][j] == 'o' && field[i][j] == 'w') {
                    cowCount[2]++;
                    cowPositions[2][0] = j;
                    cowPositions[2][1] = i + 2;
                } else if (j < field[i].length - 2 && field[i][j] == 'c' && field[i][j + 1] == 'o' && field[i][j + 2] == 'w') {
                    cowCount[3]++;
                    cowPositions[3][0] = j;
                    cowPositions[3][1] = i;
                }

                if (isOnlyOneWrongWayCow(cowCount)) {
                    found = true;
                    break;
                }
            }
        }

        return cowPositions[getWrongWayCowIndex(cowCount)];
    }

    private static boolean isOnlyOneWrongWayCow(int[] cowCount) {
        return Arrays.stream(cowCount).sum() > 2 && Arrays.stream(cowCount).filter(count -> count == 0).toArray().length == 2;
    }

    private static int getWrongWayCowIndex(int[] cowCount) {
        for (int i = 0; i < cowCount.length; i++) {
            if (cowCount[i] == 1) return i;
        }
        return 0;
    }
}

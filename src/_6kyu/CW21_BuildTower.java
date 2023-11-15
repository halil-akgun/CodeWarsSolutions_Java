package _6kyu;

import java.util.Arrays;

/*
Build a pyramid-shaped tower, as an array/list of strings, given a positive integer number of floors.
A tower block is represented with "*" character.

For example, a tower with 3 floors looks like this:
[
  "  *  ",
  " *** ",
  "*****"
]

And a tower with 6 floors looks like this:
[
  "     *     ",
  "    ***    ",
  "   *****   ",
  "  *******  ",
  " ********* ",
  "***********"
]
 */
public class CW21_BuildTower {
    public static void main(String[] args) {
        Arrays.stream(towerBuilder(6)).forEach(System.out::println);
    }

    public static String[] towerBuilder(int nFloors) {
        String[] result = new String[nFloors];
        for (int i = 0; i < nFloors; i++) {
            result[i] = " ".repeat((nFloors * 2 - 1 - (i * 2 + 1)) / 2)
                    + "*".repeat(i * 2 + 1)
                    + " ".repeat((nFloors * 2 - 1 - (i * 2 + 1)) / 2);
        }
        return result;

        // shoplucaaa:
//        return java.util.stream.IntStream.rangeClosed(1, nFloors).mapToObj(x -> " ".repeat(nFloors - x) + "*".repeat(x * 2 - 1) + " ".repeat(nFloors - x)).toArray(String[]::new);
    }
}

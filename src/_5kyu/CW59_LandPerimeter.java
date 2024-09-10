package _5kyu;

import static java.util.stream.IntStream.range;

/*
Given an array arr of strings, complete the function by calculating the total perimeter of all the islands.
Each piece of land will be marked with 'X' while the water fields are represented as 'O'.
Consider each tile being a perfect 1 x 1 piece of land. Some examples for better visualization:
['XOOXO',
 'XOOXO',
 'OOOXO',
 'XXOXO',
 'OXOOO']

which represents:
https://i.snag.gy/ZOQYs2.jpg

should return: "Total land perimeter: 24".

Following input:
['XOOO',
 'XOXO',
 'XOXO',
 'OOXX',
 'OOOO']

which represents:
https://i.snag.gy/Kv9BEz.jpg

should return: "Total land perimeter: 18"
 */
public class CW59_LandPerimeter {
    public static void main(String[] args) {
        System.out.println(landPerimeter(new String[]{"XOOXO", "XOOXO", "OOOXO", "XXOXO", "OXOOO"})); // Total land perimeter: 24
        System.out.println(landPerimeter(new String[]{"XOOO", "XOXO", "XOXO", "OOXX", "OOOO"})); // Total land perimeter: 18
    }

    public static String landPerimeter(String[] arr) {
        int top = 0, right = 0, bottom = 0, left = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if ((i > 0 && arr[i - 1].charAt(j) != 'X' && arr[i].charAt(j) == 'X') || (i == 0 && arr[i].charAt(j) == 'X'))
                    top++;
                if ((i < arr.length - 1 && arr[i + 1].charAt(j) != 'X' && arr[i].charAt(j) == 'X') || (i == arr.length - 1 && arr[i].charAt(j) == 'X'))
                    bottom++;
                if ((j > 0 && arr[i].charAt(j - 1) != 'X' && arr[i].charAt(j) == 'X') || (j == 0 && arr[i].charAt(j) == 'X'))
                    left++;
                if ((j < arr[i].length() - 1 && arr[i].charAt(j + 1) != 'X' && arr[i].charAt(j) == 'X') || (j == arr[i].length() - 1 && arr[i].charAt(j) == 'X'))
                    right++;
            }
        }

        return "Total land perimeter: " + (top + right + bottom + left);


        // maryMoll:
//        int perimeter = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length(); j++) {
//                if (arr[i].charAt(j) == 'X') {
//                    perimeter += 4;
//                    if (i > 0 && arr[i - 1].charAt(j) == 'X') {
//                        perimeter -= 2;
//                    }
//                    if (j > 0 && arr[i].charAt(j - 1) == 'X') {
//                        perimeter -= 2;
//                    }
//                }
//            }
//        }


        // ParanoidUser:
//        return "Total land perimeter: " + range(0, arr.length).flatMap(i -> range(0, arr[i].length()).map(
//                j -> i > 0 && arr[i - 1].charAt(j) == 'X' && j > 0 && arr[i].charAt(j - 1) == 'X' || arr[i].charAt(j) == 'O' ? 0 :
//                        i > 0 && arr[i - 1].charAt(j) == 'X' ? 2 : j > 0 && arr[i].charAt(j - 1) == 'X' ? 2 : 4)).sum();
    }
}

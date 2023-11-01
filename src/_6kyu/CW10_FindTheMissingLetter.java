package _6kyu;

import java.util.stream.IntStream;

/*
Write a method that takes an array of consecutive (increasing) letters as
input and that returns the missing letter in the array.

You will always get an valid array. And it will be always exactly one letter be missing.
The length of the array will always be at least 2.
The array will always contain letters in only one case.

Example:
['a','b','c','d','f'] -> 'e'
['O','Q','R','S'] -> 'P'
(Use the English alphabet with 26 letters!)
 */
public class CW10_FindTheMissingLetter {
    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
    }

    public static char findMissingLetter(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] != array[i] + 1) return (char) (array[i] + 1);
        }
        return ' ';

        // JensPiegsa, roeiaz:
//        return IntStream.range(0, array.length - 1)
//                .parallel()
//                .filter(i -> array[i + 1] != array[i] + 1)
//                .mapToObj(i -> (char) (array[i] + 1))
//                .findAny().orElseThrow(IllegalArgumentException::new);
    }
}

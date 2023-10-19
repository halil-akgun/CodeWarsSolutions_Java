package _7kyu;

import java.util.Arrays;

/*
An anagram is the result of rearranging the letters of a word to produce a new word.
Note: anagrams are case insensitive
Complete the function to return true if the two arguments given are anagrams of each other; return false otherwise.

Examples
"foefet" is an anagram of "toffee"
"Buckethead" is an anagram of "DeathCubeK"
 */
public class CW33_AnagramDetection {
    public static void main(String[] args) {
        System.out.println(isAnagram("Buckethead", "DeathCubeK"));
    }

    public static boolean isAnagram(String test, String original) {
        return Arrays.stream(test.toLowerCase().split("")).sorted().toList().toString()
                .equals(Arrays.stream(original.toLowerCase().split("")).sorted().toList().toString());
    }
}

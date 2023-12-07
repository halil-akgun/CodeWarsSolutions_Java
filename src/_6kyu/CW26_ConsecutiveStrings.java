package _6kyu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
You are given an array(list) strarr of strings and an integer k. Your task is to return
the first longest string consisting of k consecutive strings taken in the array.

Examples:
strarr = ["tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"], k = 2
Concatenate the consecutive strings of strarr by 2, we get:
treefoling   (length 10)  concatenation of strarr[0] and strarr[1]
folingtrashy ("      12)  concatenation of strarr[1] and strarr[2]
trashyblue   ("      10)  concatenation of strarr[2] and strarr[3]
blueabcdef   ("      10)  concatenation of strarr[3] and strarr[4]
abcdefuvwxyz ("      12)  concatenation of strarr[4] and strarr[5]
Two strings are the longest: "folingtrashy" and "abcdefuvwxyz".
The first that came is "folingtrashy" so
longest_consec(strarr, 2) should return "folingtrashy".

In the same way:
longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
n being the length of the string array, if n = 0 or k > n or k <= 0 return "" (return Nothing in Elm, "nothing" in Erlang).
 */
public class CW26_ConsecutiveStrings {
    public static void main(String[] args) {
        System.out.println(longestConsec(new String[]{"tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"}, 2));
    }

    public static String longestConsec(String[] strarr, int k) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= strarr.length - k; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < k; j++) {
                temp.append(strarr[i + j]);
            }
            list.add(temp.toString());
        }
        return list.stream().max(Comparator.comparing(String::length)).orElse("");

        // Darnor:
//        return (k > 0 && strarr.length > 0 && k <= strarr.length) ?
//                IntStream.rangeClosed(0, strarr.length - k)
//                        .mapToObj(i -> IntStream.range(0, k).mapToObj(j -> strarr[i + j]).collect(Collectors.joining()))
//                        .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
//                        .findFirst().get()
//                : "";
    }
}
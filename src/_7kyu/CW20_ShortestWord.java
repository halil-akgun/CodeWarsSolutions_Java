package _7kyu;

import java.util.Arrays;
import java.util.Comparator;

/*
Simple, given a string of words, return the length of the shortest word(s).

String will never be empty and you do not need to account for different data types.
 */
public class CW20_ShortestWord {
    public static void main(String[] args) {
        System.out.println(findShort("hey gidi gunler..."));
    }

    public static int findShort(String s) {
        return Arrays.stream(s.replace("[\\p{Punct}]", "")
                .split(" ")).sorted(Comparator.comparing(String::length)).toList().get(0).length();

        // shadowmanos, Unnamed, Daniel Matetaka, lodimob, No0ne, mpanin, raluca.chintoanu, Orodiel, jedrzejlepa, chalup...:
//        return Arrays.stream(s.split(" ")).mapToInt(String::length).min().getAsInt();
    }
}

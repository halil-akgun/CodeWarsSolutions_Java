package _6kyu;

import java.util.Arrays;

/*
Complete the solution so that it splits the string into pairs of two characters.
If the string contains an odd number of characters then it should replace the
missing second character of the final pair with an underscore ('_').

Examples:
* 'abc' =>  ['ab', 'c_']
* 'abcdef' => ['ab', 'cd', 'ef']
 */
public class CW20_SplitStrings {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("qwert")));
    }

    public static String[] solution(String s) {
        if (s.length() % 2 == 1) s = s + "_";
        String[] arr = new String[s.length() / 2];
        for (int i = 0; i < s.length(); i += 2) {
            arr[i / 2] = s.charAt(i) + "" + s.charAt(i + 1);
        }
        return arr;

        // ParanoidUser, acpl1992, SuGalJim, Fredmuhu, Kacpiu600
//        return (s + (s.length() % 2 > 0 ? "_" : "")).split("(?<=\\G.{2})");
    }
}

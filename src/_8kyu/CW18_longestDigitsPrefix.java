package _8kyu;

import java.util.ArrayList;
import java.util.List;

/*
Given a string, output its longest prefix which contains only digits.

Example
For inputString = "123aa1", the output should be
solution(inputString) = "123".
 */
public class CW18_longestDigitsPrefix {
    public static void main(String[] args) {
        String str = "  3) always check for whitespaces";
        System.out.println(solution(str));
    }

    static String solution(String inputString) {
        String digits = "";
        for (int i = 0; i < inputString.length(); i++) {
            try {
                digits += Integer.parseInt(inputString.substring(i, i + 1));
            } catch (NumberFormatException e) {
                return digits;
            }
        }
        return digits;
    }
}
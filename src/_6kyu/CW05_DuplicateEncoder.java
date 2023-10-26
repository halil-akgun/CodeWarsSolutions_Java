package _6kyu;

import java.util.stream.Collectors;

/*
The goal of this exercise is to convert a string to a new string where each character
in the new string is "(" if that character appears only once in the original string, or ")"
if that character appears more than once in the original string.
Ignore capitalization when determining if a character is a duplicate.

Examples
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))(("
Notes
Assertion messages may be unclear about what they display in some languages.
If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!
 */
public class CW05_DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("Success"));
    }

    static String encode(String word) {
        String toLower = word.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < toLower.length(); i++) {
            if (toLower.indexOf(toLower.charAt(i)) == toLower.lastIndexOf(toLower.charAt(i))) {
                result.append("(");
            } else {
                result.append(")");
            }
        }
        return result.toString();

        // SithFire, omy, saladddd, 王盟元, Araton, Andre Missao
//        return word.toLowerCase()
//                .chars()
//                .mapToObj(i -> String.valueOf((char) i))
//                .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
//                .collect(Collectors.joining());
    }
}

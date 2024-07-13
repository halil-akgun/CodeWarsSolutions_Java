package _5kyu;

import java.util.Stack;

/*
In this kata, you will be given a string of text and valid parentheses, such as "h(el)lo".
You must return the string, with only the text inside parentheses reversed, so "h(el)lo" becomes "h(le)lo".
However, if said parenthesized text contains parenthesized text itself, then that too must reversed back,
so it faces the original direction. When parentheses are reversed, they should switch directions,
so they remain syntactically correct (i.e. "h((el)l)o" becomes "h(l(el))o"). This pattern should repeat
for however many layers of parentheses. There may be multiple groups of parentheses at any level
(i.e. "(1) (2 (3) (4))"), so be sure to account for these.

For example:
reverseInParens("h(el)lo") == "h(le)lo";
reverseInParens("a ((d e) c b)") == "a (b c (d e))";
reverseInParens("one (two (three) four)") == "one (ruof (three) owt)";
reverseInParens("one (ruof ((rht)ee) owt)") == "one (two ((thr)ee) four)";

Input parentheses will always be valid (i.e. you will never get "(()").
Blank string will also be considered as valid, and should return blank string.
 */
public class CW11_ReverseInsideParentheses {
    public static void main(String[] args) {
        System.out.println(reverseParens("h(el)lo")); // "h(le)lo"
        System.out.println(reverseParens("a ((d e) c b)")); // "a (b c (d e))"
        System.out.println(reverseParens("one (two (three) four)")); // "one (ruof (three) owt)"
        System.out.println(reverseParens("one (ruof ((rht)ee) owt)")); // "one (two ((thr)ee) four)"
    }

    public static String reverseParens(String text) {
        Stack<Integer> openParens = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(') {
                openParens.add(i);
            } else if (text.charAt(i) == ')') {
                text = text.substring(0, openParens.peek() + 1)
                        + reverseStr(text.substring(openParens.pop() + 1, i))
                        + text.substring(i);
            }
        }

        return text;
    }

    private static String reverseStr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '(') {
                sb.append(')');
            } else if (str.charAt(i) == ')') {
                sb.append('(');
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}

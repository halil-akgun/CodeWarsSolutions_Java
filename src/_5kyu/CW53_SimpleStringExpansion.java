package _5kyu;

import java.util.Stack;

/*
Consider the following expansion:
solve("3(ab)") = "ababab"     -- because "ab" repeats 3 times
solve("2(a3(b))") = "abbbabbb" -- because "a3(b)" == "abbb", which repeats twice.

Given a string, return the expansion of that string.
Input will consist of only lowercase letters and numbers (1 to 9) in valid parenthesis.
There will be no letters or numbers after the last closing parenthesis.
 */
public class CW53_SimpleStringExpansion {
    public static void main(String[] args) {
        System.out.println(solve("3(ab)")); // ababab
        System.out.println(solve("2(a3(b))")); // abbbabbb
    }

    public static String solve(String s) {
        Stack<Integer> openingBrackets = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                openingBrackets.add(i);
            } else if (sb.charAt(i) == ')') {
                int openIdx = openingBrackets.pop();
                StringBuilder num = new StringBuilder();

                for (int j = openIdx - 1; j >= 0; j--) {
                    if (Character.isDigit(sb.charAt(j)))
                        num.insert(0, sb.charAt(j));
                    else
                        break;
                }

                int repeatCount = num.isEmpty() ? 1 : Integer.parseInt(num.toString());

                String prefix = sb.substring(0, openIdx - num.length());
                String repeatedSection = sb.substring(openIdx + 1, i).repeat(repeatCount);
                String suffix = sb.substring(i + 1);


                sb.setLength(0);
                sb.append(prefix).append(repeatedSection).append(suffix);

                i = prefix.length() + repeatedSection.length() - 1;
            }
        }

        return sb.toString();
    }
}

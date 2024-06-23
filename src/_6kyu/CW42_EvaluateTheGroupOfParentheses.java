package _6kyu;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
The function is given a non-empty balanced parentheses string. Each opening '(' has a corresponding closing ')'.
Compute the total score based on the following rules:

Substring s == () has score 1, so "()" should return 1
Substring s1s2 has total score as score of s1 plus score of s2, so "()()" should return 1 + 1 = 2
Substring (s) has total score as two times score of s, so "(())" should return 2 * 1 = 2
Return the total score as an integer.

Examples
eval_parentheses("()") ➞ 1
# 1

eval_parentheses("(())") ➞ 2
# 2 * 1

eval_parentheses("()()") ➞ 2
# 1 + 1

eval_parentheses("((())())") ➞ 6
# 2 * (2 * 1 + 1)

eval_parentheses("(()(()))") ➞ 6
# 2 * (1 + 2 * 1)

eval_parentheses("()(())") ➞ 3
# 1 + 2 * 1

eval_parentheses("()((()))") ➞ 5
# 1 + 2 * 2 * 1
 */
public class CW42_EvaluateTheGroupOfParentheses {
    public static void main(String[] args) {
        System.out.println(evalParentheses("()"));
        System.out.println(evalParentheses("((()))"));
        System.out.println(evalParentheses("()()"));
        System.out.println(evalParentheses("((())())"));
        System.out.println(evalParentheses("(()(()))"));
        System.out.println(evalParentheses("()(())"));
        System.out.println(evalParentheses("()((()))"));
        System.out.println(evalParentheses("()(((((())))))"));
    }

    public static int evalParentheses(String s) {

        while (s.contains("()")) {
            s = s.replace("()", "+1");
        }

        Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
        Matcher matcher;

        while ((matcher = pattern.matcher(s)).find()) {
            String group = matcher.group(1);

            if (group.length() - group.replaceAll("\\+", "").length() > 1) {
                group = Arrays.stream(group.substring(1).split("\\+")).mapToInt(Integer::parseInt).sum() + "";
            } else if (group.contains("+")) {
                group = group.substring(1);
            }

            int value = Integer.parseInt(group);
            int doubleValue = value * 2;
            s = matcher.replaceFirst("+" + doubleValue);
        }

        if (s.charAt(0) == '+') {
            String[] a = s.substring(1).split("\\+");
            return Arrays.stream(s.substring(1).split("\\+")).mapToInt(Integer::parseInt).sum();
        }

        return Arrays.stream(s.split("\\+")).mapToInt(Integer::parseInt).sum();


        // LetMeeDie, Elsa123 :
//        Stack<Integer> st = new Stack(); st.push(0);
//        for (char c : s.toCharArray()) {
//            if (c == ')')
//                st.push(Math.max(1, st.pop() * 2) + st.pop());
//            else st.push(0);
//        }
//        return st.pop();
    }
}
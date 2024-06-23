package _6kyu;

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
        System.out.println(evalParentheses("(())"));
        System.out.println(evalParentheses("()()"));
        System.out.println(evalParentheses("((())())"));
        System.out.println(evalParentheses("(()(()))")); // not passed
        System.out.println(evalParentheses("()(())"));
        System.out.println(evalParentheses("()((()))"));
    }

    public static int evalParentheses(String s) {

        int result = 0;
        int openParentheses = 0;
        int temp = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openParentheses++;
            } else {
                if (i != 0 && s.charAt(i - 1) == '(') {
                    temp++;
                } else {
                    temp *= 2;
                }
                openParentheses--;
                if (openParentheses == 0) {
                    result += temp;
                    temp = 0;
                }
            }
        }

        return result;
    }
}

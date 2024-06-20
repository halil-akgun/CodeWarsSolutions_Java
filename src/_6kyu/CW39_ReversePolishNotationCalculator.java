package _6kyu;

import java.util.Stack;

/*
Your job is to create a calculator which evaluates expressions in Reverse Polish notation.
https://en.wikipedia.org/wiki/Reverse_Polish_notation

For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2) * 4) - 3 in normal notation) should evaluate to 14.

For your convenience, the input is formatted such that a space is provided between every token.

Empty expression should evaluate to 0.

Valid operations are +, -, *, /.

You may assume that there won't be exceptional situations (like stack underflow or division by zero).
 */
public class CW39_ReversePolishNotationCalculator {
    public static void main(String[] args) {
        System.out.println(evaluate("5 1 2 + 4 * + 3 -"));
    }

    private static double evaluate(String expr) {

        if (expr.isEmpty()) return 0;

        String[] tokens = expr.split(" ");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                stack.add(Double.parseDouble(token));
            } else {
                double a = stack.pop();
                double b = stack.pop();
                stack.add(calculate(b, a, token));
            }
        }
        return stack.pop();
    }

    private static double calculate(double a, double b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}

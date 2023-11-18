package _6kyu;

import java.util.List;
import java.util.Stack;

/*
Write a function that takes a string of braces, and determines if the order of the braces
is valid. It should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata, but introduces new characters:
brackets [], and curly braces {}. Thanks to @arnedag for the idea!

All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.

What is considered Valid?
A string of braces is considered valid if all braces are matched with the correct brace.

Examples
"(){}[]"   =>  True
"([{}])"   =>  True
"(}"       =>  False
"[(])"     =>  False
"[({})](]" =>  False
 */
public class CW24_ValidBraces {
    public static void main(String[] args) {
        System.out.println(isValid("([{}])"));
    }

    public static boolean isValid(String braces) {
        List<Character> openParens = List.of('(', '{', '[');
        List<Character> closeParens = List.of(')', '}', ']');
        Stack<Character> openParenStack = new Stack<>();
        for (int i = 0; i < braces.length(); i++) {
            char a = braces.charAt(i);
            if (openParens.contains(a)) {
                openParenStack.add(a);
            } else if (openParenStack.isEmpty() || closeParens.indexOf(a) != openParens.indexOf(openParenStack.pop())) {
                return false;
            }
        }
        return openParenStack.isEmpty();
    }
}

package _5kyu;

import java.math.BigInteger;

/*
Your job is to write a function which increments a string, to create a new string.

If the string already ends with a number, the number should be incremented by 1.
If the string does not end with a number. the number 1 should be appended to the new string.

Examples:
foo -> foo1
foobar23 -> foobar24
foo0042 -> foo0043
foo9 -> foo10
foo099 -> foo100

Attention: If the number has leading zeros the amount of digits should be considered.
 */
public class CW16_StringIncrementer {
    public static void main(String[] args) {
        System.out.println(incrementString("foo")); // foo1
        System.out.println(incrementString("foobar23")); // foobar24
        System.out.println(incrementString("foo0042")); // foo0043
        System.out.println(incrementString("foo9")); // foo10
        System.out.println(incrementString("foo099")); // foo100
    }

    public static String incrementString(String str) {
        StringBuilder num = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.isDigit(str.charAt(i))) {
                num.insert(0, str.charAt(i));
            } else {
                break;
            }
        }
        if (num.isEmpty()) {
            return str + "1";
        } else {
            return str.substring(0, str.length() - num.length()) + incrementNum(num.toString());
        }

        // shoplucaaa, pavliivandriana:
//        String u = java.util.regex.Pattern.compile("(\\d+)$").matcher(str).replaceAll(x -> String.format("%0" + x.group().length() +"d", new BigInteger(x.group()).add(BigInteger.ONE)));
//        return u.matches(".*(?<!\\d)")?u+1:u;
    }

    private static String incrementNum(String num) {
//        String oldNum = String.valueOf(Integer.parseInt(num));
//        String newNum = String.valueOf(Integer.parseInt(oldNum) + 1);
//        int quantityOfZeros = num.length() - newNum.length();
//        return "0".repeat(Math.max(0, quantityOfZeros)) + newNum;

        // for big numbers (2702441796757232407262853645261033)
        System.out.println(num);
        StringBuilder result = new StringBuilder();
        int plus = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (plus == 1) {
                if (num.charAt(i) == '9') {
                    result.insert(0, '0');
                } else {
                    result.insert(0, Character.getNumericValue(num.charAt(i)) + 1);
                    plus = 0;
                }
            } else {
                result.insert(0, num.charAt(i));
            }
        }
        return (plus == 1 ? "1" : "") + result;
    }
}

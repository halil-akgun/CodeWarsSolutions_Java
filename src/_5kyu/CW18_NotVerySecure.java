package _5kyu;

/*
In this example you have to validate if a user input string is alphanumeric.
The given string is not nil/null/NULL/None, so you don't have to check that.

The string has the following conditions to be alphanumeric:

At least one character ("" is not valid)
Allowed characters are uppercase / lowercase latin letters and digits from 0 to 9
No whitespaces / underscore
 */
public class CW18_NotVerySecure {
    public static void main(String[] args) {
        System.out.println(alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")); // true
        System.out.println(alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789with space")); // false
        System.out.println(alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789with_underscore")); // false
        System.out.println(alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789punctuation.")); // false
        System.out.println(alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789naïve")); // false
        System.out.println(alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789１strangedigit")); // false
        System.out.println(alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789emoji😊")); // false
    }

    public static boolean alphanumeric(String s) {
        return !s.isEmpty() && s.replaceAll("[A-Za-z0-9]", "").isEmpty();

        // Unnamed, Bubblegumsharkie, Marxus.Marxis, rel1nce, MoAls18, Algor_CW, guzev.dev, luis.bg, Dhiraj Kumar992, egsasdf (+ 51):
//        return s.matches("[A-Za-z0-9]+");

        // el-f, scottyboutin, AccelBoy, katyonas, amnsuryansh, vvs rohith, leshka290, yelzhan.1991, lukesv, vozerov (+ 6):
//        return s.matches("\\p{Alnum}+");
    }
}

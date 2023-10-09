package _7kyu;

/*
Check to see if a string has the same amount of 'x's and 'o's.
The method must return a boolean and be case insensitive. The string can contain any char.

Examples input/output:
XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
XO("zzoo") => false
 */
public class CW23_ExesAndOhs {
    public static void main(String[] args) {
        System.out.println(getXO("xxlooxoxo"));
    }

    public static boolean getXO(String str) {
        return str.replaceAll("[xX]", "").length() == str.replaceAll("[oO]", "").length();
    }
}

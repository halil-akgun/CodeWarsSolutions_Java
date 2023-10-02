package _7kyu;

/*
This time no story, no theory. The examples below show you how to write function accum:

Examples:
accum("abcd") -> "A-Bb-Ccc-Dddd"
accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
accum("cwAt") -> "C-Ww-Aaa-Tttt"
The parameter of accum is a string which includes only letters from a..z and A..Z.
 */
public class CW18_Mumbling {
    public static void main(String[] args) {
        System.out.println(accum("hello"));
    }

    public static String accum(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i)).toLowerCase();
            result.append("-").append(letter.toUpperCase()).append(letter.repeat(i));
        }
        return result.substring(1);
    }
}

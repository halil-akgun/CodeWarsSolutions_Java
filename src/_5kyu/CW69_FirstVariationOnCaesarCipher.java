package _5kyu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
The action of a Caesar cipher is to replace each plaintext letter (plaintext letters are from 'a' to 'z' or
from 'A' to 'Z') with a different one a fixed number of places up or down the alphabet.

This program performs a variation of the Caesar shift. The shift increases by 1 for each character (on each iteration).

If the shift is initially 1, the first character of the message to be encoded will be shifted by 1,
the second character will be shifted by 2, etc...

Coding: Parameters and return of function "movingShift"
param s: a string to be coded
param shift: an integer giving the initial shift

The function "movingShift" first codes the entire string and then returns an array of strings containing the coded
string in 5 parts (five parts because, to avoid more risks, the coded message will be given to five runners,
one piece for each runner).

If possible the message will be equally divided by message length between the five runners. If this is not possible,
parts 1 to 5 will have subsequently non-increasing lengths, such that parts 1 to 4 are at least as long as
when evenly divided, but at most 1 longer. If the last part is the empty string this empty string must be shown
in the resulting array.

For example, if the coded message has a length of 17 the five parts will have lengths of 4, 4, 4, 4, 1.
The parts 1, 2, 3, 4 are evenly split and the last part of length 1 is shorter. If the length is 16 the parts will
be of lengths 4, 4, 4, 4, 0. Parts 1, 2, 3, 4 are evenly split and the fifth runner will stay at home since
his part is the empty string. If the length is 11, equal parts would be of length 2.2, hence parts will be
of lengths 3, 3, 3, 2, 0.

You will also implement a "demovingShift" function with two parameters

Decoding: parameters and return of function "demovingShift"
 - an array of strings: s (possibly resulting from "movingShift", with 5 strings)
 - an int shift

"demovingShift" returns a string.

Example:
u = "I should have known that you would have a perfect answer for me!!!"
movingShift(u, 1) returns :
v = ["J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!"]
(quotes added in order to see the strings and the spaces, your program won't write these quotes, see Example Test Cases)
and demovingShift(v, 1) returns u. #Ref:
 */
public class CW69_FirstVariationOnCaesarCipher {
    @Test
    public void test1() {
        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
        assertEquals(v, movingShift(u, 1));
        assertEquals(u, demovingShift(movingShift(u, 1), 1));
    }

    public static List<String> movingShift(String s, int shift) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int partLength = (int) Math.ceil((double) s.length() / 5);
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isLetter(currentChar))
                sb.append(shiftCharacter(currentChar, shift));
            else
                sb.append(currentChar);

            shift++;

            if ((i + 1) % partLength == 0) {
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (!sb.isEmpty())
            result.add(sb.toString());

        while (result.size() < 5)
            result.add("");

        return result;
    }

    private static String shiftCharacter(char c, int shift) {
//        if (Character.isUpperCase(c))
//            return String.valueOf((char) ((c - 'A' + shift) % 26 + 'A'));
//        else
//            return String.valueOf((char) ((c - 'a' + shift) % 26 + 'a'));

        // chatGPT:
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int normalizedShift = (shift % 26 + 26) % 26;
        return String.valueOf((char) ((c - offset + normalizedShift) % 26 + offset));
    }

    public static String demovingShift(List<String> s, int shift) {
        StringBuilder sb = new StringBuilder();
        for (String part : s) {
            sb.append(part);
        }
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isLetter(sb.charAt(i)))
                sb.replace(i, i + 1, shiftCharacter(sb.charAt(i), -shift));
            shift++;
        }

        return sb.toString();
    }
}

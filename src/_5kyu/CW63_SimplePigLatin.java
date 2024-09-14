package _5kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.

Examples
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !
 */
public class CW63_SimplePigLatin {
    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool")); // igPay atinlay siay oolcay
        System.out.println(pigIt("Hello world !"));     // elloHay orldway !
    }

    public static String pigIt(String str) {
        return Arrays.stream(str.split(" "))
                .map(t -> t.matches("\\p{L}+") ? t.substring(1) + t.charAt(0) + "ay" : t)
                .collect(Collectors.joining(" "));

        // Blind4Basics, teebee, squeeeeeeeee, Klejdo, huntercorps, BarryLi, aeparshin, majedalmoqbeli, littlejkim, L1mb3rt, dfManiuk (+ 128):
//        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
}

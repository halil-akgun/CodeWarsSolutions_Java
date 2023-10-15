package _7kyu;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Complete the function that accepts a string parameter, and reverses each word in the string.
All spaces in the string should be retained.

Examples
"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps"
 */
public class CW29_ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("This is an example!    "));
    }

    public static String reverseWords(final String original) {
        boolean flag = false;
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != ' ') {
                temp.insert(0, original.charAt(i));
                flag = true;
            } else if (flag) {
                result.append(temp);
                result.append(original.charAt(i));
                temp.delete(0, temp.length());
                flag = false;
            } else {
                result.append(original.charAt(i));
            }
        }
        result.append(temp);
        return result.toString();

        // Warlord08, DeonOni, GabriMS, Marco Tecolapa, Renas, KaelAdrian, SandrotrDuarte, belatek, Iskamele, marooncats (+ 2)
//        return Arrays.stream(original.split("(?<=\\s)|(?=\\s+)"))
//                .map(str -> new StringBuilder(str).reverse().toString())
//                .collect(Collectors.joining());

        // RangerUA, irinakrtk, MEoverMIND, Petrrixx
//        return original.trim().isEmpty() ? original : Stream.of(original.split(" "))
//                .map(word -> new StringBuffer(word).reverse())
//                .collect(Collectors.joining(" "));
    }
}

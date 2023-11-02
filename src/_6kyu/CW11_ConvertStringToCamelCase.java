package _6kyu;

import java.util.Arrays;
import java.util.regex.Pattern;

/*
Complete the method/function so that it converts dash/underscore delimited words into camel casing.
The first word within the output should be capitalized only if the original word was capitalized
(known as Upper Camel Case, also often referred to as Pascal case). The next words should be always capitalized.

Examples
"the-stealth-warrior" gets converted to "theStealthWarrior"
"The_Stealth_Warrior" gets converted to "TheStealthWarrior"
"The_Stealth-Warrior" gets converted to "TheStealthWarrior"
 */
public class CW11_ConvertStringToCamelCase {
    public static void main(String[] args) {
        System.out.println(toCamelCase("beautiful_rose"));
    }

    static String toCamelCase(String s) {
        return s.isEmpty() ? "" : Arrays.stream(s.split("[-_]"))
                .map(t -> t = t.substring(0, 1).toUpperCase() + t.substring(1))
                .reduce(String::concat).map(t -> t = s.charAt(0) + t.substring(1)).get();

        // f-necas:
//        return Pattern.compile("[-|_](.)").matcher(s).replaceAll(r -> r.group(1).toUpperCase());
    }
}

package _5kyu;

import java.util.stream.Collectors;

/*
A History Lesson
Soundex is an interesting phonetic algorithm developed nearly 100 years ago for indexing names as
they are pronounced in English. The goal is for homophones to be encoded to the same representation
so that they can be matched despite minor differences in spelling.

Reference: https://en.wikipedia.org/wiki/Soundex

Preface
I first read about Soundex over 30 years ago. At the time it seemed to me almost like A.I. that you could
just type in somebody's name the way it sounded and there was still a pretty good chance it could match
the correct person record. That was about the same year as the first "Terminator" movie so it was easy
for me to put 2 and 2 together and conclude that Arnie must have had some kind of futuristic Soundex
chip in his titanium skull helping him to locate Serah Coner... or was it Sarh Connor... or maybe Sayra Cunnarr...

Task
In this Kata you will encode strings using a Soundex variation called "American Soundex" using
the following (case insensitive) steps:
   - Save the first letter. Remove all occurrences of h and w except first letter.
   - Replace all consonants (include the first letter) with digits as follows:
   - b, f, p, v = 1
   - c, g, j, k, q, s, x, z = 2
   - d, t = 3
   - l = 4
   - m, n = 5
   - r = 6
   - Replace all adjacent same digits with one digit.
   - Remove all occurrences of a, e, i, o, u, y except first letter.
   - If first symbol is a digit replace it with letter saved on step 1.
   - Append 3 zeros if result contains less than 3 digits. Remove all except first letter and 3 digits after it

Input
A space separated string of one or more names. E.g.
Sarah Connor

Output
Space separated string of equivalent Soundex codes (the first character of each code must be uppercase). E.g.
S600 C560
 */
public class CW73_Soundex {
    public static void main(String[] args) {
        System.out.println(soundex("Sarah Connor")); // S600 C560
        System.out.println(soundex("uryrtkzp")); // U663
    }

    public static String soundex(final String names) {
        System.out.println(names);
        String[] a = names.toLowerCase().split("\\s+");
        for (int i = 0; i < a.length; i++) {
            String letters = a[i].replaceAll("[^A-Za-z]", "").toUpperCase();
            if (!letters.isEmpty()) {
                String firstLetter = letters.substring(0, 1);
                a[i] = a[i].charAt(0) + a[i].substring(1).replaceAll("[hw]", "");
                a[i] = a[i].chars().mapToObj(t -> q((char) t)).map(String::valueOf).collect(Collectors.joining());
                a[i] = s(a[i]);
                a[i] = a[i].charAt(0) + a[i].substring(1).replaceAll("[aeiouy]", "");
                a[i] = firstLetter + a[i].substring(Character.isDigit(a[i].charAt(0)) ? 0 : 1);
                a[i] = (a[i] + "0".repeat(3)).substring(0, 4);
            }
        }

        return String.join(" ", a);
    }

    private static String s(String t) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            if (!(i > 0 && t.charAt(i - 1) == t.charAt(i))) {
                sb.append(t.charAt(i));
            }
        }
        System.out.println("****************");
        System.out.println(t);
        System.out.println(sb);
        return sb.toString();
    }

    private static char q(char c) {
        return switch (c) {
            case 'b', 'f', 'p', 'v' -> '1';
            case 'c', 'g', 'j', 'k', 'q', 's', 'x', 'z' -> '2';
            case 'd', 't' -> '3';
            case 'l' -> '4';
            case 'm', 'n' -> '5';
            case 'r' -> '6';
            default -> c;
        };
    }
}

package _7kyu;

import java.util.TreeSet;

/*
Take 2 strings s1 and s2 including only letters from a to z. Return a new sorted string,
the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.

Examples:
a = "xyaabbbccccdefww"
b = "xxxxyyyyabklmopq"
longest(a, b) -> "abcdefklmopqwxy"

a = "abcdefghijklmnopqrstuvwxyz"
longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
 */
public class CW21_TwoToOne {
    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
    }

    public static String longest(String s1, String s2) {
        String str = s1 + s2;
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < str.length(); i++) set.add(String.valueOf(str.charAt(i)));
        StringBuilder sb = new StringBuilder();
        for (String s : set) sb.append(s);
        return sb.toString();

        // olivier_meurice, IArdelyan, kilimanjaro96, S!D, ArchanaPallavi, vestverg, Janet.urias, ellimac, owo_BA, Aceinfernus (+ 42)
//        String s = s1 + s2;
//        return s.chars().distinct().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}

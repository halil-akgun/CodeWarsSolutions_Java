package _7kyu;

/*
Return the number (count) of vowels in the given string.

We will consider a, e, i, o, u as vowels for this Kata (but not y).

The input string will only consist of lower case letters and/or spaces.
 */
public class CW12_VowelCount {
    public static void main(String[] args) {
        System.out.println(getCount("qwertyuio"));
    }

    public static int getCount(String str) {
        return str.replaceAll("[^aeiuo]", "").length();

//        good ones from other developers' solutions
//        return str.replaceAll("(?i)[^aeiou]", "").length(); // (?i) is used for "case-insensitive" matching.
//        return (int) str.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }
}

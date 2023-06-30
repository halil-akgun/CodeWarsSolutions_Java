package _7kyu;

/*
Complete the function that takes a string of English-language text and returns
the number of consonants in the string.

Consonants are all letters used to write English excluding the vowels a, e, i, o, u.
 */
public class CW02_CountConsonants {
    public static void main(String[] args) {
        System.out.println(getCount("Xaeio uX/*-"));
    }

    public static int getCount(String str) {
        return str.replaceAll("[^\\p{L}]", "").replaceAll("[aeiouAEIOU ]", "").length();
    }
}

package _6kyu;

/*
A pangram is a sentence that contains every single letter of the alphabet at least once.
For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram,
because it uses the letters A-Z at least once (case is irrelevant).

Given a string, detect whether or not it is a pangram.
Return True if it is, False if not. Ignore numbers and punctuation.
 */
public class CW09_DetectPangram {
    public static void main(String[] args) {
        System.out.println(check("The quick brown fox jumps over the lazy dog"));
    }

    public static boolean check(String sentence) {
        return sentence.toLowerCase().replaceAll("[^a-z]", "").chars().distinct().count() == 'z' - 'a' + 1;

        // Thorwing, Kaliades, skillet367, Anishkmr300, Oroboro8, JensKarl, Yura063:
//        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }
}

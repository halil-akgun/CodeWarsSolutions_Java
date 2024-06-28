package _6kyu;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Everyone knows passphrases. One can choose passphrases from poems, songs, movies names and so on
but frequently they can be guessed due to common cultural references.
You can get your passphrases stronger by different means. One is the following:

choose a text in capital letters including or not digits and non alphabetic characters,

shift each letter by a given number but the transformed letter must be a letter (circular shift),
replace each digit by its complement to 9,
keep such as non alphabetic and non digit characters,
downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
reverse the whole result.

Example:
your text: "BORN IN 2015!", shift 1
1 + 2 + 3 -> "CPSO JO 7984!"
4 "CpSo jO 7984!"
5 "!4897 Oj oSpC"
 */
public class CW47_PlayingWithPassphrases {
    public static void main(String[] args) {
        System.out.println(playPass("BORN IN 2015!", 1));
    }

    public static String playPass(String s, int n) {
        String shiftedTransformed = IntStream.range(0, s.length())
                .mapToObj(i -> {
                    char c = s.charAt(i);
                    if (Character.isAlphabetic(c)) {
                        char shifted = (char) ((c - 'A' + n) % 26 + 'A');
                        return i % 2 == 0 ? Character.toString(shifted).toUpperCase() : Character.toString(shifted).toLowerCase();
                    } else if (Character.isDigit(c)) {
                        return Character.toString('9' - c + '0');
                    } else {
                        return Character.toString(c);
                    }
                }).collect(Collectors.joining());

        return new StringBuilder(shiftedTransformed).reverse().toString();
    }
}

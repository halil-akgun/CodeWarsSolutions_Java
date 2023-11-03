package _6kyu;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Write a function that takes in a string of one or more words, and returns the same string,
but with all five or more letter words reversed (Just like the name of this Kata). Strings passed
in will consist of only letters and spaces. Spaces will be included only when more than one word is present.

Examples:
spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
spinWords( "This is a test") => returns "This is a test"
spinWords( "This is another test" )=> returns "This is rehtona test"
 */
public class CW12_StopgninnipSMysdroW {
    public static void main(String[] args) {
        System.out.println(spinWords("Hey fellow warriors"));
    }

    public static String spinWords(String sentence) {
        Stream<StringBuilder> arr = Arrays.stream(sentence.split(" ")).map(StringBuilder::new);
        return arr.map(t -> t.length() >= 5 ? t.reverse().toString() : t.toString()).reduce((t, u) -> t + " " + u).get();

        // SithFire, ChungGor, reiayanami, zwirsi, Alejo-alvarezv, xryzzz1bg, Sinoffate, Iosif Chatzikyriakou:
//        return Arrays.stream(sentence.split(" "))
//                .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
//                .collect(Collectors.joining(" "));
    }
}

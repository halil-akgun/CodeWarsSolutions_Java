package _5kyu;

import java.util.stream.IntStream;

/*
Write a function named first_non_repeating_letter† that takes a string input,
and returns the first character that is not repeated anywhere in the string.

For example, if given the input 'stress', the function should return 't',
since the letter t only occurs once in the string, and occurs first in the string.

As an added challenge, upper- and lowercase letters are considered the same character, but the function
should return the correct case for the initial letter. For example, the input 'sTreSS' should return 'T'.

If a string contains all repeating characters, it should return an empty string ("");

† Note: the function is called firstNonRepeatingLetter for historical reasons,
but your function should handle any Unicode character.
 */
public class CW13_FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingLetter("oostress")); // t
        System.out.println(firstNonRepeatingLetter("oosTreSS")); // T
        System.out.println(firstNonRepeatingLetter("")); // ""
    }

    public static String firstNonRepeatingLetter(String s) {
        String temp = s.toLowerCase();
        int idx = IntStream.range(0, s.length())
                .filter(i -> temp.indexOf(temp.charAt(i)) == temp.lastIndexOf(temp.charAt(i)))
                .findFirst()
                .orElse(-1);

        return idx == -1 ? "" : s.substring(idx, idx + 1);


        // ParanoidUser:
//        return s.chars().filter(c -> s.toLowerCase().indexOf((c = Character.toLowerCase(c))) == s.toLowerCase().lastIndexOf(c))
//                .mapToObj(c -> "" + (char) c).findFirst().orElse("");
    }
}

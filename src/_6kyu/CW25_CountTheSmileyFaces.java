package _6kyu;

import java.util.List;

/*
Given an array (arr) as an argument complete the function
countSmileys that should return the total number of smiling faces.

Rules for a smiling face:

Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
Every smiling face must have a smiling mouth that should be marked with either ) or D
No additional characters are allowed except for those mentioned.

Valid smiley face examples: :) :D ;-D :~)
Invalid smiley faces: ;( :> :} :]

Example
countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;

Note
In case of an empty array return 0. You will not be tested with invalid input (input will always be an array).
Order of the face (eyes, nose, mouth) elements will always be the same.
 */
public class CW25_CountTheSmileyFaces {
    public static void main(String[] args) {
        System.out.println(countSmileys(List.of(";D", ":-(", ":-)", ";~)")));
    }

    public static int countSmileys(List<String> arr) {
        List<Character> eyes = List.of(':', ';');
        List<Character> noses = List.of('-', '~');
        List<Character> mouths = List.of(')', 'D');
        int count = 0;
        for (String w : arr) {
            if (eyes.contains(w.charAt(0)) && (w.length() == 3 ? noses.contains(w.charAt(1)) && mouths.contains(w.charAt(2)) : mouths.contains(w.charAt(1)))) {
                count++;
            }
        }
        return count;

        // Artur Wisniewski, LordKorea, zwirsi, oumayma.salhi, m_shiker, brandoncg_96, SvyatoslavTregubov, neroClaud, dunderbull1, ishawnspam, FrankieFoster (+ 25):
//        return (int)arr.stream().filter( x -> x.matches("[:;][-~]?[)D]")).count();
    }
}

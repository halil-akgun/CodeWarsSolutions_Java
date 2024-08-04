package _5kyu;

/*
Background
Congratulations! Your next best-selling novel is finally finished. You cut/paste text
fragments from your various notes to build the final manuscript. But you sure are a
terrible typist! Often you press the "paste" key multiple times by mistake.

You'd better fix those errors before sending it off to the publisher. Fortunately, you can code better than you can type.

Kata Task
Detect, and correct accidental cut/paste errors in the given text!

Example
What you did
(the spaces in the text are shown below as _ for more clarity).
Here_is_some paste
_piece_of_text paste x 2
that paste
_was paste x 2
_accidentally paste
_double paste x 4
_pasted. paste
The result
Here is some piece of text piece of text that was was accidentally double double double double pasted.

The corrected result
Here is some piece of text that was accidentally double pasted.

Notes
words are groups of alphabetic chars
Non-alphabetic chars are considered to be punctuation and spaces (there is no distinction)
Repeated letters within words are not errors -- address is not meant to be adres
The cutting never breaks words words apart
Fragments of only punctuation and/or spaces are never double-pasted
repeated punctuation is possible -- Hey!!! is not meant to be Hey!
repeated spaces is possible -- abc   def is not meant to be abc def
Only detect adjacent double pasting. We don't care if the same cut text might be elsewhere
Your code must treat only first repetitions as double pastes.
You want to remove the longest repetitions of the shortest sequences (e.g.  double in the example, not  double double))
Pasting occurs strictly left-to-right only appending to your current text
Here are some trickier examples:

Input	            Output
A_X_A_X_O_X_O_X_	A_X_O_X_	Correct (finds the first repeat)
A_X_A_X_O_X_O_X_	A_X_A_X_O_X_X	Wrong
A_A_B_A_A_B_	    A_B_A_B_	Correct (finds the first repeat, not the bigger one)
A_A_B_A_A_B_	    A_A_B_	Wrong
 */
public class CW24_CutPasteErrors {
    public static void main(String[] args) {
        System.out.println(fixCutPaste("A_X_A_X_O_X_O_X_")); // A_X_O_X_
        System.out.println(fixCutPaste("Oops.Oops.Oops.Oops.Oops.Oops.Oops.Oops.Oops.")); // Oops.
        System.out.println(fixCutPaste("REPEATED REPEATED REPEATED words at the start")); // REPEATED words at the start
        System.out.println(fixCutPaste("This ends with some REPEATED WORDS REPEATED WORDS")); // This ends with some REPEATED WORDS
        System.out.println(fixCutPaste("Here are some REPEATED REPEATED REPEATED words in the middle")); // Here are some REPEATED words in the middle
        System.out.println(fixCutPaste(".....SOMETHING SOMETHING at the front")); // .....SOMETHING at the front
        System.out.println(fixCutPaste("CCCCCCC")); // CCCCCCC
        System.out.println(fixCutPaste("Here are               ______LOTS______LOTS of spaces")); // Here are               ______LOTS of spaces
    }

    public static String fixCutPaste(String text) {
        StringBuilder result = new StringBuilder();
        boolean flag;
        for (int i = 0; i < text.length(); i++) {
            flag = true;
            for (int j = i + 2; j < text.length(); j++) {
                String substring = text.substring(i, j);
                if (!substring.replaceAll(substring.substring(0, 1), "").isEmpty()
                        && text.substring(j).startsWith(substring)
                        && isNotDifferentWords(text, i, j)) {
                    result.append(text, i, j);
                    flag = false;
                    int newI = i + ((j - i) * 2 - 1);
                    int length = text.substring(i, j).length();
                    for (int k = i + ((j - i) * 2); k < text.length() && text.substring(k).startsWith(text.substring(i, j)); k += length) {
                        newI = k - 1 + length;
                    }
                    i = newI;
                    break;
                }
            }
            if (flag) result.append(text, i, i + 1);
        }
        return result.toString();
    }

    private static boolean isNotDifferentWords(String text, int i, int j) {
        return i == 0
                || text.charAt(i) == ' '
                || text.substring(i-1, i).replaceAll("[\\p{Punct} ]", "").isEmpty()
                || text.substring(i - 1, i).equals(text.substring(j - 1, j));
    }
}

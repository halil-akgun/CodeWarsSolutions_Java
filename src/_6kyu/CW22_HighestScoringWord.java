package _6kyu;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a string of words, you need to find the highest scoring word.
Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.

For example, the score of abad is 8 (1 + 2 + 1 + 4).
You need to return the highest scoring word as a string.
If two words score the same, return the word that appears earliest in the original string.
All letters will be lowercase and all inputs will be valid.
 */
public class CW22_HighestScoringWord {
    public static void main(String[] args) {
        System.out.println(high("aa b"));
    }

    public static String high(String s) {
        int score = 0;
        String highestScoringWord = "";
        String[] words = s.split(" ");
        for (String word : words) {
            int score2 = word.chars().sum() - word.length() * ((int) 'a' - 1);
            System.out.println(score2);
            if (score2 > score) {
                score = score2;
                highestScoringWord = word;
            }
        }
        return highestScoringWord;


        // Decimater, CindyNoCoffee, Erick O, user8730369, SvyatoslavTregubov, rostyslav.ludchenko, angu1ss, MarberyUA, JungJuYoun, amit verma (+ 50):
//        return Arrays.stream(s.split(" "))
//                .max(Comparator.comparingInt(
//                        a -> a.chars().map(i -> i - 96).sum()
//                )).get();
    }
}

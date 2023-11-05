package _6kyu;

import java.util.HashSet;
import java.util.stream.Collectors;

/*
Count the number of Duplicates
Write a function that will return the count of distinct case-insensitive alphabetic
characters and numeric digits that occur more than once in the input string. The input
string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.

Example
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
 */
public class CW14_CountingDuplicates {
    public static void main(String[] args) {
        System.out.println(duplicateCount("Indivisibilities"));
    }

    public static int duplicateCount(String text) {
        HashSet<String> set = new HashSet<>();
        String textLowerCase = text.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < textLowerCase.length(); i++) {
            if (sb.indexOf(textLowerCase.substring(i, i + 1)) != -1) {
                set.add(textLowerCase.substring(i, i + 1));
            } else {
                sb.append(textLowerCase.charAt(i));
            }
        }
        return set.size();

        // Thorwing:
//        return (int)text.toLowerCase().chars().boxed().collect(Collectors.groupingBy(k->k,Collectors.counting())).values().stream().filter(e->e>1).count();
    }
}

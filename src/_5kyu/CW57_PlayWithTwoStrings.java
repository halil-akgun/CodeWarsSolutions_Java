package _5kyu;

import java.util.stream.Collectors;

/*
Your task is to Combine two Strings. But consider the rule...

By the way you don't have to check errors or incorrect input values, everything is ok without bad tricks,
only two input strings and as result one output string;-)...

And here's the rule:
Input Strings a and b: For every character in string a swap the casing of every occurrence of the same character in string b. Then do the same casing swap with the inputs reversed. Return a single string consisting of the changed version of a followed by the changed version of b. A char of a is in b regardless if it's in upper or lower case - see the testcases too.
I think that's all;-)...

Some easy examples:
Input: "abc" and "cde"      => Output: "abCCde"
Input: "ab" and "aba"       => Output: "aBABA"
Input: "abab" and "bababa"  => Output: "ABABbababa"

Once again for the last example - description from KenKamau, see discourse;-):
a) swap the case of characters in string b for every occurrence of that character in string a
char 'a' occurs twice in string a, so we swap all 'a' in string b twice. This means we start with "bababa" then "bAbAbA" => "bababa"
char 'b' occurs twice in string a and so string b moves as follows: start with "bababa" then "BaBaBa" => "bababa"
b) then, swap the case of characters in string a for every occurrence in string b
char 'a' occurs 3 times in string b. So string a swaps cases as follows: start with "abab" then => "AbAb" => "abab" => "AbAb"
char 'b' occurs 3 times in string b. So string a swaps as follow: start with "AbAb" then => "ABAB" => "AbAb" => "ABAB".
c) merge new strings a and b
return "ABABbababa"
 */
public class CW57_PlayWithTwoStrings {
    public static void main(String[] args) {
        System.out.println(workOnStrings("abc", "cde")); // "abCCde"
        System.out.println(workOnStrings("ab", "aba")); // "aBABA"
        System.out.println(workOnStrings("abab", "bababa")); // "ABABbababa"
        System.out.println(workOnStrings("abcdeFgtrzw", "defgGgfhjkwqe")); // "abcDeFGtrzWDEFGgGFhjkWqE"
    }

    public static String workOnStrings(String a, String b) {
        return swap(a, b) + swap(b, a);
    }

    private static String swap(String source, String target) {
        String distinctChars = source.toLowerCase().chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        for (int i = 0; i < distinctChars.length(); i++) {
            String currentChar = String.valueOf(distinctChars.charAt(i));
            if (target.toLowerCase().replaceAll("[^" + currentChar.toLowerCase() + "]", "").length() % 2 == 1) {
                source = source.chars()
                        .mapToObj(c -> currentChar.equalsIgnoreCase(String.valueOf((char) c))
                                ? String.valueOf((char) (Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c)))
                                : String.valueOf((char) c))
                        .collect(Collectors.joining());
            }
        }
        return source;
    }
}

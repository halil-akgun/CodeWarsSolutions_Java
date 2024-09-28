package _5kyu;

/*
Write a function called LCS that accepts two sequences and returns the longest subsequence common to the passed in sequences.

Subsequence
A subsequence is different from a substring. The terms of a subsequence need not be consecutive terms of the original sequence.

Example subsequence
Subsequences of "abc" = "a", "b", "c", "ab", "ac", "bc" and "abc".

LCS examples
Solution.lcs("abcdef", "abc") => returns "abc"
Solution.lcs("abcdef", "acf") => returns "acf"
Solution.lcs("132535365", "123456789") => returns "12356"

Notes
  - Both arguments will be strings
  - Return value must be a string
  - Return an empty string if there exists no common subsequence
  - Both arguments will have one or more characters (in JavaScript)
  - All tests will only have a single longest common subsequence. Don't worry about cases such as LCS( "1234", "3412" ),
    which would have two possible longest common subsequences: "12" and "34".

Note that the Haskell variant will use randomized testing, but any longest common subsequence will be valid.

Note that the OCaml variant is using generic lists instead of strings, and will also have randomized tests
(any longest common subsequence will be valid).
 */
public class CW74_LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lcs("abcdef", "abc")); // abc
        System.out.println(lcs("abcdef", "acf")); // acf
        System.out.println(lcs("132535365", "123456789")); // 12356
        System.out.println(lcs("finaltest", "zzzfinallyzzz")); //
    }

    public static String lcs(String x, String y) {

        StringBuilder longestSubsequence = new StringBuilder();

        for (int i = 0; i < y.length(); i++) {
            String currentSubsequence = findSubsequence(x, y, i);
            if (currentSubsequence.length() > longestSubsequence.length()) {
                longestSubsequence.setLength(0);
                longestSubsequence.append(currentSubsequence);
            }
        }

        return longestSubsequence.toString();
    }

    private static String findSubsequence(String firstStr, String secondStr, int startIndex) {
        StringBuilder subsequence = new StringBuilder();
        int positionInFirstStr = 0;
        for (int j = startIndex; j < secondStr.length(); j++) {
            for (int k = positionInFirstStr; k < firstStr.length(); k++) {
                if (secondStr.charAt(j) == firstStr.charAt(k)) {
                    subsequence.append(secondStr.charAt(j));
                    positionInFirstStr = k + 1;
                    break;
                }
            }
        }
        return subsequence.toString();
    }
}

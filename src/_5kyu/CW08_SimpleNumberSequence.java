package _5kyu;

/*
In this Kata, you will be given a string of numbers in sequence and your task will be to return the missing number.
If there is no number missing or there is an error in the sequence, return -1.

For example:
missing("123567") = 4
missing("899091939495") = 92
missing("9899101102") = 100
missing("599600601602") = -1 -- no number missing
missing("8990919395") = -1 -- error in sequence. Both 92 and 94 missing.

The sequence will always be in ascending order.
 */
public class CW08_SimpleNumberSequence {
    public static void main(String[] args) {
        System.out.println(missing("123567")); // 4
        System.out.println(missing("899091939495")); // 92
        System.out.println(missing("9899101102")); // 100
        System.out.println(missing("599600601602")); // -1
        System.out.println(missing("8990919395")); // -1
        System.out.println(missing("8249682497")); // -1
        System.out.println(missing("88593588593688593788")); // -1
        System.out.println(missing("6418546418566418576418586418596418606418616418636418646418656418666418676418686418699889899909919929939949959969979981000100110021003")); // -1
    }

    public static int missing(String s) {

        for (int i = 0; i < s.length() / 2 - 2; i++) {

            if (i > 17) return -1;
            long num = Long.parseLong(s.substring(0, i + 1));
            int missingNum = findMissingNumber(s, num);
            if (missingNum != -1) {
                return missingNum;
            }
        }

        return -1;
    }

    private static int findMissingNumber(String s, long first) {
        long exceptedNumber = first;
        int missingNumber = -1;
        int idx = 0;

        while (idx < s.length()) {
            String exceptedNumStr = String.valueOf(exceptedNumber);

            if (s.startsWith(exceptedNumStr, idx)) {
                idx += exceptedNumStr.length();
            } else if (missingNumber == -1) {
                missingNumber = (int) exceptedNumber;
            } else {
                return -1;
            }

            exceptedNumber++;
        }

        return missingNumber;
    }
}

package _5kyu;

import java.util.stream.IntStream;

/*
A squared string has n lines, each substring being n characters long: For example:
s = "abcd\nefgh\nijkl\nmnop" is a squared string of size 4.
We will use squared strings to code and decode texts. To make things easier
we suppose that our original text doesn't include the character '\n'.

Coding
Input:
a text t of length l.
Consider the smallest integer n such that n * n be greater or equal to l.
Complete t with the char of ascii code 11 (we suppose that this char
is not in our original text) until the length of t is n * n.
From now on we can transform the new t in a squared string s of size n by inserting '\n' where needed.
Apply a clockwise rotation of 90 degrees to s: that's it for the coding part.

Decoding
Input:
a squared string s resulting from the coding
Apply a counter-clockwise rotation of 90 degrees to s
Do some cleaning to have the original text t
You can see clockwise rotation of 90 degrees: http://www.codewars.com/kata/56dbeec613c2f63be4000be6
You can see counter-clockwise rotation of 90 degrees: http://www.codewars.com/kata/56dbf59b0a10feb08c000227

Example:
t = "I.was.going.fishing.that.morning.at.ten.o'clock"
code(t) -> "c.nhsoI\nltiahi.\noentinw\ncng.nga\nk..mg.s\n\voao.f.\n\v'trtig"
decode(code(t)) == "I.was.going.fishing.that.morning.at.ten.o'clock"
(Dots indicate spaces since they are quite invisible).

Notes:
Swift : character 11 is replaced by "\\u{F7}" (ie "÷" - alt 246 -)
Ocaml : character 11 is replaced by '&'
Perl : character 11 is replaced by '&'
Fortran: Your returned string for both functions are not permitted to contain redundant leading/trailing whitespace.
In return, you may safely assume that all input strings passed into your function(s) will not contain redundant
leading/trailing whitespace, i.e. you do not and should not trim the input string before operating on it
 */
public class CW14_CodingWithSquaredStrings {
    public static void main(String[] args) {
        System.out.println(code("")); // c.nhsoI\nltiahi.\noentinw\ncng.nga\nk..mg.s\n\voao.f.\n\v'trtig
        System.out.println(code("I.was.going.fishing.that.morning.at.ten.o'clock")); // c.nhsoI\nltiahi.\noentinw\ncng.nga\nk..mg.s\n\voao.f.\n\v'trtig
        System.out.println(decode(code("I.was.going.fishing.that.morning.at.ten.o'clock"))); // I.was.going.fishing.that.morning.at.ten.o'clock
    }

    public static String code(String s) {
        // clean all \n
        String finalS = s.replaceAll("\n", "");
        int n = IntStream.range(0, s.length()).filter(i -> i * i >= finalS.length()).findFirst().orElse(0);
        char[][] arr = new char[n][n];
        for (int i = 0; i < finalS.length(); i++) {
            arr[i / n][i % n] = finalS.charAt(i);
        }

        for (int i = n / 2; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '\u0000') arr[i][j] = '\u000B';
            }
        }
        rotate(arr);

        StringBuilder sb = new StringBuilder();
        for (char[] chars : arr) {
            sb.append(chars).append('\n');
        }

        if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '\n') sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private static void rotate(char[][] lines) {
        int border = 0;
        while (border < lines.length / 2) {
            for (int i = 0; i < lines.length - (border * 2) - 1; i++) {
                char rightTop = lines[border][(lines.length - 1) - border];
                // to the right
                for (int j = (lines.length - 1) - border; j > border; j--) {
                    lines[border][j] = lines[border][j - 1];
                }
                // to the top
                for (int j = border; j < (lines.length - 1) - border; j++) {
                    lines[j][border] = lines[j + 1][border];
                }
                // to the left
                for (int j = border; j < (lines.length - 1) - border; j++) {
                    lines[(lines.length - 1) - border][j] = lines[(lines.length - 1) - border][j + 1];
                }
                // to the bottom
                for (int j = (lines.length - 1) - border; j > border+1; j--) {
                    lines[j][(lines.length - 1) - border] = lines[j - 1][(lines.length - 1) - border];
                }
                lines[border+1][(lines.length - 1) - border] = rightTop;
            }
            border++;
        }
    }

    public static String decode(String s) {
        return code(code(code(s))).replaceAll("\n", "").replaceAll("\u000B", "");
    }
}

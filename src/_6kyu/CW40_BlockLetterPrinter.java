package _6kyu;

import java.util.HashMap;

/*
Write a function that accepts a string consisting only of ASCII letters and space(s) and returns that string
in block letters of 5 characters width and 7 characters height, with one space between characters.

The string should be formatted in a way that when passed to Javas' System.out.println()
function shows the desired output (see below for example).

The block letters should consist of corresponding capital letters.
It's irrelevant whether input consists of lower or upper case letters.
Any leading and/or trailing spaces in input should be ignored.
Empty strings or such containing only spaces should return an empty string.
The remaining spaces (between letters and/or words) are to be treated as any other character. This means that there will
be six spaces in output for a space in input, or a multiple of six, if there were more spaces - plus the one from preceding character!
Trailing spaces should be removed in the resulting string (and also in its' substrings!).
In order to facilitate debugging, test failure messages mangle the output: spaces are replaced
with the bullet character U+2022, while end-of-line characters \n are visible.
System.out.println(BlockLetterPrinter.blockPrint("heLLo WorLD"));
should result in an output that looks like this:

H   H EEEEE L     L      OOO        W   W  OOO  RRRR  L     DDDD
H   H E     L     L     O   O       W   W O   O R   R L     D   D
H   H E     L     L     O   O       W   W O   O R   R L     D   D
HHHHH EEEEE L     L     O   O       W W W O   O RRRR  L     D   D
H   H E     L     L     O   O       W W W O   O R R   L     D   D
H   H E     L     L     O   O       W W W O   O R  R  L     D   D
H   H EEEEE LLLLL LLLLL  OOO         W W   OOO  R   R LLLLL DDDD
As most of the characters can be printed in many different ways (think of Q, F or W), here is what they're expected to look like:

 AAA  BBBB   CCC  DDDD  EEEEE FFFFF  GGG  H   H IIIII JJJJJ K   K L     M   M N   N  OOO  PPPP   QQQ  RRRR   SSS  TTTTT U   U V   V W   W X   X Y   Y ZZZZZ
A   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     MM MM NN  N O   O P   P Q   Q R   R S   S   T   U   U V   V W   W X   X Y   Y     Z
A   A B   B C     D   D E     F     G     H   H   I       J K K   L     M M M N   N O   O P   P Q   Q R   R S       T   U   U V   V W   W  X X   Y Y     Z
AAAAA BBBB  C     D   D EEEEE FFFFF G GGG HHHHH   I       J KK    L     M   M N N N O   O PPPP  Q   Q RRRR   SSS    T   U   U V   V W W W   X     Y     Z
A   A B   B C     D   D E     F     G   G H   H   I       J K K   L     M   M N   N O   O P     Q Q Q R R       S   T   U   U V   V W W W  X X    Y    Z
A   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     M   M N  NN O   O P     Q  QQ R  R  S   S   T   U   U  V V  W W W X   X   Y   Z
A   A BBBB   CCC  DDDD  EEEEE F      GGG  H   H IIIII JJJJ  K   K LLLLL M   M N   N  OOO  P      QQQQ R   R  SSS    T    UUU    V    W W  X   X   Y   ZZZZZ
 */
public class CW40_BlockLetterPrinter {
    public static void main(String[] args) {
        System.out.println(blockPrint("heLLo WorLD"));
    }

    private static String blockPrint(String string) {

        string = string.trim();

        if (string.isEmpty()) return "";

        String[][] array = new String[string.length()][7];

        for (int i = 0; i < string.length(); i++) {
            array[i] = letters(string.toUpperCase().charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (String[] strings : array) {
                result.append(strings[i]).append(" ");
            }
            while (result.charAt(result.length() - 1) == ' ') {
                result.deleteCharAt(result.length() - 1);
            }
            result.append("\n");
        }

        if (!result.isEmpty() && result.charAt(result.length() - 1) == '\n') {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    private static String[] letters(char ch) {

        HashMap<Character, String[]> alpha = new HashMap<>();

        alpha.put('A', new String[]{
                " AAA ",
                "A   A",
                "A   A",
                "AAAAA",
                "A   A",
                "A   A",
                "A   A"
        });
        alpha.put('B', new String[]{
                "BBBB ",
                "B   B",
                "B   B",
                "BBBB ",
                "B   B",
                "B   B",
                "BBBB "
        });
        alpha.put('C', new String[]{
                " CCC ",
                "C   C",
                "C    ",
                "C    ",
                "C    ",
                "C   C",
                " CCC "
        });
        alpha.put('D', new String[]{
                "DDDD ",
                "D   D",
                "D   D",
                "D   D",
                "D   D",
                "D   D",
                "DDDD "
        });
        alpha.put('E', new String[]{
                "EEEEE",
                "E    ",
                "E    ",
                "EEEEE",
                "E    ",
                "E    ",
                "EEEEE"
        });

        alpha.put('F', new String[]{
                "FFFFF",
                "F    ",
                "F    ",
                "FFFFF",
                "F    ",
                "F    ",
                "F    "
        });
        alpha.put('G', new String[]{
                " GGG ",
                "G   G",
                "G    ",
                "G GGG",
                "G   G",
                "G   G",
                " GGG "
        });
        alpha.put('H', new String[]{
                "H   H",
                "H   H",
                "H   H",
                "HHHHH",
                "H   H",
                "H   H",
                "H   H"
        });
        alpha.put('I', new String[]{
                "IIIII",
                "  I  ",
                "  I  ",
                "  I  ",
                "  I  ",
                "  I  ",
                "IIIII"
        });
        alpha.put('J', new String[]{
                "JJJJJ",
                "    J",
                "    J",
                "    J",
                "    J",
                "    J",
                "JJJJ "
        });
        alpha.put('K', new String[]{
                "K   K",
                "K  K ",
                "K K  ",
                "KK   ",
                "K K  ",
                "K  K ",
                "K   K"
        });
        alpha.put('L', new String[]{
                "L    ",
                "L    ",
                "L    ",
                "L    ",
                "L    ",
                "L    ",
                "LLLLL"
        });
        alpha.put('M', new String[]{
                "M   M",
                "MM MM",
                "M M M",
                "M   M",
                "M   M",
                "M   M",
                "M   M"
        });
        alpha.put('N', new String[]{
                "N   N",
                "NN  N",
                "N   N",
                "N N N",
                "N   N",
                "N  NN",
                "N   N"
        });
        alpha.put('O', new String[]{
                " OOO ",
                "O   O",
                "O   O",
                "O   O",
                "O   O",
                "O   O",
                " OOO "
        });
        alpha.put('P', new String[]{
                "PPPP ",
                "P   P",
                "P   P",
                "PPPP ",
                "P    ",
                "P    ",
                "P    "
        });
        alpha.put('Q', new String[]{
                " QQQ ",
                "Q   Q",
                "Q   Q",
                "Q   Q",
                "Q Q Q",
                "Q  QQ",
                " QQQQ"
        });
        alpha.put('R', new String[]{
                "RRRR ",
                "R   R",
                "R   R",
                "RRRR ",
                "R R  ",
                "R  R ",
                "R   R"
        });
        alpha.put('S', new String[]{
                " SSS ",
                "S   S",
                "S    ",
                " SSS ",
                "    S",
                "S   S",
                " SSS "
        });
        alpha.put('T', new String[]{
                "TTTTT",
                "  T  ",
                "  T  ",
                "  T  ",
                "  T  ",
                "  T  ",
                "  T  "
        });
        alpha.put('U', new String[]{
                "U   U",
                "U   U",
                "U   U",
                "U   U",
                "U   U",
                "U   U",
                " UUU "
        });
        alpha.put('V', new String[]{
                "V   V",
                "V   V",
                "V   V",
                "V   V",
                "V   V",
                " V V ",
                "  V  "
        });
        alpha.put('W', new String[]{
                "W   W",
                "W   W",
                "W   W",
                "W W W",
                "W W W",
                "W W W",
                " W W "
        });
        alpha.put('X', new String[]{
                "X   X",
                "X   X",
                " X X ",
                "  X  ",
                " X X ",
                "X   X",
                "X   X"
        });
        alpha.put('Y', new String[]{
                "Y   Y",
                "Y   Y",
                " Y Y ",
                "  Y  ",
                "  Y  ",
                "  Y  ",
                "  Y  "
        });
        alpha.put('Z', new String[]{
                "ZZZZZ",
                "    Z",
                "   Z ",
                "  Z  ",
                " Z   ",
                "Z    ",
                "ZZZZZ"
        });

        alpha.put(' ', new String[]{
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     "
        });

        return alpha.get(ch);
    }

    /* LetMeeDie:

    public static String blockPrint(String s){
        s=s.toUpperCase().trim(); if(s.isEmpty())return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<7;i++){
            if(!sb.isEmpty())sb.append("\n");
            for(char c : s.toCharArray()){
                if(c!=' '){
                    int j = F[y[c-'A']].indexOf(c);
                    sb.append(F[i].substring(j,j+6));

                }
                else sb.append("      ");
            }
            while(sb.charAt(sb.length()-1)==' ')sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    static String [] F = {
            " AAA  BBBB   CCC  DDDD  EEEEE FFFFF  GGG  H   H IIIII JJJJJ K   K L     M   M N   N  OOO  PPPP   QQQ  RRRR   SSS  TTTTT U   U V   V W   W X   X Y   Y ZZZZZ ",
            "A   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     MM MM NN  N O   O P   P Q   Q R   R S   S   T   U   U V   V W   W X   X Y   Y     Z ",
            "A   A B   B C     D   D E     F     G     H   H   I       J K K   L     M M M N   N O   O P   P Q   Q R   R S       T   U   U V   V W   W  X X   Y Y     Z  ",
            "AAAAA BBBB  C     D   D EEEEE FFFFF G GGG HHHHH   I       J KK    L     M   M N N N O   O PPPP  Q   Q RRRR   SSS    T   U   U V   V W W W   X     Y     Z   ",
            "A   A B   B C     D   D E     F     G   G H   H   I       J K K   L     M   M N   N O   O P     Q Q Q R R       S   T   U   U V   V W W W  X X    Y    Z    ",
            "A   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     M   M N  NN O   O P     Q  QQ R  R  S   S   T   U   U  V V  W W W X   X   Y   Z     ",
            "A   A BBBB   CCC  DDDD  EEEEE F      GGG  H   H IIIII JJJJ  K   K LLLLL M   M N   N  OOO  P      QQQQ R   R  SSS    T    UUU    V    W W  X   X   Y   ZZZZZ "
    };
    static int[] y = {1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0}; // yani indexOf() kullanilan yerde A icin F[1]'e bak, I icin F[0]'a bak
     */
}

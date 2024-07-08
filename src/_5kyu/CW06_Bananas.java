package _5kyu;

import java.util.HashSet;
import java.util.Set;

/*
> "What is your name" said Tim.
"My name" said the mouse "Is Dinglemouse".

> "What were you before the witch turned you into a mouse" said Rose.
"I was a banana" said Dingle the mouse, "So be careful. If you see her, run away!".
- Badjelly the Witch (12:32), Spike Milligan

Kata Task
Given a string of letters a, b, n how many different ways can you make the word
"banana" by crossing out various letters and then reading left-to-right?

(Use - to indicate a crossed-out letter)

Example
Input
bbananana

Output
b-anana--
b-anan--a
b-ana--na
b-an--ana
b-a--nana
b---anana
-banana--
-banan--a
-bana--na
-ban--ana
-ba--nana
-b--anana

Notes
You must return all possible bananas, but the order does not matter
The example output above is formatted for readability. Please refer to the example tests for expected format of your result.
 */
public class CW06_Bananas {
    public static void main(String[] args) {
        bananas("bbananana").forEach(System.out::println);
    }

    private static Set<String> bananas(final String s) {

        Set<String> result = new HashSet<>();

        for (int i = 0; i < s.length() - 5; i++) {
            for (int j = i + 1; j < s.length() - 4; j++) {
                for (int k = j + 1; k < s.length() - 3; k++) {
                    for (int l = k + 1; l < s.length() - 2; l++) {
                        for (int m = l + 1; m < s.length() - 1; m++) {
                            for (int n = m + 1; n < s.length(); n++) {
                                if ("banana".equals("" + s.charAt(i) + s.charAt(j) + s.charAt(k) + s.charAt(l) + s.charAt(m) + s.charAt(n))) {
                                    StringBuilder temp = new StringBuilder("-".repeat(s.length()));
                                    temp.replace(i, i + 1, "b");
                                    temp.replace(j, j + 1, "a");
                                    temp.replace(k, k + 1, "n");
                                    temp.replace(l, l + 1, "a");
                                    temp.replace(m, m + 1, "n");
                                    temp.replace(n, n + 1, "a");
                                    result.add(temp.toString());
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;


        // Frederickmbw, rostyslav.ludchenko, 6ALLIKA, TheHermit, EmilLubomirov, Okenov-Nursen:
//        Set<String> set = new HashSet<String>();
//        bananas(s, set, 0);
//        return set;
    }

    private static void bananas(String str, Set<String> set, int index) {
        if (str.replace("-", "").equals("banana")) {
            set.add(str);
        } else if (index < str.length() && str.replace("-", "").length() > 6) {
            bananas(str, set, index + 1);
            bananas(str.substring(0, index) + "-" + str.substring(index + 1), set, index + 1);
        }
    }
}

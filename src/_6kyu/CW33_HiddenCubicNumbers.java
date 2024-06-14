package _6kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
We search non-negative integer numbers, with at most 3 digits, such as the sum of the cubes of their digits
is the number itself; we will call them "cubic" numbers.

153 is such a "cubic" number : 1^3 + 5^3 + 3^3 = 153
These "cubic" numbers of at most 3 digits are easy to find, even by hand, so they are "hidden"
with other numbers and characters in a string.

The task is to find, or not, the "cubic" numbers in the string and then to make the sum of
these "cubic" numbers found in the string, if any, and to return a string such as:

"number1 number2 (and so on if necessary) sumOfCubicNumbers Lucky"
if "cubic" numbers number1, number2, ... were found.

The numbers in the output are to be in the order in which they are encountered in the input string.

If no cubic numbers are found return the string: `"Unlucky"``.

Examples:
 - s = "aqdf&0#1xyz!22[153(777.777"
   the groups of at most 3 digits are 0 and 1 (one digit), 22 (two digits), 153, 777, 777 (3 digits)
   Only 0, 1, 153 are cubic and their sum is 154
   Return: "0 1 153 154 Lucky"

- s = "QK29a45[&erui9026315"
  the groups are 29, 45, 902, 631, 5. None is cubic.
  Return: "Unlucky"

Notes
In the string "001234" where 3 digits or more follow each other the first group to examine is "001" and the following
is "234". If a packet of at most three digits has been taken, whether or not "cubic", it's over for that packet.

When a continuous string of digits exceeds 3, the string is split into groups of 3 from the left.
The last grouping could have 3, 2 or 1 digits.

e.g "24172410" becomes 3 strings comprising "241", "724" and "10"

e.g "0785" becomes 2 strings comprising "078" and "5".
 */
public class CW33_HiddenCubicNumbers {
    public static void main(String[] args) {
        System.out.println(isSumOfCubes("aqdf&0#1xyz!22[153(777.777"));
    }

    /**
     * Finds cubic numbers in the given string and returns a formatted result.
     *
     * @param s Input string containing potential cubic numbers.
     * @return A formatted string with found cubic numbers and their sum or "Unlucky" if none found.
     */
    private static String isSumOfCubes(String s) {

        List<String> numberGroups = extractNumberGroups(s);

        List<Integer> cubics = numberGroups.stream().filter(CW33_HiddenCubicNumbers::isCubic).map(Integer::valueOf).toList();

        if (!cubics.isEmpty()) {
            String cubicsStr = cubics.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            int sum = cubics.stream().mapToInt(Integer::intValue).sum();
            return cubicsStr + " " + sum + " Lucky";
        } else {
            return "Unlucky";
        }
    }

    /**
     * Extracts all digit groups from the given string, with each group having at most 3 digits.
     *
     * @param s Input string to extract digit groups from.
     * @return A list of digit groups.
     */
    public static List<String> extractNumberGroups(String s) {
        List<String> numberGroups = new ArrayList<>();
        String[] numbers = s.replaceAll("[^0-9]", " ").trim().split("\\s+");

        for (String number : numbers) {
            for (int i = 0; i < number.length(); i += 3) {
                numberGroups.add(number.substring(i, Math.min(i + 3, number.length())));
            }
        }

        return numberGroups;
    }

    /**
     * Checks if the given number is a cubic number, i.e., the sum of the cubes of its digits equals the number itself.
     *
     * @param n The number to check.
     * @return True if the number is cubic, otherwise false.
     */
    private static boolean isCubic(String n) {
        return Arrays.stream(n.split(""))
                .mapToInt(Integer::parseInt)
                .map(t -> t * t * t)
                .sum()
                ==
                Integer.parseInt(n);
    }
}

package _5kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Write a function nico/nico() that accepts two parameters:
 - key/$key - string consists of unique letters and digits
 - message/$message - string to encode
and encodes the message using the key.

First create a numeric key basing on a provided key by assigning each letter position in which
it is located after setting the letters from key in an alphabetical order.

For example, for the key crazy we will get 23154 because of acryz (sorted letters from the key).
Let's encode secretinformation using our crazy key.
2 3 1 5 4
---------
s e c r e
t i n f o
r m a t i
o n

After using the key:
1 2 3 4 5
---------
c s e e r
n t i o f
a r m i t
  o n

Examples
nico("crazy", "secretinformation") => "cseerntiofarmit on  "
nico("abc", "abcd") => "abcd  "
nico("ba", "1234567890") => "2143658709"
nico("key", "key") => "eky"
 */
public class CW51_BasicNicoVariation {
    public static void main(String[] args) {
        System.out.println(nico("crazy", "secretinformation")); // cseerntiofarmit on
        System.out.println(nico("abc", "abcd")); // abcd
        System.out.println(nico("ba", "1234567890")); // 2143658709
        System.out.println(nico("key", "key")); // eky
    }

    public static String nico(String key, String message) {
        String sortedKey = Arrays.stream(key.split("")).sorted().collect(Collectors.joining());
        int[] keyOrder = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyOrder[i] = sortedKey.indexOf(key.charAt(i));
        }

        int numRows = (int) Math.ceil((double) message.length() / key.length());
        char[][] messageGrid = new char[numRows][key.length()];

        for (int i = 0; i < message.length(); i++) {
            int row = i / key.length();
            int col = i % key.length();
            messageGrid[row][col] = message.charAt(i);
        }

        for (int i = message.length(); i < numRows * key.length(); i++) {
            int row = i / key.length();
            int col = i % key.length();
            messageGrid[row][col] = ' ';
        }

        char[][] resultGrid = new char[numRows][key.length()];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < key.length(); col++) {
                resultGrid[row][keyOrder[col]] = messageGrid[row][col];
            }
        }

        return Arrays.stream(resultGrid).map(String::valueOf).collect(Collectors.joining());
    }
}

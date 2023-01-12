/*
Complete the solution so that it reverses all of the words within the string passed in.
Words are separated by exactly one space and there are no leading or trailing spaces.

Example(Input --> Output):
"The greatest victory is that which requires no battle" --> "battle no requires which that is victory greatest The"

 */
public class CW08_ReversedWords {
    public static void main(String[] args) {
        String str = "The greatest victory is that which requires no battle";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String str) {
        String[] arr = str.split(" ");
        String strReverse = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            strReverse += arr[i] + " ";
        }
        return strReverse.substring(0, strReverse.length() - 1);
    }
}

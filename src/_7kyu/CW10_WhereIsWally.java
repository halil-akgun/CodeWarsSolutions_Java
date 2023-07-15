package _7kyu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Write a function that returns the index of the first occurence of the word "Wally". "Wally" must not be
part of another word, but it can be directly followed by a punctuation mark. If no such "Wally" exists, return -1.

Examples:
"Wally" => 0
"Where's Wally" => 8
"Where's Waldo" => -1
"DWally Wallyd .Wally" => -1
"Hi Wally." => 3
"It's Wally's." => 5
"Wally Wally" => 0
"'Wally Wally" => 7
 */
public class CW10_WhereIsWally {
    public static void main(String[] args) {
        System.out.println(wheresWally("Wally DWally Wallyd . Wally."));
    }

    public static int wheresWally(String str) {
        StringBuilder sb = new StringBuilder(str.replaceAll("Wally(?=[\\p{Punct}])", "Wally "));
        sb.insert(0, " ").append(" ").append(" ");
        return sb.indexOf(" Wally ");

//        Klemsus, JasonLan999, tian, ChungGor, EmilLubomirov, Kiril_Valkov, goshoKukata69, Tar0ux and Nikhil1901's solution:
//        Matcher m = Pattern.compile(" Wally\\b").matcher(" " + str);
//        return m.find() ? m.start() : -1;
    }
}

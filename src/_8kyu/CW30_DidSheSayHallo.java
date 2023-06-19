package _8kyu;

import java.util.ArrayList;
import java.util.List;

/*
You received a whatsup message from an unknown number. Could it be from that girl/boy with a foreign accent you met yesterday evening?
Write a simple function to check if the string contains the word hallo in different languages.
These are the languages of the possible people you met the night before:
hello - english
ciao - italian
salut - french
hallo - german
hola - spanish
ahoj - czech republic
czesc - polish

Notes
you can assume the input is a string.
to keep this a beginner exercise you don't need to check if the greeting is a subset of word (Hallowen can pass the test)
function should be case insensitive to pass the tests
 */
public class CW30_DidSheSayHallo {
    public static void main(String[] args) {
        System.out.println(validateHello("....hello"));
    }

    public static boolean validateHello(String greetings) {
        List<String> helloList = new ArrayList<>(List.of("hello", "ciao", "salut", "hallo", "hola", "hola", "ahoj", "czesc"));
        for (String w : helloList) {
            if (greetings.toLowerCase().contains(w)) return true;
        }
        return false;
    }
}

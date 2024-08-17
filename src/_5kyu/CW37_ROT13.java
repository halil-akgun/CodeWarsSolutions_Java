package _5kyu;

/*
How can you tell an extrovert from an introvert at NSA?
Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.

I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it?
According to Wikipedia, ROT13 is frequently used to obfuscate jokes on USENET.

For this task you're only supposed to substitute characters. Not spaces, punctuation, numbers, etc.

Test examples:
"EBG13 rknzcyr." -> "ROT13 example."
"This is my first ROT13 excercise!" -> "Guvf vf zl svefg EBG13 rkprepvfr!"
 */
public class CW37_ROT13 {
    public static void main(String[] args) {
        System.out.println(rot13("EBG13 rknzcyr.")); // ROT13 example.
        System.out.println(rot13("This is my first ROT13 excercise!")); // Guvf vf zl svefg EBG13 rkprepvfr!
    }

    public static String rot13(String message) {
        return message.chars().map(t ->
//                Character.isAlphabetic(t)
                ((t >= 'A' && t <= 'Z') || (t >= 'a' && t <= 'z')) // only english letters
                        ? Character.isUpperCase(t)
                        ? 'A' + ((13 + (t - 'A')) % 26)
                        : 'a' + ((13 + (t - 'a')) % 26)
                        : t).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();


        // HarveyCy:
//        return message.chars()
//                .mapToObj(c -> String.valueOf((char) ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M') ? c + 13 :
//                        (c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z') ? c - 13 : c)))
//                .collect(java.util.stream.Collectors.joining());
    }
}

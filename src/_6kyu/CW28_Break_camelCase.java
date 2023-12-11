package _6kyu;

/*
Complete the solution so that the function will break up camel casing, using a space between words.

Example
"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""
 */
public class CW28_Break_camelCase {
    public static void main(String[] args) {
        System.out.println(camelCase("camelCasing"));
    }

    public static String camelCase(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') result.append(" ");
            result.append(input.charAt(i));
        }
        return result.toString();

        // Firefly2002, rajeshkalakoti, illya.pauchenko, Afanasii1337, MrDoge1337, Vad008, DubininAndrey, lwuah36215gs, FreddYKol, erbolcods (+ 4):
//        return input.replaceAll("([A-Z])", " $1");
    }
}

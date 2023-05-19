/*
Make a function that will return a greeting statement that uses an input;
your program should return,
"Hello, <name> how are you doing today?".
 */
public class CW44_ReturningStrings {
    public static void main(String[] args) {
        System.out.println(greet("GUL"));
    }

    public static String greet(String name) {
        return  "Hello, " + name + " how are you doing today?";

//        return String.format("Hello, %s how are you doing today?", name);
    }
}

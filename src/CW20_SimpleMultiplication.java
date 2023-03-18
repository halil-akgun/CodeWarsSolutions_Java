/*
This kata is about multiplying a given number by eight if it is an even number and by nine otherwise.
 */
public class CW20_SimpleMultiplication {
    public static void main(String[] args) {
        System.out.println(simpleMultiplication(27));
    }

    public static int simpleMultiplication(int n) {
        return n * (n % 2 + 8);
    }
}

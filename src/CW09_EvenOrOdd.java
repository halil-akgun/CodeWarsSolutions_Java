/*
Create a function that takes an integer as an argument and returns "Even" for even numbers or "Odd" for odd numbers.
 */
public class CW09_EvenOrOdd {
    public static void main(String[] args) {
        System.out.println(even_or_odd(3));
    }
    public static String even_or_odd(int number) {
        if (number%2==0) return "Even";
        return "Odd";
    }
}

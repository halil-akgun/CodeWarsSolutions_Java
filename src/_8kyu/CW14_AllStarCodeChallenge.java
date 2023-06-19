package _8kyu;

/*
Create a function that accepts a string and a single character, and returns an integer of the count of occurrences
the 2nd argument is found in the first one.
If no occurrences can be found, a count of 0 should be returned.

("Hello", "o")  ==>  1
("Hello", "l")  ==>  2
("", "z")       ==>  0
 */
public class CW14_AllStarCodeChallenge {
    public static void main(String[] args) {
        System.out.println(strCount("Hello", 'o'));
    }

    public static int strCount(String str, char letter) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == letter) counter++;
        }
        return counter;

        // return (int)str.chars().filter(x -> x == letter).count();
    }
}

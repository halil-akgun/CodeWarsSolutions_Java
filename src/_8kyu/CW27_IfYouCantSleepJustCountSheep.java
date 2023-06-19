package _8kyu;

/*
Task:
Given a non-negative integer, 3 for example, return a string with a murmur: "1 sheep...2 sheep...3 sheep...".
Input will always be valid, i.e. no negative integers.
 */
public class CW27_IfYouCantSleepJustCountSheep {
    public static void main(String[] args) {
        System.out.println(countingSheep(3));
    }

    public static String countingSheep(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append((i + 1)).append(" sheep...");
        }
        return result.toString();
    }
}

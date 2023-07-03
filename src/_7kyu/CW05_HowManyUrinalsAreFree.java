package _7kyu;

/*
In men's public toilets with urinals, there is this unwritten rule that you leave at least one
urinal free between you and the next person peeing. For example if there are 3 urinals and one
person is already peeing in the left one, you will choose the urinal on the right and not the
one in the middle. That means that a maximum of 3 people can pee at the same time on public
toilets with 5 urinals when following this rule (Only 2 if the first person pees into urinal 2 or 4).
https://i.imgur.com/imZE6xm.png
Your task:
You need to write a function that returns the maximum of free urinals as an integer according to the unwritten rule.

Input
A String containing 1s and 0s (Example: 10001) (1 <= Length <= 20)
A one stands for a taken urinal and a zero for a free one.

Examples
10001 returns 1 (10101)
1001 returns 0 (1001)
00000 returns 3 (10101)
0000 returns 2 (1001)
01000 returns 1 (01010 or 01001)

Note
When there is already a mistake in the input string (for example 011), then return -1
 */
public class CW05_HowManyUrinalsAreFree {
    public static void main(String[] args) {
        System.out.println(getFreeUrinals("10001"));
    }

    public static int getFreeUrinals(String urinals) {
        StringBuilder temp = new StringBuilder(urinals);
        if (urinals.length() == 1) {
            if (urinals.charAt(0) == '0') return 1;
            else return 0;
        }
        int count = 0;
        for (int i = 0; i < urinals.length(); i++) {
            if (i == 0) {
                if (temp.charAt(0) != '1' && temp.charAt(1) != '1') {
                    temp.replace(0, 1, "1");
                    count++;
                } else if ((temp.charAt(i) == '1' && temp.charAt(i + 1) == '1')) {
                    return -1;
                }
            } else if (i == urinals.length() - 1) {
                if (temp.charAt(i - 1) != '1' && temp.charAt(i) != '1') {
                    temp.replace(i, i + 1, "1");
                    count++;
                } else if ((temp.charAt(i - 1) == '1' && temp.charAt(i) == '1')) {
                    return -1;
                }
            } else {
                if (temp.charAt(i - 1) != '1' && temp.charAt(i) != '1' && temp.charAt(i + 1) != '1') {
                    temp.replace(i, i + 1, "1");
                    count++;
                } else if ((temp.charAt(i - 1) == '1' && temp.charAt(i) == '1') || (temp.charAt(i) == '1' && temp.charAt(i + 1) == '1')) {
                    return -1;
                }
            }
        }
        return count;

//        ParanoidUser and theofilvaliant's solution:
//        return urinals.contains("11") ? -1 : urinals.replaceAll("010|10|01", "1").replace("00", "0").replace("1", "").length();
    }
}

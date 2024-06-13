package _6kyu;

/*
Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James.
Since James doesn't know how to make this happen, he needs your help.

Task
You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters.
Trailing spaces should be removed, and every line must be terminated with a newline character (\n).

Return null/nil/None/... if the input is an even number or negative, as it is not possible to print a diamond of even or negative size.

Examples
A size 3 diamond:
 *
***
 *
...which would appear as a string of " *\n***\n *\n"

A size 5 diamond:
  *
 ***
*****
 ***
  *

...that is:
"  *\n ***\n*****\n ***\n  *\n"
 */
public class CW32_GiveMeADiamond {
    public static void main(String[] args) {
        System.out.println(print(5));
    }

    public static String print(int n) {

        if (n <= 0 || n % 2 == 0) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        int space = n / 2;
        int star = 1;

        for (int i = 0; i < n / 2 + 1; i++) {
            result.append(" ".repeat(space--)).append("*".repeat(star)).append("\n");
            star += 2;
        }

        space = 1;
        star -= 4;

        for (int i = 0; i < n / 2; i++) {
            result.append(" ".repeat(space++)).append("*".repeat(star)).append("\n");
            star -= 2;
        }

        return result.toString();
    }
}

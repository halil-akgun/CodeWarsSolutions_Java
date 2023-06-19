package _8kyu;

/*
The first century spans from the year 1 up to and including the year 100, the second century - from the year 101 up to and including the year 200, etc.

Task
Given a year, return the century it is in.

Examples
1705 --> 18
1900 --> 19
1601 --> 17
2000 --> 20
 */
public class CW13_CenturyFromYear {
    public static void main(String[] args) {
        System.out.println(century(2000));
    }

    public static int century(int number) {
        if (number < 101) return 1;
        else if (number % 100 == 0) return number / 100;
        else return (number / 100) + 1;
    }
}

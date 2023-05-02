import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
In this kata, we will make a function to test whether a period is late.

Our function will take three parameters:

last - The Date object with the date of the last period
today - The Date object with the date of the check
cycleLength - Integer representing the length of the cycle in days

Return true if the number of days passed from last to today is greater than cycleLength. Otherwise, return false.
 */
public class CW34_IsYourPeriodLate {
    public static void main(String[] args) {
        LocalDate last = LocalDate.of(2016, 6, 13);
        LocalDate today = LocalDate.of(2016, 7, 16);
        int cycleLength = 28; // 28 => true,  35 => false
        System.out.println(periodIsLate(last, today, cycleLength));
    }

    public static boolean periodIsLate(LocalDate last, LocalDate today, int cycleLength) {
        return ChronoUnit.DAYS.between(last, today) > cycleLength;
    }
}

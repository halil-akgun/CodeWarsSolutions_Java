package _6kyu;

import java.time.LocalTime;
import java.util.Arrays;

/*
Given two times in hours, minutes, and seconds (ie '15:04:24'), add or subtract them.
This is a 24 hour clock. Output should be two digits for all numbers: hours, minutes, seconds (ie '04:02:09').

timeMath('01:24:31', '+', '02:16:05') === '03:40:36'
timeMath('01:24:31', '-', '02:31:41') === '22:52:50'
 */
public class CW48_TimeMath {
    public static void main(String[] args) {
        System.out.println(timeMath("01:24:31", "+", "02:16:05"));
        System.out.println(timeMath("01:24:31", "-", "02:31:41"));
        System.out.println(timeMath("01:24:31", "-", "01:24:32"));
        System.out.println(timeMath("24:24:31", "+", "00:35:29"));
        System.out.println(timeMath("23:24:31", "+", "00:35:28"));
    }

    public static String timeMath(final String time1, final String op, final String time2) {

        int[] time1Arr = Arrays.stream(time1.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] time2Arr = Arrays.stream(time2.split(":")).mapToInt(Integer::parseInt).toArray();

        LocalTime localTime1 = LocalTime.of(time1Arr[0] % 24, time1Arr[1] % 60, time1Arr[2] % 60);
        LocalTime localTime2 = LocalTime.of(time2Arr[0] % 24, time2Arr[1] % 60, time2Arr[2] % 60);

        LocalTime result = op.equals("+")
                ? localTime1.plusHours(localTime2.getHour()).plusMinutes(localTime2.getMinute()).plusSeconds(localTime2.getSecond())
                : localTime1.minusHours(localTime2.getHour()).minusMinutes(localTime2.getMinute()).minusSeconds(localTime2.getSecond());

        return String.format("%02d:%02d:%02d", result.getHour(), result.getMinute(), result.getSecond());
    }
}

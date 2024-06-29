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

/*
        // way 1 (randomTests is failing)
        int[] time1Arr = Arrays.stream(time1.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] time2Arr = Arrays.stream(time2.split(":")).mapToInt(Integer::parseInt).toArray();

        LocalTime localTime1 = LocalTime.of(time1Arr[0] % 24, time1Arr[1] % 60, time1Arr[2] % 60);
        LocalTime localTime2 = LocalTime.of(time2Arr[0] % 24, time2Arr[1] % 60, time2Arr[2] % 60);

        LocalTime result = op.equals("+")
                ? localTime1.plusHours(localTime2.getHour()).plusMinutes(localTime2.getMinute()).plusSeconds(localTime2.getSecond())
                : localTime1.minusHours(localTime2.getHour()).minusMinutes(localTime2.getMinute()).minusSeconds(localTime2.getSecond());

        return String.format("%02d:%02d:%02d", result.getHour(), result.getMinute(), result.getSecond());
*/

        // way 2
        int[] time1Arr = Arrays.stream(time1.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] time2Arr = Arrays.stream(time2.split(":")).mapToInt(Integer::parseInt).toArray();

        if (op.equals("+")) {
            return addTime(time1Arr, time2Arr);
        } else {
            return subtractTime(time1Arr, time2Arr);
        }
    }

    private static String addTime(int[] time1Arr, int[] time2Arr) {
        boolean add = false;
        int[] result = new int[3];
        int seconds = time1Arr[2] + time2Arr[2];
        if (seconds >= 60) {
            seconds -= 60;
            add = true;
        }
        int minutes = time1Arr[1] + time2Arr[1] + (add ? 1 : 0);
        add = false;
        if (minutes >= 60) {
            minutes -= 60;
            add = true;
        }
        int hours = time1Arr[0] + time2Arr[0] + (add ? 1 : 0);
        if (hours >= 24) {
            hours -= 24;
        }
        result[0] = hours;
        result[1] = minutes;
        result[2] = seconds;
        return String.format("%02d:%02d:%02d", result[0], result[1], result[2]);
    }

    private static String subtractTime(int[] time1Arr, int[] time2Arr) {
        boolean subtract = false;
        int[] result = new int[3];
        int seconds = time1Arr[2] - time2Arr[2];
        if (seconds < 0) {
            seconds += 60;
            subtract = true;
        }
        int minutes = time1Arr[1] - time2Arr[1] - (subtract ? 1 : 0);
        subtract = false;
        if (minutes < 0) {
            minutes += 60;
            subtract = true;
        }
        int hours = time1Arr[0] - time2Arr[0] - (subtract ? 1 : 0);
        if (hours < 0) {
            hours += 24;
        }
        result[0] = hours;
        result[1] = minutes;
        result[2] = seconds;
        return String.format("%02d:%02d:%02d", result[0], result[1], result[2]);
    }

    // allexva's solution:
    public static String timeMath2(final String time1, final String op, final String time2) {
        int sec1 = split(time1);
        int sec2 = split(time2);

        int result = 0;
        switch (op) {
            case "+":
                result = (sec1 + sec2) % (60 * 60 * 24);
                break;
            case "-":
                result = (sec1 - sec2) % (60 * 60 * 24);
                if (result < 0) result += 86400;
                break;
        }

        int hour = result / 3600 % 24;
        int minute = (result % 3600) / 60;
        int sec = result % 60;

        return String.format("%02d:%02d:%02d", hour, minute, sec);
    }

    public static int split(String time) {
        String[] array = time.split(":");
        return (Integer.parseInt(array[0]) * 60 * 60
                + Integer.parseInt(array[1]) * 60
                + Integer.parseInt(array[2])) % (24 * 60 * 60);
    }
}

package _5kyu;

/*
Write a function, which takes a non-negative integer (seconds) as input
and returns the time in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)
 */
public class CW31_HumanReadableTime {
    public static void main(String[] args) {
        System.out.println(makeReadable(0)); // "00:00:00"
        System.out.println(makeReadable(5)); // "00:00:05"
        System.out.println(makeReadable(60)); // "00:01:00"
        System.out.println(makeReadable(86399)); // "23:59:59"
        System.out.println(makeReadable(359999)); // "99:59:59"
    }

    public static String makeReadable(int seconds) {
//        int hour = seconds / 60 / 60;
//        int minute = (seconds / 60) % 60;
//        int second = seconds % 60;
//
//        return String.format("%02d:%02d:%02d", hour, minute, second);

        return String.format("%02d:%02d:%02d", seconds / 60 / 60, (seconds / 60) % 60, seconds % 60);
    }
}

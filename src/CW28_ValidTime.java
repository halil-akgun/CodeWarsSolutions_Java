/*
Check if the given string is a correct time representation of the 24-hour clock.

Example
For time = "13:58", the output should be
solution(time) = true;
For time = "25:51", the output should be
solution(time) = false;
For time = "02:76", the output should be
solution(time) = false.
 */
public class CW28_ValidTime {
    public static void main(String[] args) {
        String time = "13:58";
        System.out.println(solution(time));
    }

    static boolean solution(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) >= 0 && Integer.parseInt(arr[0]) <= 23 &&
                Integer.parseInt(arr[1]) >= 0 && Integer.parseInt(arr[1]) <= 59;
    }
}

package _8kyu;

import java.util.HashMap;

/*
Here is a piece of code:
public class Kata {
    public static HashMap <String, String> getStatus(boolean isBusy) {
        HashMap<String, String> status;
        if (isBusy) {
          status = "busy";
        } else {
          status = "available";
        }
        return status;
    }
}
Expected Behaviour
Function should return a dictionary/Object/Hash with "status" as a key, whose value can : "busy" or "available" depending on the truth value of the argument is_busy.
But as you will see after clicking RUN or ATTEMPT this code has several bugs, please fix them.
 */
public class CW15_UnexpectedParsing {
    public static void main(String[] args) {
        System.out.println(getStatus(true));
    }

    public static HashMap<String, String> getStatus(boolean isBusy) {

        HashMap<String, String> status = new HashMap<>();

        if (isBusy) {
            status.put("status", "busy");
        } else {
            status.put("status", "available");
        }
        return status;
    }
}
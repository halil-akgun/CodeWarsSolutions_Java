package _5kyu;

import java.util.Arrays;

/*
Implement a function that receives two IPv4 addresses, and returns the number of addresses between
them (including the first one, excluding the last one).

All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the first one.

Examples
* With input "10.0.0.0", "10.0.0.50"  => return   50
* With input "10.0.0.0", "10.0.1.0"   => return  256
* With input "20.0.0.10", "20.0.1.0"  => return  246
 */
public class CW03_CountIPAddresses {
    public static void main(String[] args) {
        System.out.println(ipsBetween("10.0.0.0", "10.0.0.50")); // 50
        System.out.println(ipsBetween("10.0.0.0", "10.0.1.0")); // 256
        System.out.println(ipsBetween("20.0.0.10", "20.0.1.0")); // 246
    }

    public static long ipsBetween(String start, String end) {
        int[] startArr = Arrays.stream(start.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] endArr = Arrays.stream(end.split("\\.")).mapToInt(Integer::parseInt).toArray();

        long startValue = (long) startArr[0] * 256 * 256 * 256 + (long) startArr[1] * 256 * 256 + startArr[2] * 256L + startArr[3];
        long endValue = (long) endArr[0] * 256 * 256 * 256 + (long) endArr[1] * 256 * 256 + endArr[2] * 256L + endArr[3];
        return endValue - startValue;


        // Vendirg, NazarNeb, Derevyanchenko, Daniel DM, vztot, fruts, amit verma, Kajal tandon, sai raghavendra, Tirajiqta (+ 56):
//        return convertToLong(end) - convertToLong(start);
    }

    private static long convertToLong(String ip) {
        long res = 0;
        for (String s : ip.split("[.]"))
            res = res * 256 + Long.parseLong(s);
        return res;
    }
}

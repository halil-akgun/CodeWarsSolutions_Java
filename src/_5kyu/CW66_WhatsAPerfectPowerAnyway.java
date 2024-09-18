package _5kyu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
A perfect power is a classification of positive integers:
In mathematics, a perfect power is a positive integer that can be expressed as an integer power of another positive
integer. More formally, n is a perfect power if there exist natural numbers m > 1, and k > 1 such that mk = n.

Your task is to check wheter a given integer is a perfect power. If it is a perfect power, return a pair
m and k with mk = n as a proof. Otherwise return Nothing, Nil, null, NULL, None or your language's equivalent.

Note: For a perfect power, there might be several pairs. For example 81 = 3^4 = 9^2, so (3,4) and (9,2) are valid
solutions. However, the tests take care of this, so if a number is a perfect power, return any pair that proves it.

Examples
isPerfectPower(4) => new int[]{2,2}
isPerfectPower(5) => null
isPerfectPower(8) => new int[]{2,3}
isPerfectPower(9) => new int[]{3,2}
 */
public class CW66_WhatsAPerfectPowerAnyway {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(isPerfectPower(4))); // [2, 2]
        System.out.println(Arrays.toString(isPerfectPower(5))); // null
        System.out.println(Arrays.toString(isPerfectPower(8))); // [2, 3]
        System.out.println(Arrays.toString(isPerfectPower(9))); // [3, 2]
        System.out.println(Arrays.toString(isPerfectPower(100))); // [10, 2]
        System.out.println(Arrays.toString(isPerfectPower(144))); // [12, 2]
        System.out.println(Arrays.toString(isPerfectPower(914371407))); // null
    }

    public static int[] isPerfectPower(int n) {

        if (n <= 1) return null;

        Map<Integer, Integer> primeFactorCounts = new HashMap<>();

        int count = 0;

        while (n % 2 == 0) {
            count++;
            n /= 2;
        }

        if (count > 0) {
            primeFactorCounts.put(2, count);
            count = 0;
        }

        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                count++;
                n /= i;
            }
            if (count > 0) {
                primeFactorCounts.put(i, count);
                count = 0;
            }
        }

        int commonExponent = gcd(primeFactorCounts);

        if (commonExponent > 0 && n == 1) {
            int q = 1;
            for (Map.Entry<Integer, Integer> entry : primeFactorCounts.entrySet()) {
                q *= (int) Math.pow(entry.getKey(), (double) entry.getValue() / commonExponent);
            }
            return new int[]{q, commonExponent};
        } else {
            return null;
        }


        // pablo.varela, specialAccout, jadertao, WeebLordAnimoos, kickh, jessi_jr13, tarapeti, Derevyanchenko, trashlifetrashtoughts, Kuzmanov_Mario, IvanKotsovski (+ 12):
//        for (int i = 2; ; i++) {
//            int root = (int) Math.round(Math.pow(n, 1.0 / i));
//            if (root < 2) return null;
//            if (Math.pow(root, i) == n) return new int[]{root, i};
//        }
    }

    private static int gcd(Map<Integer, Integer> map) {
        int z = map.values().stream().mapToInt(Integer::intValue).min().orElse(0);
        for (int i = z; i >= 2; i--) {
            int finalI = i;
            if (map.values().stream().allMatch(x -> x % finalI == 0)) {
                return i;
            }
        }
        return 0;
    }
}

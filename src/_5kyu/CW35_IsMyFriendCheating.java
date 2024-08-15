package _5kyu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/*
A friend of mine takes the sequence of all numbers from 1 to n (where n > 0).
Within that sequence, he chooses two numbers, a and b.
He says that the product of a and b should be equal to the sum of all numbers in the sequence, excluding a and b.
Given a number n, could you tell me the numbers he excluded from the sequence?
The function takes the parameter: n (n is always strictly greater than 0) and
returns an array or a string (depending on the language) of the form:
[(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or or [{a, b}, ...]
with all (a, b) which are the possible removed numbers in the sequence 1 to n.

[(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or ... will be sorted in increasing order of the "a".

It happens that there are several possible (a, b). The function returns an empty array (or an empty string)
if no possible numbers are found which will prove that my friend has not told the truth! (Go: in this case return nil).

Examples:
removNb(26) should return [(15, 21), (21, 15)]
or
removNb(26) should return { {15, 21}, {21, 15} }
or
removeNb(26) should return [[15, 21], [21, 15]]
or
removNb(26) should return [ {15, 21}, {21, 15} ]
or
removNb(26) should return "15 21, 21 15"
 */
public class CW35_IsMyFriendCheating {
    public static void main(String[] args) {
//        removNb(26).forEach(x -> System.out.println(x[0] + " " + x[1])); // [15, 21], [21, 15]
        removNb(1000003).forEach(x -> System.out.println(x[0] + " " + x[1]));
    }

    public static List<long[]> removNb(long n) {

        // way 1 (time out)
//        long sum = LongStream.rangeClosed(1, n).sum();
//        for (long a = 1; a < n; a++) {
//            for (long b = a + 1; b <= n; b++) {
//                if (a * b == sum - a - b) {
//                    return new ArrayList<>(List.of(new long[]{a, b}, new long[]{b, a}));
//                }
//            }
//        }
//        return new ArrayList<>(List.of(new long[]{0, 0}));


        // way 2 (chatgpt)
        long sum = LongStream.rangeClosed(1, n).sum();
        List<long[]> result = new ArrayList<>();

        for (long a = 1; a <= n; a++) {
            long b = (sum - a) / (a + 1);
            if (b < a) break;
            if (a * b == sum - a - b && b <= n) {
                result.add(new long[]{a, b});
                result.add(new long[]{b, a});
            }
        }

        result.sort((a, b) -> (int) (a[0] - b[0]));

        return result;


        // sulpdang, Esze, karinakok, tutiii, teddy27, Gutow, Jorge Herrera
//        long sum = n * (1 + n) / 2;
//        return LongStream.rangeClosed(1, n)
//                .filter( i -> (sum + 1) % (i + 1) == 0)
//                .mapToObj( i -> new long[] { i, (sum + 1) / (i + 1) - 1})
//                .filter( i -> i[0] != i[1] && i[1] <= n)
//                .collect(Collectors.toList());
    }
}

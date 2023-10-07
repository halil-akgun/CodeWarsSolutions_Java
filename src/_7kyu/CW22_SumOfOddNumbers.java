package _7kyu;

/*
Given the triangle of consecutive odd numbers:

             1
          3     5
       7     9    11
   13    15    17    19
21    23    25    27    29
...
Calculate the sum of the numbers in the nth row of this triangle (starting at index 1) e.g.: (Input --> Output)

1 -->  1
2 --> 3 + 5 = 8
 */
public class CW22_SumOfOddNumbers {
    public static void main(String[] args) {
        System.out.println(rowSumOddNumbers(3));
    }

    public static int rowSumOddNumbers(int n) {
        int result = 0;
        int oddNum = 1;
        for (int i = 0; i < n; i++) {
            result = 0;
            for (int j = 0; j < i + 1; j++) {
                result += oddNum;
                oddNum += 2;
            }
        }
        return result;

        // hhelwich, Azuaron, AdhamAyman, Swarfiga, vestineo, algorithms, blankreg, theGerk, asridhar01, jcys (+ 3590)
//        return n * n * n;
    }
}

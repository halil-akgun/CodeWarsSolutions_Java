package _7kyu;

/*
Your task is to write a function which returns the sum of following series upto nth term(parameter).
Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
Rules:
You need to round the answer to 2 decimal places and return it as String.
If the given value is 0 then it should return 0.00
You will only be given Natural Numbers as arguments.

Examples:(Input --> Output)
1 --> 1 --> "1.00"
2 --> 1 + 1/4 --> "1.25"
5 --> 1 + 1/4 + 1/7 + 1/10 + 1/13 --> "1.57"
 */
public class CW31_SumOfTheFirstNthTermOfSeries {
    public static void main(String[] args) {
        System.out.println(seriesSum(5));
    }

    public static String seriesSum(int n) {
        double result = 0;
        int denominator = 1;
        for (int i = 0; i < n; i++) {
            result += (double) 1 / denominator;
            denominator += 3;
        }
        return String.format("%.2f", result);

        // ptrgags, Jabell, LeslieHero, meshnesh, IreneGP, totalinternaldirection, bennguli, ChungGor, ArekA, vlsc (+ 178)
//        for (int i = 0; i < n; i++)
//            sum += 1.0 / (1 + 3 * i);
    }
}

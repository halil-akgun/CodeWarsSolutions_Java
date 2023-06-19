package _8kyu;

/*
Create a function that finds the integral of the expression passed.

In order to find the integral all you need to do is add one to the exponent (the second argument),
and divide the coefficient (the first argument) by that new number.

For example, for 3x^2, the integral would be 1x^3: we added 1 to the exponent,
and divided the coefficient by that new number.

Note:
The output should be a string.
The coefficient and exponent are always a positive integer.
Examples
 3, 2  -->  "1x^3"
12, 5  -->  "2x^6"
20, 1  -->  "10x^2"
40, 3  -->  "10x^4"
90, 2  -->  "30x^3"
 */
public class CW38_FindTheIntegral {
    public static void main(String[] args) {
        System.out.println(integrate(3, 2));
    }

    public static String integrate(int coefficient, int exponent) {

        return coefficient / ++exponent + "x^" + exponent;

//        int right = exponent + 1;
//        int left = 0;
//        for (int i = 0; i < coefficient; i++) {
//            if (right * i == coefficient) {
//                left = i;
//                break;
//            }
//        }
//        return left + "x^" + right;
    }
}

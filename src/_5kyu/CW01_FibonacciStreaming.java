package _5kyu;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
You're going to provide a needy programmer a utility method that generates an infinite amount of sequential fibonacci numbers.

to do this return an IntStream starting with 1

A fibonacci sequence starts with two 1s. Every element afterwards is the sum of the two previous elements. See:
1, 1, 2, 3, 5, 8, 13, ..., 89, 144, 233, 377, ...
 */
public class CW01_FibonacciStreaming {
    public static void main(String[] args) {
        generateFibonacciSequence().forEach(System.out::println);
    }

    public static IntStream generateFibonacciSequence() {
        return Stream.iterate(new int[]{1, 1}, a -> new int[]{a[1], a[0] + a[1]})
                .map(a -> a[0])
                .mapToInt(i -> i);


        // crealee, guliing, hawkf, SVAN303, Polyfillrererer, Dasha-Bu:
//        return IntStream.generate(new IntSupplier() {
//            int a = 0; // previous number
//            int b = 1; // current number
//
//            @Override
//            public int getAsInt() {
//                int x = a + b; // next number
//                a = b; // set previous number
//                b = x; // set current number
//                return a; // return previous number
//            }
//        });
    }
}

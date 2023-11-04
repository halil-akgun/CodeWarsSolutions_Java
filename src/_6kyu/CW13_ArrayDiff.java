package _6kyu;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Your goal in this kata is to implement a difference function,
which subtracts one list from another and returns the result.
It should remove all values from list a, which are present in list b keeping their order.

Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
If a value is present in b, all of its occurrences must be removed from the other:
Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 */
public class CW13_ArrayDiff {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayDiff(new int[]{1, 2, 2, 2, 3}, new int[]{2})));
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        return Arrays.stream(a).filter(t -> Arrays.stream(b).noneMatch(u -> t == u)).toArray();

        // joecastle, Lagysha, user1231796, ignzio, Sasha123s, rui3, satish.bonde, Aram955, Coding WithTony, Cavedog (+ 3):
//        return IntStream.of(a).filter(x -> IntStream.of(b).noneMatch(y -> y == x)).toArray();
    }
}

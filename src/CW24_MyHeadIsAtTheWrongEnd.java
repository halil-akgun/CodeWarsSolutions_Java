import java.util.Arrays;

/*
You're at the zoo... all the meerkats look weird. Something has gone terribly wrong -
someone has gone and switched their heads and tails around!

Save the animals by switching them back. You will be given an array which will have three values (tail, body, head).
It is your job to re-arrange the array so that the animal is the right way round (head, body, tail).

Same goes for all the other arrays/lists that you will get in the tests: you have to change the element
positions with the same exact logics
 */
public class CW24_MyHeadIsAtTheWrongEnd {
    public static void main(String[] args) {
        String[] arr = {"e", "b", "c", "d", "a"};
        System.out.println(Arrays.toString(fixTheMeerkat(arr)));
    }

    public static String[] fixTheMeerkat(String[] arr) {
        String temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        return arr;
    }
}

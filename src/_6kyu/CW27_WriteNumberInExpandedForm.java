package _6kyu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
You will be given a number and you will need to return it as a string in Expanded Form. For example:

Kata.expandedForm(12); # Should return "10 + 2"
Kata.expandedForm(42); # Should return "40 + 2"
Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
NOTE: All numbers will be whole numbers greater than 0.
 */
public class CW27_WriteNumberInExpandedForm {
    public static void main(String[] args) {
        System.out.println(expandedForm(420370022));
    }

    public static String expandedForm(int num) {
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) != '0') {
                if (!temp.isEmpty()) {
                    list.add(temp + "0".repeat(strNum.length() - i));
                    temp.delete(0, temp.length());
                }
                temp.append(strNum.charAt(i));
            } else {
                temp.append(strNum.charAt(i));
            }
        }
        if (!temp.isEmpty()) {
            list.add(temp.toString());
        }
        return list.stream().reduce((s1, s2) -> s1 + " + " + s2).orElse("");

        // gauss_gauss:
//        return IntStream.range(0, String.valueOf(num).length())
//                .mapToObj(x -> String.valueOf( Character.getNumericValue(String.valueOf(num).charAt(x) ) * (int)Math.pow(10, String.valueOf(num).substring(x).length()-1)))
//                .filter(x -> !x.equals("0"))
//                .collect(Collectors.joining(" + "));

        // banz, vivia1994, Downcast, drogenleiche, linguist23, eldrogachino21, eldrogachino, user7534251, savant (+ 50):
//        String outs = "";
//        for (int i = 10; i < num; i *= 10) {
//            int rem = num % i;
//            outs = (rem > 0) ? " + " + rem + outs : outs;
//            num -= rem;
//        }
//        outs = num + outs;
//
//        return outs;
    }
}

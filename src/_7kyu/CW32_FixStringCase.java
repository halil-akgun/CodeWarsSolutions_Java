package _7kyu;

/*
In this Kata, you will be given a string that may have mixed uppercase and lowercase letters,
and your task is to convert that string to either lowercase only or uppercase only based on:

Make as few changes as possible.
If the string contains equal number of uppercase and lowercase letters, convert the string to lowercase.
For example:
solve("coDe") = "code". Lowercase characters > uppercase. Change only the "D" to lowercase.
solve("CODe") = "CODE". Uppercase characters > lowecase. Change only the "e" to uppercase.
solve("coDE") = "code". Upper == lowercase. Change all to lowercase.
 */
public class CW32_FixStringCase {
    public static void main(String[] args) {
        System.out.println(solve("cODe"));
    }

    public static String solve(final String str) {
        boolean isMoreLowerCase = str.replaceAll("[a-z]", "").length() > str.replaceAll("[A-Z]", "").length();
        return isMoreLowerCase ? str.toUpperCase() : str.toLowerCase();

        // Kzadro, chillmaw, Jarmander, skillet367, HokageDeveloper, ZloyKroll, VladimirDobrev, atilafikret, Black_Hand, SashkaLove (+ 6)
//        return str.chars().filter(Character::isLowerCase).count() >= str.chars().filter(Character::isUpperCase).count()
//                ? str.toLowerCase()
//                : str.toUpperCase();
    }
}

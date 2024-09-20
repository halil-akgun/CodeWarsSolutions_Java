package _5kyu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
For a given chemical formula represented by a string, count the number of atoms of each element contained in the
molecule and return an object (associative array in PHP, Dictionary<string, int> in C#, Map<String,Integer> in Java).

For example:
String water = "H2O";
parseMolecule.getAtoms(water); // return [H: 2, O: 1]

String magnesiumHydroxide = "Mg(OH)2";
parseMolecule.getAtoms(magnesiumHydroxide); // return ["Mg": 1, "O": 2, "H": 2]

String fremySalt = "K4[ON(SO3)2]2";
parseMolecule.getAtoms(fremySalt); // return ["K": 4, "O": 14, "N": 2, "S": 4]

parseMolecule.getAtoms("pie"); // throw an IllegalArgumentException
As you can see, some formulas have brackets in them. The index outside the brackets tells you that you have to
multiply count of each atom inside the bracket on this index. For example, in Fe(NO3)2 you have one iron atom,
two nitrogen atoms and six oxygen atoms.

Note that brackets may be round, square or curly and can also be nested. Index after the braces is optional.
 */
public class CW68_MoleculeToAtoms {
    public static void main(String[] args) {
//        System.out.println(getAtoms("H2O")); // {"H": 2, "O": 1}
//        System.out.println(getAtoms("Mg(OH)2")); // {"Mg": 1, "O": 2, "H": 2}
        System.out.println(getAtoms("K4[ON(SO3)2]2")); // {"K": 4, "O": 14, "N": 2, "S": 4}
//        System.out.println(getAtoms("pie"));
    }

    public static Map<String, Integer> getAtoms(String formula) {
        System.out.println(formula);
        if (Arrays.stream(formula.split("[^A-Za-z]"))
                .filter(t -> !t.isEmpty() && (Character.isLowerCase(t.charAt(0)) || t.length() > 2)).toArray().length > 0)
            throw new IllegalArgumentException();

        StringBuilder asd = new StringBuilder();
        asd.append("(").append(formula).append(")");

        Map<String, Integer> map = new HashMap<>();

        for (int i = asd.length() - 1; i >= 0; i--) {
            if (q(asd.charAt(i))) {
                int z = t(asd.toString(), i);
                c(asd.substring(i + 1, z), e(asd.substring(z + 1)), map);
                asd.replace(i, i + 1, "*");
                asd.replace(z, z + 1, "*");
                for (int j = i + 1; j < z; j++) {
                    if (Character.isDigit(asd.charAt(j)))
                        asd.replace(j, j + 1, "*");
                }
                for (int j = z + 1; j < asd.length(); j++) {
                    if (Character.isDigit(asd.charAt(j)))
                        asd.replace(j, j + 1, "*");
                    else
                        break;
                }
            }
        }

        return map;
    }

    private static void c(String s, int e, Map<String, Integer> map) {
        String[] split = s.replaceAll("[*]", "").split("(?=[A-Z])");
        System.out.println(s);
        System.out.println(Arrays.toString(split));
        for (String string : split) {
            String w = string.replaceAll("[0-9]", "");
            String n = string.replaceAll("[^0-9]", "");
            int b = (!n.isEmpty() ? Integer.parseInt(n) : 1) * e;
            System.out.println("***************");
            System.out.println(w);
            System.out.println(b);
            System.out.println(map);
            map.put(w, map.getOrDefault(w, 1) * b);
        }
    }

    private static boolean q(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static int t(String s, int a) {
        for (int i = a; i < s.length(); i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')
                return i;
        }
        return -1;
    }

    private static int e(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                sb.append(s.charAt(i));
            else
                break;
        }

        return sb.isEmpty() ? 1 : Integer.parseInt(sb.toString());
    }
}

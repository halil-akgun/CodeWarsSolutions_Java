package _5kyu;

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
        System.out.println(getAtoms("H2O")); // {"H": 2, "O": 1}
        System.out.println(getAtoms("Mg(OH)2")); // {"Mg": 1, "O": 2, "H": 2}
        System.out.println(getAtoms("K4[ON(SO3)2]2")); // {"K": 4, "O": 14, "N": 2, "S": 4}
        System.out.println(getAtoms("(C5H5)Fe(CO)2CH3")); // {"C"=8, "H"=8, "Fe"=1, "O"=2}
        System.out.println(getAtoms("As2{Be4C5[BCo3(CO2)3]2}4Cu5")); // {"As"=2, "B"=8, "Cu"=5, "Be"=16, "C"=44, "Co"=24, "O"=48}
        System.out.println(getAtoms("Mg(OH")); // throw an IllegalArgumentException
        System.out.println(getAtoms("pie")); // throw an IllegalArgumentException
    }

    private static final StringBuilder formulaBuilder = new StringBuilder();

    public static Map<String, Integer> getAtoms(String formula) {

        validateFormula(formula);

        formulaBuilder.setLength(0);
        formulaBuilder.append("(").append(formula).append(")");

        for (int i = formulaBuilder.length() - 1; i >= 0; i--) {
            if (isOpeningBracket(formulaBuilder.charAt(i))) {
                int closingBracketIndex = findClosingBracketIndex(formulaBuilder.toString(), i);
                validateBrackets(i, closingBracketIndex);
                processBracketedSection(i, closingBracketIndex);
            }
        }

        return parseAtoms(formulaBuilder.toString().split("(?=[A-Z])"));
    }

    private static void validateFormula(String formula) {
        if (formula.chars().filter(c -> c == '(').count() != formula.chars().filter(c -> c == ')').count()
                || formula.chars().filter(c -> c == '[').count() != formula.chars().filter(c -> c == ']').count()
                || formula.chars().filter(c -> c == '{').count() != formula.chars().filter(c -> c == '}').count()) {
            throw new IllegalArgumentException("Invalid formula: mismatched brackets.");
        }
    }

    private static void validateBrackets(int openingIndex, int closingIndex) {
        if (closingIndex == -1) {
            throw new IllegalArgumentException("Invalid formula: missing closing bracket.");
        }
        char openingBracket = formulaBuilder.charAt(openingIndex);
        char closingBracket = formulaBuilder.charAt(closingIndex);
        if (!((openingBracket == '(' && closingBracket == ')')
                || (openingBracket == '[' && closingBracket == ']')
                || (openingBracket == '{' && closingBracket == '}'))) {
            throw new IllegalArgumentException("Invalid formula: unmatched brackets.");
        }
    }

    private static void validateAtom(String atom) {
        if (!atom.matches("[A-Z][a-z]?[0-9]*")) {
            throw new IllegalArgumentException("Invalid atom format: " + atom);
        }
    }

    private static void processBracketedSection(int openingIndex, int closingIndex) {
        String[] atomsInsideBrackets = formulaBuilder.substring(openingIndex + 1, closingIndex).split("(?=[A-Z])");
        Map<String, Integer> atomCounts = parseAtoms(atomsInsideBrackets);

        StringBuilder multiplierStr = new StringBuilder();
        for (int j = closingIndex + 1; j < formulaBuilder.length(); j++) {
            if (Character.isDigit(formulaBuilder.charAt(j))) {
                multiplierStr.append(formulaBuilder.charAt(j));
            } else {
                break;
            }
        }

        int multiplier = !multiplierStr.isEmpty() ? Integer.parseInt(multiplierStr.toString()) : 1;

        StringBuilder replacement = new StringBuilder();
        for (Map.Entry<String, Integer> entry : atomCounts.entrySet()) {
            validateAtom(entry.getKey());
            replacement.append(entry.getKey()).append(entry.getValue() * multiplier);
        }

        formulaBuilder.delete(openingIndex, closingIndex + 1 + multiplierStr.length());
        formulaBuilder.insert(openingIndex, replacement);
    }

    private static Map<String, Integer> parseAtoms(String[] atoms) {
        Map<String, Integer> atomCountMap = new HashMap<>();
        for (String atom : atoms) {
            String element = atom.replaceAll("[0-9]", "");
            int count = atom.replaceAll("[^0-9]", "").isEmpty() ? 1 : Integer.parseInt(atom.replaceAll("[^0-9]", ""));
            atomCountMap.put(element, atomCountMap.getOrDefault(element, 0) + count);
        }
        return atomCountMap;
    }

    private static boolean isOpeningBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static int findClosingBracketIndex(String formula, int openingIndex) {
        for (int i = openingIndex; i < formula.length(); i++) {
            if (formula.charAt(i) == ')' || formula.charAt(i) == ']' || formula.charAt(i) == '}') {
                return i;
            }
        }
        return -1;
    }
}

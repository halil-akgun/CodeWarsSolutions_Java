package _5kyu;

import java.util.ArrayList;
import java.util.List;

/*
Returns the bank account number parsed from specified string.

You work for a bank, which has recently purchased an ingenious machine to assist in reading letters and faxes sent in by branch offices.
The machine scans the paper documents, and produces a string with a bank account that looks like this:
 _     _  _     _  _  _  _  _
| |  | _| _||_||_ |_   ||_||_|
|_|  ||_  _|  | _||_|  ||_| _|

Each string contains an account number written using pipes and underscores.
Each account number should have at least one digit, all of which should be in the range 0-9.

Your task is to write a function that can take bank account string and parse it into actual account numbers.

 @param {string} bankAccount
 @return {number}

Examples:
   '    _  _     _  _  _  _  _ \n'+
   '  | _| _||_||_ |_   ||_||_|\n'+     => 123456789
   '  ||_  _|  | _||_|  ||_| _|\n'

   ' _  _  _  _  _  _  _  _  _ \n'+
   '| | _| _|| ||_ |_   ||_||_|\n'+     => 23056789
   '|_||_  _||_| _||_|  ||_| _|\n',

   ' _  _  _  _  _  _  _  _  _ \n'+
   '|_| _| _||_||_ |_ |_||_||_|\n'+     => 823856989
   '|_||_  _||_| _||_| _||_| _|\n',
 */
public class CW27_ParseBankAccountNumber {
    public static void main(String[] args) {
        System.out.println(parse(
                """
                            _  _     _  _  _  _  _\s
                          | _| _||_||_ |_   ||_||_|
                          ||_  _|  | _||_|  ||_| _|
                        """
        )); // 123456789

        System.out.println(parse(
                """
                         _  _  _  _  _  _  _  _  _\s
                        | | _| _|| ||_ |_   ||_||_|
                        |_||_  _||_| _||_|  ||_| _|
                        """
        )); // 23056789

        System.out.println(parse(
                """
                         _  _  _  _  _  _  _  _  _\s
                        |_| _| _||_||_ |_ |_||_||_|
                        |_||_  _||_| _||_| _||_| _|
                        """
        )); // 823856989
    }

    public static long parse(final String acctNbr) {
        String[] line1 = new String[]{" _ ", "   ", " _ ", " _ ", "   ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ "};
        String[] line2 = new String[]{"| |", "  |", " _|", " _|", "|_|", "|_ ", "|_ ", "  |", "|_|", "|_|", "|_|"};
        String[] line3 = new String[]{"|_|", "  |", "|_ ", " _|", "  |", " _|", "|_|", "  |", "|_|", " _|", " _|"};

        List<String> digits = new ArrayList<>();

        for (int i = 0; i < line1.length; i++) {
            digits.add(line1[i] + line2[i] + line3[i]);
        }

        String[] lines = acctNbr.split("\n");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lines[0].length(); i += 3) {
            String digitLine1 = lines[0].substring(i, i + 3);
            String digitLine3 = lines[2].substring(i, i + 3);
            String digitLine2 = lines[1].substring(i, i + 3);
            sb.append(digits.indexOf(digitLine1 + digitLine2 + digitLine3));
        }

        return Long.parseLong(sb.toString());
    }
}

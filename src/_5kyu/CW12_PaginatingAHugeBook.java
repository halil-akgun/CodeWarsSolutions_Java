package _5kyu;

/*
Johnny is working as an intern for a publishing company, and was tasked with cleaning up old code. He is working
on a program that determines how many digits are in all of the page numbers in a book with pages from 1 to n (inclusive).

For example, a book with 4 pages has 4 digits (one for each page), while a 12 page book has 15 (9 for 1-9, plus 2 each for 10, 11, 12).

Johnny's boss, looking to futureproof, demanded that the new program be able to handle books up to 400,000,000,000,000,000 pages.
 */
public class CW12_PaginatingAHugeBook {
    public static void main(String[] args) {
//        System.out.println(pageDigits(12));
//        System.out.println(pageDigits(400000000));
        System.out.println(pageDigits(4));
//        System.out.println(pageDigits(4000000000000000000L));
    }

    public static long pageDigits(long pages) {

        /*
            1-9		    9       (9 * (0 + 1) * (Math.pow(10, 0)))
            10-99		180     (9 * (1 + 1) * (Math.pow(10, 1)))
            100-999		2700    (9 * (2 + 1) * (Math.pow(10, 2)))
            1000-9999	36000   (9 * (3 + 1) * (Math.pow(10, 3)))
            ...
         */

        long totalDigits = 0;
        long maxPageWithPrevDigits = pages > 9 ? Long.parseLong("9".repeat(String.valueOf(pages).length() - 1)) : 0;
        int maxPageWithPrevDigitsLength = maxPageWithPrevDigits > 0 ? String.valueOf(maxPageWithPrevDigits).length() : 0;

        for (int i = 0; i < maxPageWithPrevDigitsLength; i++) {
            totalDigits  += (long) (9 * (i + 1) * (Math.pow(10, i)));
        }

        totalDigits  += (pages - maxPageWithPrevDigits) * (Long.toString(pages).length());

        return totalDigits ;


        // idubrov, Decimo, Minko216:
//        long mul = 1;
//        long cnt = 1;
//        long total = 0;
//        while (pages / mul >= 10) {
//            total += 9 * mul * cnt;
//            mul *= 10;
//            cnt++;
//        }
//        total += (pages - mul + 1) * cnt;
//        return total;
    }
}

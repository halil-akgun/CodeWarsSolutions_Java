package _5kyu;

/*
Story
On some island lives a chameleon population. Chameleons here can be of only one of three colors - red, green and blue.
Whenever two chameleons of different colors meet, they both change their colors to the third one (i.e. when red and
blue chameleons meet, they can both become green). There is no other way for chameleons to change their color
(in particular, when red and blue chameleons meet, they can't become both red, only third color can be assumed).
Chameleons want to become of one certain color. They may plan they meetings to reach that goal. Chameleons want to know,
how fast their goal can be achieved (if it can be achieved at all).

Formal problem
Input:
Color is coded as integer, 0 - red, 1 - green, 2 - blue. Chameleon starting population is given as an array of
three integers, with index corresponding to color (i.e. [2, 5, 3] means 2 red, 5 green and 3 blue chameleons).
All numbers are non-negative, their sum is between 1 and int.MaxValue (maximal possible value for int type,
in other languages). Desired color is given as an integer from 0 to 2.
Output:
Kata.Chameleon should return minimal number of meetings required to change all chameleons to a given color,
or -1 if it is impossible (for example, if all chameleons are initially of one other color).

Notes and hints
-- Some tests use rather big input values. Be effective.
-- There is a strict proof that answer is either -1 or no greater than total number of chameleons
(thus, return type int is justified). Don't worry about overflow.
 */
public class CW70_ChameleonUnity {
    public static void main(String[] args) {
        System.out.println(Chameleon(new int[]{0, 0, 17}, 1)); // -1
        System.out.println(Chameleon(new int[]{1, 1, 15}, 2)); // 1
        System.out.println(Chameleon(new int[]{34, 32, 35}, 0)); // 35
    }

    public static int Chameleon(int[] chameleons, int desiredColor) {
        int[] otherColors = getOtherColors(desiredColor);
        int meetings = 0;

        if (chameleons[desiredColor] == 0 && (otherColors[0] == 0 || otherColors[1] == 0))
            return -1;

        int minOpposite = Math.min(chameleons[otherColors[0]], chameleons[otherColors[1]]);
        chameleons[desiredColor] += minOpposite * 2;
        chameleons[otherColors[0]] -= minOpposite;
        chameleons[otherColors[1]] -= minOpposite;
        meetings += minOpposite;

        int zeroColorIdx = chameleons[otherColors[0]] == 0 ? otherColors[0] : otherColors[1];
        int nonZeroColorIdx = chameleons[otherColors[0]] != 0 ? otherColors[0] : otherColors[1];

        while (chameleons[desiredColor] > 0) {
            if (chameleons[zeroColorIdx] == chameleons[nonZeroColorIdx]
                    || chameleons[zeroColorIdx] > chameleons[nonZeroColorIdx])
                break;

            chameleons[desiredColor]--;
            chameleons[nonZeroColorIdx]--;
            chameleons[zeroColorIdx] += 2;
            meetings++;
        }

        if (chameleons[zeroColorIdx] == chameleons[nonZeroColorIdx])
            return meetings + chameleons[zeroColorIdx];
        else
            return -1;


        // lastmind4, du_an, egsqzEl:
//        int targetCount = chameleons[desiredColor];
//        int a = chameleons[(desiredColor + 1) % 3];
//        int b = chameleons[(desiredColor + 2) % 3];
//        if ((Math.min(a, b) == 0 && targetCount == 0) ||
//                (a - b) % 3 != 0) return -1;
//        return Math.max(a, b);
    }

    private static int[] getOtherColors(int desiredColor) {
        if (desiredColor == 0)
            return new int[]{1, 2};
        else if (desiredColor == 1)
            return new int[]{0, 2};
        else
            return new int[]{0, 1};

    }
}

package _5kyu;

/*
There is a war and nobody knows - the alphabet war!
The letters hide in their nuclear shelters. The nuclear strikes hit the battlefield and killed a lot of them.

Task
Write a function that accepts battlefield string and returns letters that survived the nuclear strike.

 - The battlefield string consists of only small letters, #,[ and ].
 - The nuclear shelter is represented by square brackets []. The letters inside
   the square brackets represent letters inside the shelter.
 - The # means a place where nuclear strike hit the battlefield. If there is at least one # on the battlefield,
   all letters outside of shelter die. When there is no any # on the battlefield, all letters survive
   (but do not expect such scenario too often ;-P ).
 - The shelters have some durability. When 2 or more # hit close to the shelter, the shelter is destroyed and
   all letters inside evaporate. The 'close to the shelter' means on the ground between the shelter and
   the next shelter (or beginning/end of battlefield). The below samples make it clear for you.

Example
abde[fgh]ijk     => "abdefghijk"  (all letters survive because there is no # )
ab#de[fgh]ijk    => "fgh" (all letters outside die because there is a # )
ab#de[fgh]ij#k   => ""  (all letters dies, there are 2 # close to the shellter )
##abde[fgh]ijk   => ""  (all letters dies, there are 2 # close to the shellter )
##abde[fgh]ijk[mn]op => "mn" (letters from the second shelter survive, there is no # close)
#ab#de[fgh]ijk[mn]op => "mn" (letters from the second shelter survive, there is no # close)
#abde[fgh]i#jk[mn]op => "mn" (letters from the second shelter survive, there is only 1 # close)
[a]#[b]#[c]  => "ac"
[a]#b#[c][d] => "d"
[a][b][c]    => "abc"
##a[a]b[c]#  => "c"
 */
public class CW65_AlphabetWars_NuclearStrike {
    public static void main(String[] args) {
        System.out.println(alphabetWar("abde[fgh]ijk")); // "abdefghijk"
        System.out.println(alphabetWar("ab#de[fgh]ijk")); // "fgh"
        System.out.println(alphabetWar("ab#de[fgh]ij#k")); // ""
        System.out.println(alphabetWar("##abde[fgh]ijk")); // ""
        System.out.println(alphabetWar("##abde[fgh]ijk[mn]op")); // "mn"
        System.out.println(alphabetWar("#ab#de[fgh]ijk[mn]op")); // "mn"
        System.out.println(alphabetWar("#abde[fgh]i#jk[mn]op")); // "mn"
        System.out.println(alphabetWar("[a]#[b]#[c]")); // "ac"
        System.out.println(alphabetWar("[a]#b#[c][d]")); // "d"
        System.out.println(alphabetWar("[a][b][c]")); // "abc"
        System.out.println(alphabetWar("l[jpt]y##py[nm]##[lq][sdz][si]kur[z]qdbfle#")); // "sdzsiz"
        System.out.println(alphabetWar("[eh]#[my]x#so#[bpe]dxt[vp]yd")); // "ehvp"
        System.out.println(alphabetWar("zxsxrcv[ywg]#[agz][y][wb][qo]###jkx")); // "ywgagzywb"
    }

    public static String alphabetWar(String battlefield) {

        if (!battlefield.contains("#")) {
            return battlefield.replaceAll("[\\[\\]]", "");
        }

        battlefield = battlefield.replaceAll("[^#\\[\\]]+(?![^\\[]*])", "");

        int previousStrikeIndex = battlefield.indexOf('#');

        for (int i = previousStrikeIndex + 1; i < battlefield.length(); i++) {
            if (battlefield.charAt(i) == '#') {
                if (i - previousStrikeIndex == 1) {
                    String leftPart = "";
                    String rightPart = "";
                    try {
                        leftPart = battlefield.substring(0, battlefield.substring(0, previousStrikeIndex).lastIndexOf('['));
                    } catch (Exception ignored) {
                    }
                    try {
                        int w = battlefield.substring(i).indexOf(']');
                        rightPart = battlefield.substring(i + (w == -1 ? 0 : w) + 1);
                    } catch (Exception ignored) {
                    }
                    battlefield = leftPart + "[]" + rightPart;
                    previousStrikeIndex = -1;
                    i = leftPart.length() - 1;
                } else if (i < battlefield.length() - 1 && battlefield.charAt(i + 1) == '#') {
                    previousStrikeIndex = i;
                } else if (previousStrikeIndex != -1 && battlefield.substring(previousStrikeIndex, i).replaceAll("[^\\[]", "").length() == 1) {
                    battlefield = battlefield.substring(0, previousStrikeIndex) + battlefield.substring(i);
                    if (battlefield.substring(previousStrikeIndex).length() > 1)
                        i = previousStrikeIndex;
                } else {
                    previousStrikeIndex = i;
                }
            }
        }

        return battlefield.replaceAll("[#\\[\\]]", "");
    }
}

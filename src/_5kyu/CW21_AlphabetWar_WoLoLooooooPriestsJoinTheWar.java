package _5kyu;

/*
Introduction
There is a war and nobody knows - the alphabet war!
There are two groups of hostile letters. The tension between left side letters and right side letters was
too high and the war began. The letters have discovered a new unit - a priest with Wo lo looooooo power.

Task
Write a function that accepts fight string consists of only small letters and return who wins the fight.
When the left side wins return Left side wins!, when the right side wins return Right side wins!,
in other case return Let's fight again!.

The left side letters and their power:
 w - 4
 p - 3
 b - 2
 s - 1
 t - 0 (but it's priest with Wo lo loooooooo power)

The right side letters and their power:
 m - 4
 q - 3
 d - 2
 z - 1
 j - 0 (but it's priest with Wo lo loooooooo power)

The other letters don't have power and are only victims.
The priest units t and j change the adjacent letters from hostile letters to friendly letters with the same power.
mtq => wtp
wjs => mjz

A letter with adjacent letters j and t is not converted i.e.:
tmj => tmj
jzt => jzt

The priests (j and t) do not convert the other priests ( jt => jt ).

Example
AlphabetWars.woLoLoooooo("z")         //=>  "z"  => "Right side wins!"
AlphabetWars.woLoLoooooo("tz")        //=>  "ts" => "Left side wins!"
AlphabetWars.woLoLoooooo("jz")        //=>  "jz" => "Right side wins!"
AlphabetWars.woLoLoooooo("zt")        //=>  "st" => "Left side wins!"
AlphabetWars.woLoLoooooo("azt")       //=> "ast" => "Left side wins!"
AlphabetWars.woLoLoooooo("tzj")       //=> "tzj" => "Right side wins!"
 */
public class CW21_AlphabetWar_WoLoLooooooPriestsJoinTheWar {
    public static void main(String[] args) {
        System.out.println(woLoLoooooo("z")); // "z"  => "Right side wins!"
        System.out.println(woLoLoooooo("tz")); // "ts" => "Left side wins!"
        System.out.println(woLoLoooooo("jz")); // "jz" => "Right side wins!"
        System.out.println(woLoLoooooo("zt")); // "st" => "Left side wins!"
        System.out.println(woLoLoooooo("azt")); // "ast" => "Left side wins!"
        System.out.println(woLoLoooooo("tzj")); // "tzj" => "Right side wins!"
    }

    public static String woLoLoooooo(String battlefield) {
        String t = "tsbpw";
        String j = "jzdqm";

        StringBuilder converted = new StringBuilder();

        for (int i = 0; i < battlefield.length(); i++) {

        }
    }

    private static boolean isConvertible(char left, char center, char right) {
        return (center != 't' && center != 'j')
                &&
                !((left == 't' && right == 'j') || (left == 'j' && right == 't'));
    }
}

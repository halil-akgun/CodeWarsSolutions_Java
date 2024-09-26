package _5kyu;

/*
Story
Old MacDingle had a farm...
...and on that farm he had
    horses
    chickens
    rabbits
    some apple trees
    a vegetable patch

Everything is idylic in the MacDingle farmyard unless somebody leaves the gates open
Depending which gate was left open then...
    horses might run away
    horses might eat the apples
    horses might eat the vegetables
    chickens might run away
    rabbits might run away
    rabbits might eat the vegetables

Kata Task
Given the state of the farm gates in the evening, your code must return what the farm looks like
the next morning when daylight reveals what the animals got up to.

Legend
    H horse
    C chicken
    R rabbit
    A apple tree
    V vegetables
    | gate (closed),
    \ or / gate (open)
    . everything else

Example
Before	```|..HH....\AAAA\CC..|AAA/VVV/RRRR|CCC```
After	```|..HH....\....\CC..|AAA/.../RRRR|...``` Because:
The horses ate whatever apples they could get to
The rabbits ate the vegetables
The chickens ran away

Notes
If the animals can eat things and also run away then they do BOTH - it is best not to run away when you are hungry!
An animal cannot "go around" a closed gate...
...but it is possible to run away from the farm and then RUN BACK and re-enter though more open gates on the other side!
 */
public class CW72_TheHungerGames_ShutTheGate {
    public static void main(String[] args) {
        System.out.println(shutTheGate("|..HH....\\AAAA\\CC..|AAA/VVV/RRRR|CCC")); // |..HH....\....\CC..|AAA/.../RRRR|...
        System.out.println(shutTheGate("/RRR|AAA|VVV|AAA/VVV/CCCC")); //
    }

    private static final StringBuilder farmState = new StringBuilder();

    public static String shutTheGate(final String farm) {
        farmState.setLength(0);
        farmState.append(farm);
        boolean isEscaped;
        for (int i = 0; i < farm.length(); i++) {
            if (farm.charAt(i) == 'H' || farm.charAt(i) == 'R' || farm.charAt(i) == 'C') {
                isEscaped = checkAnimalAction(i);
                if (isEscaped) {
                    char animal = farmState.charAt(i);
                    for (int j = i; j < farmState.length(); j++) {
                        if (farmState.charAt(j) == animal)
                            farmState.setCharAt(j, '.');
                        else
                            break;
                    }
                }
            }
        }
        return farmState.toString();
    }

    private static boolean checkAnimalAction(int r) {
        boolean left = true;
        boolean right = true;
        for (int i = r - 1; i >= 0; i--) {
            if (isFoodForAnimal(farmState.charAt(r), farmState.charAt(i)))
                farmState.setCharAt(i, '.');
            if (farmState.charAt(i) == '|') {
                left = false;
                break;
            }
        }
        for (int i = r + 1; i < farmState.length(); i++) {
            if (isFoodForAnimal(farmState.charAt(r), farmState.charAt(i)))
                farmState.setCharAt(i, '.');
            if (farmState.charAt(i) == '|') {
                right = false;
                break;
            }
        }
        if (left) {
            handleRunaway(r, true);
        } else if (right) {
            handleRunaway(r, false);
        }
        return left || right;
    }

    private static void handleRunaway(int a, boolean fromRight) {
        char animal = farmState.charAt(a);
        int idx = fromRight ? farmState.length() - 1 : 0;
        while (idx >= 0 && idx < farmState.length() && farmState.charAt(idx) != '|') {
            if (isFoodForAnimal(animal, farmState.charAt(idx)))
                farmState.setCharAt(idx, '.');
            if (fromRight) {
                idx--;
            } else {
                idx++;
            }
        }
    }

    private static boolean isFoodForAnimal(char animal, char item) {
        return (animal == 'H' && (item == 'A' || item == 'V'))
                || (animal == 'R' && item == 'V');
    }
}

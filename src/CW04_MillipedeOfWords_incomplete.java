import java.util.ArrayList;

public class CW04_MillipedeOfWords_incomplete {
    public static void main(String[] args) {
        /*
        Millipede of words
        The set of words is given. Words are joined if the last letter of one word and
        the first letter of another word are the same. Return true if all words of the set
        can be combined into one word. Each word can and must be used only once. Otherwise return false.

        Input
        Array of 3 to 7 words of random length. No capital letters.
        Example true
        Set: excavate, endure, desire, screen, theater, excess, night.
        Millipede: desirE EndurE ExcavatE ExcesS ScreeN NighT Theater.
        Example false
        Set: trade, pole, view, grave, ladder, mushroom, president.
        Millipede: presidenT Trade.
        */
//        ArrayList<String> millipede = new ArrayList<>();
        String millipede[] = new String[7];
        // excavate, endure, desire, screen, theater, excess, night
        millipede[0] = "excavate";
        millipede[1] = "endure";
        millipede[2] = "desire";
        millipede[3] = "screen";
        millipede[4] = "theater";
        millipede[5] = "excess";
        millipede[6] = "night";

        ArrayList<String> firstLetters = new ArrayList<>();
        ArrayList<String> lastLetters = new ArrayList<>();

        for (String w : millipede) {
            firstLetters.add(w.substring(0, 1));
            lastLetters.add(w.substring(w.length() - 1));
        }

        for (int i = 0; i < firstLetters.size(); i++) {
            for (String w : firstLetters) {
                for (String k : lastLetters) {
                    if (w.equalsIgnoreCase(k)) {
                        // firstLetters.remove(k);
                        lastLetters.remove(k);
                        break;
                    }
                }
            }
        }

        int counter = 0;
        int false1 = 0;
        for (int i = 0; i < millipede.length; i++) {
            for (int j = 0; j < millipede.length; j++) {
                if (i != j) {
                    char firstCharI = millipede[i].charAt(0);
                    char lastCharJ = millipede[j].charAt(millipede[j].length() - 1);
                    char firstCharJ = millipede[j].charAt(0);
                    char lastCharI = millipede[i].charAt(millipede[i].length() - 1);
                    if ((firstCharI == lastCharJ) & (firstCharJ == lastCharI)) {
                        for (int k = 0; k < millipede.length; k++) {
                            char firstCharK = millipede[k].charAt(0);
                            char lastCharK = millipede[k].charAt(millipede[k].length() - 1);
                            if (i != k & j != k) {
                                if ((firstCharI == lastCharK) | (firstCharJ == lastCharK) | (firstCharK == lastCharI) | (firstCharK == lastCharJ)) {
                                    counter++;
                                }
                            }
                        }
                        if (counter == 0) {
                            false1++;
                            counter = 0;
                        }
                    }
                }
            }
        }
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        for (int i = 0; i < millipede.length; i++) {
            char firstCharI = millipede[i].charAt(0);
            char lastCharI = millipede[i].charAt(millipede[i].length() - 1);
            if (firstCharI == lastCharI) {
                counter4++;
                for (int j = 0; j < millipede.length; j++) {
                    char firstCharJ = millipede[j].charAt(0);
                    char lastCharJ = millipede[j].charAt(millipede[j].length() - 1);
                    if ((i != j) & (firstCharI == firstCharJ)) counter2++;
                    if ((i != j) & (firstCharI == lastCharJ)) counter3++;
                }
            }
        }
        boolean counter5 = false;
        if ((counter4 == 1) & ((counter2 > 1) | counter3 > 1)) counter5 = true;
        if ((counter4 > 1) & ((counter2 > 4) | counter3 > 4)) counter5 = true;
        System.out.println(false1);
        System.out.println(lastLetters.size());
        System.out.println(counter2);
        System.out.println(counter3);
        System.out.println(counter4);
        System.out.println(counter5);


        if (lastLetters.size() > 1 | false1 > 0 | counter5 | counter5) {
            //            return false;
            System.out.println("false = " + false);
        } else {
//            return true;
            System.out.println("true = " + true);
        }


    }
}
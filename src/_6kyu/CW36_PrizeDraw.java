package _6kyu;

import java.util.ArrayList;
import java.util.List;

/*
To participate in a prize draw each one gives his/her firstname.
Each letter of a firstname has a value which is its rank in the English alphabet.
A and a have rank 1, B and b rank 2 and so on.
The length of the firstname is added to the sum of these ranks hence a number som.
An array of random weights is linked to the firstnames and each som is multiplied by
its corresponding weight to get what they call a winning number.

Example:
names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
weights: [1, 4, 4, 5, 2, 1]
PauL -> som = length of firstname + 16 + 1 + 21 + 12 = 4 + 50 -> 54
The *weight* associated with PauL is 2 so PauL's *winning number* is 54 * 2 = 108.
Now one can sort the firstnames in decreasing order of the winning numbers.
When two people have the same winning number sort them alphabetically by their firstnames.

Task:
parameters: st a string of firstnames, we an array of weights, n a rank
return: the firstname of the participant whose rank is n (ranks are numbered from 1)

Example:
names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
weights: [1, 4, 4, 5, 2, 1]
n: 4
The function should return: "PauL"

Notes:
The weight array is at least as long as the number of names, it may be longer.
If st is empty return "No participants".
If n is greater than the number of participants then return "Not enough participants".
 */
public class CW36_PrizeDraw {
    public static void main(String[] args) {
        System.out.println(nthRank("COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH", new Integer[]{1, 4, 4, 5, 2, 1}, 4));
        System.out.println(nthRank("", new Integer[]{1, 4, 4, 5, 2, 1}, 4)); // No participants
        System.out.println(nthRank("COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH", new Integer[]{1, 4, 4, 5, 2, 1}, 7)); // Not enough participants
    }

    public static String nthRank(String st, Integer[] we, int n) {

        if (st == null || st.isEmpty()) {
            return "No participants";
        }

        String[] names = st.split(",");
        if (n > names.length) {
            return "Not enough participants";
        }

        int[] winningNumbers = new int[names.length];
        for (int i = 0; i < names.length; i++) {
            winningNumbers[i] = computeSom(names[i]) * we[i];
        }

        for (int i = 0; i < winningNumbers.length - 1; i++) {
            for (int j = i + 1; j < winningNumbers.length; j++) {
                if (winningNumbers[i] <= winningNumbers[j]) {
                    if (winningNumbers[i] == winningNumbers[j] && names[i].compareTo(names[j]) < 0) continue;
                    String tempStr = names[i];
                    names[i] = names[j];
                    names[j] = tempStr;
                    int tempInt = winningNumbers[i];
                    winningNumbers[i] = winningNumbers[j];
                    winningNumbers[j] = tempInt;
                }
            }
        }

        return names[n - 1];

        /* ChatGPT:

        List<Participant> participants = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            int winningNumber = computeSom(names[i]) * we[i];
            participants.add(new Participant(names[i], winningNumber));
        }

        participants.sort((p1, p2) -> {
            if (p2.winningNumber != p1.winningNumber) {
                return Integer.compare(p2.winningNumber, p1.winningNumber);
            } else {
                return p1.name.compareTo(p2.name);
            }
        });

        return participants.get(n - 1).name;

         */
    }

    private static int computeSom(String name) {
        int result = 0;

        for (int i = 0; i < name.length(); i++) {
            result += name.toLowerCase().charAt(i) - 'a' + 1;
        }

        return result + name.length();
    }

    private static class Participant {
        String name;
        int winningNumber;

        Participant(String name, int winningNumber) {
            this.name = name;
            this.winningNumber = winningNumber;
        }
    }
}

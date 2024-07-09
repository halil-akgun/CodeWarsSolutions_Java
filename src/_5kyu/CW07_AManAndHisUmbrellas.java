package _5kyu;

/*
A Man and his Umbrellas
Each morning a man walks to work, and each afternoon he walks back home.

If it is raining in the morning and he has an umbrella at home, he takes an umbrella for the journey
so he doesn't get wet, and stores it at work. Likewise, if it is raining in the afternoon and
he has an umbrella at work, he takes an umbrella for the journey home.

Given an array of the weather conditions, your task is to work out the minimum number of umbrellas
he needs to start with in order that he never gets wet. He can start with some umbrellas at home and
some at work, but the output is a single integer, the minimum total number.

The input is an array/list of consecutive half-day weather forecasts. So, e.g. the first value is
the 1st day's morning weather and the second value is the 1st day's afternoon weather. The options are:

Without umbrella:
"clear",
"sunny",
"cloudy",
"overcast",
"windy".

With umbrella:
"rainy",
"thunderstorms".

e.g. for three days, 6 values:
weather = ["rainy", "cloudy", "sunny", "sunny", "cloudy", "thunderstorms"]

N.B. He never takes an umbrella if it is not raining.

Examples:
minUmbrellas(["rainy", "clear", "rainy", "cloudy"])
should return 2
Because on the first morning, he needs an umbrella to take, and he leaves it at work. So on the second morning, he needs a second umbrella.

minUmbrellas(["sunny", "windy", "sunny", "clear"])
should return 0
Because it doesn't rain at all

minUmbrellas(["rainy", "rainy", "rainy", "rainy", "thunderstorms", "rainy"])
should return 1
Because he only needs 1 umbrella which he takes on every journey.

Note for Java users
The following enum is preloaded for you:
public enum Weather {
    CLEAR, SUNNY, CLOUDY, RAINY, OVERCAST, WINDY, THUNDERSTORMS;
}
 */
public class CW07_AManAndHisUmbrellas {
    public static void main(String[] args) {
        System.out.println(minUmbrellas(Weather.RAINY, Weather.RAINY, Weather.RAINY, Weather.RAINY, Weather.THUNDERSTORMS, Weather.RAINY)); // 1
        System.out.println(minUmbrellas(Weather.CLEAR, Weather.CLEAR, Weather.OVERCAST, Weather.CLEAR, Weather.CLEAR, Weather.CLEAR)); // 0
        System.out.println(minUmbrellas(Weather.SUNNY, Weather.WINDY, Weather.SUNNY, Weather.CLEAR)); // 0
        System.out.println(minUmbrellas(Weather.RAINY, Weather.CLEAR, Weather.RAINY, Weather.CLOUDY)); // 2
    }

    public static int minUmbrellas(Weather... forecast) {

        int purchasedUmbrellas = 0;
        int umbrellasAtHome = 0;
        int umbrellasAtWork = 0;

        int idx = 0;
        for (Weather weather : forecast) {
            if (idx % 2 == 0) { // morning
                if (weather == Weather.RAINY || weather == Weather.THUNDERSTORMS) {
                    if (umbrellasAtHome > 0) umbrellasAtHome--;
                    else purchasedUmbrellas++;
                    umbrellasAtWork++;
                }
            } else { // afternoon
                if (weather == Weather.RAINY || weather == Weather.THUNDERSTORMS) {
                    if (umbrellasAtWork > 0) umbrellasAtWork--;
                    else purchasedUmbrellas++;
                    umbrellasAtHome++;
                }
            }
            idx++;
        }

        return purchasedUmbrellas;
    }

    public enum Weather {
        CLEAR, SUNNY, CLOUDY, RAINY, OVERCAST, WINDY, THUNDERSTORMS
    }
}

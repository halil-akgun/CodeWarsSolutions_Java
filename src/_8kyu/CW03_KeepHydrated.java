package _8kyu;

import java.util.Scanner;

/*
Nathan loves cycling.
Because Nathan knows it is important to stay hydrated, he drinks 0.5 litres of water per hour of cycling.
You get given the time in hours and you need to return the number of litres Nathan will drink, rounded to the smallest value.

For example:
time = 3 ----> litres = 1
time = 6.7---> litres = 3
time = 11.8--> litres = 5
 */
public class CW03_KeepHydrated {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        double time = inp.nextDouble();
        System.out.println(Liters(time));
    }

    public static int Liters(double time) {
        return (int) (0.5 * time);
    }
}

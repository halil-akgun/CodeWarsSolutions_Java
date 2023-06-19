package _8kyu;

/*
You're writing code to control your town's traffic lights. You need a function to handle each change from green,
to yellow, to red, and then to green again.

Complete the function that takes a string as an argument representing the current state of the light and
returns a string representing the state the light should change to.

For example, when the input is green, output should be yellow.
 */
public class CW25_Thinkful_LogicDrills_TrafficLight {
    public static void main(String[] args) {
        System.out.println(updateLight("red"));
    }

    public static String updateLight(String current) {
        return current.equals("green") ? "yellow" : current.equals("yellow") ? "red" : "green";
    }
}

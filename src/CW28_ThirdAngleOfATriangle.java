/*
You are given two interior angles (in degrees) of a triangle.
Write a function to return the 3rd.
Note: only positive integers will be tested.
https://en.wikipedia.org/wiki/Triangle
 */
public class CW28_ThirdAngleOfATriangle {
    public static void main(String[] args) {
        System.out.println(otherAngle(45, 45));
    }

    public static int otherAngle(int angle1, int angle2) {
        return 180 - angle1 - angle2;
    }
}

/*
Given a point in a Euclidean plane (x and y), return the quadrant the point exists in: 1, 2, 3 or 4 (integer). x and y are non-zero integers, therefore the given point never lies on the axes.

Examples
(1, 2)     => 1
(3, 5)     => 1
(-10, 100) => 2
(-1, -9)   => 3
(19, -56)  => 4
image: https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Cartesian_coordinates_2D.svg/300px-Cartesian_coordinates_2D.svg.png

There are four quadrants:
1- First quadrant, the quadrant in the top-right, contains all points with positive X and Y
2- Second quadrant, the quadrant in the top-left, contains all points with negative X, but positive Y
3- Third quadrant, the quadrant in the bottom-left, contains all points with negative X and Y
4- Fourth quadrant, the quadrant in the bottom-right, contains all points with positive X, but negative Y
 */
public class CW31_Quadrants {
    public static void main(String[] args) {
        System.out.println(quadrant(1, 2));
    }

    public static int quadrant(int x, int y) {
        if (x > 0 && y > 0) return 1;
        else if (x < 0 && y > 0) return 2;
        else if (x < 0 && y < 0) return 3;
        else return 4;
    }
}

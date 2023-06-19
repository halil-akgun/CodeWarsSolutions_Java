package _8kyu;

/*
Bob needs a fast way to calculate the volume of a cuboid with three values:
the length, width and height of the cuboid. Write a function to help Bob with this calculation. (volume=a*b*c)
 */
public class CW29_VolumeOfACuboid {
    public static void main(String[] args) {
        System.out.println(getVolumeOfCuboid(3, 4, 5));
    }

    public static double getVolumeOfCuboid(final double length, final double width, final double height) {
        return length * width * height;
    }
}

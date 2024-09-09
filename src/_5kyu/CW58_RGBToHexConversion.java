package _5kyu;

/*
The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal
representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range
must be rounded to the closest valid value.

Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.

Examples (input --> output):
255, 255, 255 --> "FFFFFF"
255, 255, 300 --> "FFFFFF"
0, 0, 0       --> "000000"
148, 0, 211   --> "9400D3"
 */
public class CW58_RGBToHexConversion {
    public static void main(String[] args) {
        System.out.println(rgb(148, 0, 211)); // 9400D3
        System.out.println(rgb(0, 0, 0)); // 000000
        System.out.println(rgb(255, 255, 255)); // FFFFFF
        System.out.println(rgb(255, 255, 300)); // FFFFFF
        System.out.println(rgb(254, 253, 252)); // FEFDFC
    }

    public static String rgb(int r, int g, int b) {

        r = clamp(r);
        g = clamp(g);
        b = clamp(b);

        String a = Integer.toHexString(r);
        String s = Integer.toHexString(g);
        String d = Integer.toHexString(b);

        return String.format("%2s%2s%2s", a, s, d).toUpperCase().replaceAll(" ", "0");


        // chatGPT:
//        return String.format("%02X%02X%02X", clamp(r), clamp(g), clamp(b));
    }

    private static int clamp(int value) {
        return Math.max(0, Math.min(value, 255));
    }
}

package _5kyu;

/*
You have been hired by a major MP3 player manufacturer to implement a new music compression standard.
In this kata you will implement the ENCODER, and its companion kata deals with the DECODER.
It can be considered a harder version of Range Extraction.

Specification
The input signal is represented as an array of integers. Several cases of regularities can be shortened.

A sequence of 2 or more identical numbers is shortened as number*count
A sequence of 3 or more consecutive numbers is shortened as first-last. This is true for both ascending and descending order
A sequence of 3 or more numbers with the same interval is shortened as first-last/interval. Note that the interval does NOT need a sign
Compression happens left to right

Examples
[1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20] is compressed to "1,3-5,7-11,14,15,17-20"
[0, 2, 4, 5, 7, 8, 9] is compressed to "0-4/2,5,7-9"
[0, 2, 4, 5, 7, 6, 5] is compressed to "0-4/2,5,7-5"
[0, 2, 4, 5, 7, 6, 5, 5, 5, 5, 5] is compressed to "0-4/2,5,7-5,5*4"

Input
A non-empty array of integers

Output
A string of comma-separated integers and sequence descriptors
 */
public class CW22_ASimpleMusicEncoder {
    public static void main(String[] args) {
        System.out.println(compress(new int[]{1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})); // "1,3-5,7-11,14,15,17-20"
        System.out.println(compress(new int[]{0, 2, 4, 5, 7, 6, 5, 5, 5, 5, 5})); // "0-4/2,5,7-5,5*4"
        System.out.println(compress(new int[]{0, 2, 4, 5, 7, 8, 9})); // "0-4/2,5,7-9"
        System.out.println(compress(new int[]{0, 2, 4, 5, 7, 6, 5})); // "0-4/2,5,7-5"
        System.out.println(compress(new int[]{1, 1, 2, 3, 4, 5, 7, 9})); // "1*2,2-5,7,9"
        System.out.println(compress(new int[]{1, 2, 2, 3})); // "1,2*2,3"
    }

    static StringBuilder result = new StringBuilder();
    static int startIdx = 0;
    static int sequencePrev = 0;

    public static String compress(int[] raw) {

        if (raw.length == 0) return "";

        result = new StringBuilder();
        startIdx = 0;
        sequencePrev = raw.length > 1 ? raw[1] - raw[0] : 0;

        for (int i = 1; i < raw.length; i++) {
            int sequenceCurrent = raw[i] - raw[i - 1];
            if (sequenceCurrent != sequencePrev) {
                appendSequence(raw, i);
                if (startIdx == i) {
                    sequencePrev = i < raw.length - 1 ? raw[i + 1] - raw[i] : 0;
                } else {
                    sequencePrev = raw[i] - raw[i - 1];
                }
            }
        }
        appendSequence(raw, raw.length);

        return result.substring(0, result.length() - 1);
    }

    private static void appendSequence(int[] raw, int i) {
        int quantity = i - startIdx;
        if (sequencePrev == 0) {
            if (quantity > 1) {
                result.append(raw[startIdx]).append("*").append(quantity);
                startIdx = i;
            } else {
                result.append(raw[startIdx]);
                startIdx = i - 1;
            }
        } else if (Math.abs(sequencePrev) == 1) {
            if (quantity > 2) {
                result.append(raw[startIdx]).append("-").append(raw[i - 1]);
                startIdx = i;
            } else {
                result.append(raw[startIdx]);
                if (quantity == 2 && raw.length == i) result.append(",").append(raw[startIdx + 1]);
                startIdx = i - 1;
            }
        } else {
            if (quantity > 2) {
                result.append(raw[startIdx]).append("-").append(raw[i - 1]).append("/").append(Math.abs(sequencePrev));
                startIdx = i;
            } else {
                result.append(raw[startIdx]);
                if (quantity == 2 && raw.length == i) result.append(",").append(raw[startIdx + 1]);
                startIdx = i - 1;
            }
        }
        result.append(",");
    }
}

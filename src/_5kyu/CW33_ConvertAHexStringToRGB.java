package _5kyu;

import java.util.HashMap;

/*
When working with color values it can sometimes be useful to extract the individual red, green, and blue (RGB)
component values for a color. Implement a function that meets these requirements:

Accepts a case-insensitive hexadecimal color string as its parameter (ex. "#FF9933" or "#ff9933")
Returns a Map<String, int> with the structure {r: 255, g: 153, b: 51} where r, g, and b range from 0 through 255
Note: your implementation does not need to support the shorthand form of hexadecimal notation (ie "#FFF")

Example
"#FF9933" --> {r: 255, g: 153, b: 51}
 */
public class CW33_ConvertAHexStringToRGB {
    public static void main(String[] args) {
        System.out.println(hexStringToRGB("#FF9933")); // {r: 255, g: 153, b: 51}
        System.out.println(hexStringToRGB("#Ba8A59")); // {r: 186, g: 138, b: 89}
    }

    public static HashMap<String, Integer> hexStringToRGB(String hex) {

        if (hex.length() == 4)
            hex = "#" + hex.charAt(1) + hex.charAt(1) + hex.charAt(2) + hex.charAt(2) + hex.charAt(3) + hex.charAt(3);

        HashMap<String, Integer> result = new HashMap<>();
        result.put("r", Integer.parseInt(hex.substring(1, 3), 16));
        result.put("g", Integer.parseInt(hex.substring(3, 5), 16));
        result.put("b", Integer.parseInt(hex.substring(5), 16));

        return result;
    }
}

package _7kyu;

/*
Given a string made up of letters a, b, and/or c, switch the position of letters a and b
(change a to b and vice versa). Leave any incidence of c untouched.

Example:
'acb' --> 'bca'
'aabacbaa' --> 'bbabcabb'
 */
public class CW11_Switcheroo {
    public static void main(String[] args) {
        System.out.println(switcheroo("aabacbaa"));
    }

    public static String switcheroo(String x) {
        return x.replaceAll("a", "#").replaceAll("b", "a").replaceAll("#", "b");
    }
}

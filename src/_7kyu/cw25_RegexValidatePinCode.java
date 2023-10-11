package _7kyu;

/*
ATMs allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.

If the function is passed a valid PIN string, return true, else return false.

Examples (Input --> Output)
"1234"   -->  true
"12345"  -->  false
"a234"   -->  false
 */
public class cw25_RegexValidatePinCode {
    public static void main(String[] args) {
        System.out.println(validatePin("123654"));
    }

    public static boolean validatePin(String pin) {
        return pin.equals(pin.replaceAll("[^0-9]", "")) && (pin.length() == 4 || pin.length() == 6);

        // taylormb, malbera, user3939291, kevind123, Judson Birkel, zerox029, Cv072124, M_Andreev, VladimirDobrev, jik-tak (+ 15)
//        return pin.matches("\\d{4}|\\d{6}");
        // hexnov, Joker, karolgrucha, N2gether, KillMaster, ctantri, neDexter, ntickoo, ssindelar, Miroslav Vasilev (+ 148)
//        return pin.matches("[0-9]{4}|[0-9]{6}");
    }
}

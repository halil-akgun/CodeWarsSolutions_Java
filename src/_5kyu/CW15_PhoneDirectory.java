package _5kyu;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
John keeps a backup of his old personal phone book as a text file. On each line of the file he can find the phone number
(formated as +X-abc-def-ghij where X stands for one or two digits), the corresponding name between < and > and the address.

Unfortunately everything is mixed, things are not always in the same order; parts of lines are cluttered with
non-alpha-numeric characters (except inside phone number and name).

Examples of John's phone book lines:
"/+1-541-754-3010 156 Alphand_St. <J Steeve>\n"
" 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
"<Anastasia> +48-421-674-8974 Via Quirinal Roma\n"

Could you help John with a program that, given the lines of his phone book and a phone number num returns a string
for this number : "Phone => num, Name => name, Address => adress"

Examples:
s = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
phone(s, "1-541-754-3010") should return "Phone => 1-541-754-3010, Name => J Steeve, Address => 156 Alphand St."
It can happen that there are many people for a phone number num, then return : "Error => Too many people: num"
or it can happen that the number num is not in the phone book, in that case return: "Error => Not found: num"
 */
public class CW15_PhoneDirectory {
    public static void main(String[] args) {
        String s1 = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n";
        String s2 = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n";
        String s3 = "/+5-555-555-5555 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+5-555-555-5555!\n";
        System.out.println(phone(s1, "1-541-754-3010")); // "Phone => 1-541-754-3010, Name => J Steeve, Address => 156 Alphand St."
        System.out.println(phone(s2, "1-302-384-3010")); // "Error => Not found: 1-302-384-3010"
        System.out.println(phone(s3, "5-555-555-5555")); // "Error => Too many people: 5-555-555-5555"
    }

    public static String phone(String strng, String num) {
        List<Person> list = new ArrayList<>();
        String[] lines = strng.split("\\n");
        for (String line : lines) {
            list.add(parse(line));
        }

        List<Person> result = list.stream().filter(p -> p.phone.equals(num)).toList();

        if (result.size() == 1) {
            return "Phone => " + result.getFirst().phone + ", Name => " + result.getFirst().name + ", Address => " + result.getFirst().address;
        } else if (result.size() > 1) {
            return "Error => Too many people: " + num;
        } else {
            return "Error => Not found: " + num;
        }


        // dashengz, jackjack321, bkoltun, kicilinsky, MrDoge1337, EmilLubomirov, Erbolcode, Okenov-Nursen, Stalbek0, Sulaiman-Kudaibergenov (+ 2):
//        String found = null;
//        int count = 0;
//        for (String entry : strng.split("\n"))
//            if (entry.contains("+" + num)) {
//                found = entry;
//                count++;
//            }
//
//        // error cases
//        if (count == 0) return "Error => Not found: " + num;
//        if (count > 1) return "Error => Too many people: " + num;
//
//        // process found entry
//        String name = found.split("<|>")[1];
//        String address = found
//                .replace(name, "").replace(num, "") // only address left
//                .replaceAll("[^A-Za-z0-9\\. -]", " ") // filter all unnecessary chars
//                .trim().replaceAll(" +", " "); // reduce extra spaces
//
//        return "Phone => " + num + ", Name => " + name + ", Address => " + address;
    }

    private static Person parse(String line) {
        Pattern phonePattern = Pattern.compile("\\+\\d{1,2}-\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher = phonePattern.matcher(line);
        String phone = matcher.find() ? matcher.group().substring(1) : "";
        String name = line.substring(line.indexOf("<") + 1, line.indexOf(">"));
        String address = line
                .replaceAll("\\+" + phone, "")
                .replaceAll("<" + name + ">", "")
                .replaceAll("[^A-Za-z0-9.\\-_ ]", "")
                .replaceAll("\\s+", " ")
                .replaceAll("_", " ")
                .trim();
        return new Person(name, phone, address);
    }

    static class Person {
        String name;
        String phone;
        String address;

        public Person(String name, String phone, String address) {
            this.name = name;
            this.phone = phone;
            this.address = address;
        }
    }
}

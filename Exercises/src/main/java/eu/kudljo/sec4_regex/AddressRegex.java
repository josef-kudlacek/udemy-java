package eu.kudljo.sec4_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressRegex {
    public static void main(String[] args) {
        // address in Italy format: Street, City, State/Province/Area, ZipCode, Country
        String address = """
        Vicolo Tre Marchetti 116
        Cison Di Valmarino
        Trento
        38033
        Italy
        """;

        String regex = """
        (?<street>\\w+(\\s+\\w+)*\\d{0,6}).*
        (?<city>\\w+(\\s+\\w+)*).*
        (?<state>\\w+).*
        (?<zipCode>\\d{5}).*
        (?<country>\\w+).*
        """;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);

        if (matcher.matches()) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group("street"));
            System.out.println(matcher.group("city"));
            System.out.println(matcher.group("state"));
            System.out.println(matcher.group("zipCode"));
            System.out.println(matcher.group("country"));
        }
    }
}

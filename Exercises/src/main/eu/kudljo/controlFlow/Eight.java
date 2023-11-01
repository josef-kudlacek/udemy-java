package eu.kudljo.controlFlow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eight {
    public static void main(String[] args) {
        String addresses = """
                12345 First Street, First City, AA 90210
                22222 Second Street, Second City, BB 22222
                33333 Third Street, Third City, CC 33333
                44444 Fourth Street, Fourth City, DD 44444
                55555 Fifth Street, Fifth City, EE 55555
                66666 Sixth Street, Sixth City, FF 66666
                77777 Seventh Street, Seventh City, GG 77777
                88888 Eighth Street, Eighth City, HH 88888
                99999 Ninth Street, Ninth City, II 99999
                00000 Tenth Street, Tenth City, JJ 00000
                """;

        String regex = """
        (?<streetNumber>\\d{0,5})
        (?<streetName>\\s+(\\w+\\s+\\w+)),
        (?<cityName>\\s+(\\w+\\s+\\w+)),
        (?<state>\\s+([A-Z]{2}))\\s+
        (?<zipCode>\\d{5})
        """;

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(addresses);

        while (matcher.find()) {
            System.out.printf("%s %s %s %s %s%n",
                    matcher.group("streetNumber"),
                    matcher.group("streetName"),
                    matcher.group("cityName"),
                    matcher.group("state"),
                    matcher.group("zipCode")
            );
        }
    }
}

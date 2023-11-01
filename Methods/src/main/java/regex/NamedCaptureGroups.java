package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamedCaptureGroups {
    public static void main(String[] args) {
        String phoneNumberChallenge = "1.321-333-7652";
        // un-captured group with symbol '?:', naming capture group with ?<name>
        String regex = "(?:(?<countryCode>\\d{1,2})[-.\\s]?)(?:(?<areaCode>\\d{3})[-.\\s]?)(?:(?<exchange>\\d{3})[-.\\s]?)?(?<lineNumber>\\d{3,})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumberChallenge);

        if (matcher.matches()) {
            System.out.format("Country code: %s\n", matcher.group("countryCode"));
            System.out.format("Area code: %s\n", matcher.group("areaCode"));
            System.out.format("Exchange: %s\n", matcher.group("exchange"));
            System.out.format("Line number: %s\n", matcher.group("lineNumber"));
        }
    }
}

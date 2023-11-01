package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentRegex {
    public static void main(String[] args) {
        String phoneNumberChallenge = "1.321-333-7652";
        // un-captured group with symbol '?:', naming capture group with ?<name>
        String regex = """
# This is my regex to parse the parts of a phone number
(?:(?<countryCode>\\d{1,2})[-.\\s]?) # Get's country code
(?:(?<areaCode>\\d{3})[-.\\s]?) # Get' area code
(?:(?<exchange>\\d{3})[-.\\s]?)? # Get's exchange
(?<lineNumber>\\d{3,}) # Get's line number
""";

        Pattern pattern = Pattern.compile(regex, Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(phoneNumberChallenge);

        if (matcher.matches()) {
            System.out.format("Country code: %s\n", matcher.group("countryCode"));
            System.out.format("Area code: %s\n", matcher.group("areaCode"));
            System.out.format("Exchange: %s\n", matcher.group("exchange"));
            System.out.format("Line number: %s\n", matcher.group("lineNumber"));
        }
    }
}

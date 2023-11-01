package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaptureGroups {
    public static void main(String[] args) {
        String phoneNumberChallenge = "1.321-333-7652";
        String regex = "((\\d{1,2})[-.\\s]?)((\\d{3})[-.\\s]?)((\\d{3})[-.\\s]?)?(\\d{3,})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumberChallenge);

        if (matcher.matches()) {
            // System.out.println(matcher.group(0)); - whole regex match
            System.out.format("Country code: %s\n", matcher.group(2));
            System.out.format("Area code: %s\n", matcher.group(4));
            System.out.format("Exchange: %s\n", matcher.group(6));
            System.out.format("Line number: %s\n", matcher.group(7));
        }
    }
}

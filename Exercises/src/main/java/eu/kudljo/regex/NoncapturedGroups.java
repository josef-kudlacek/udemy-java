package eu.kudljo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoncapturedGroups {
    public static void main(String[] args) {
        String wordOne = "Abracadabra";
        String wordTwo = "Agracadagra";

        String regex = "(?:<firstGroup>A\\w{3}).*(?:<secondGroup>\\w{3})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(wordOne);

        if (matcher.matches()) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group("firstGroup"));
            System.out.println(matcher.group("secondGroup"));
        }

        matcher = pattern.matcher(wordTwo);
        if (matcher.matches()) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group("firstGroup"));
            System.out.println(matcher.group("secondGroup"));
        }
    }
}

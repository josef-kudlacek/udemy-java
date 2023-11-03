package eu.kudljo.sec4_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {
    public static void main(String[] args) {
        String email = "first.last@domain.com";

        String regex = "(\\w+.)*\\w+@\\w+.\\w+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println(matcher.group());
        }
    }
}

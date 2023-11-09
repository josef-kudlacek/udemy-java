package eu.kudljo.sec4_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArkRegex {
    public static void main(String[] args) {
        String dark = "dark";
        String bark = "bark";
        String lark = "Lark";
        String stark = "stark";

        String regex = "\\w+ark";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(dark);
        if (matcher.matches()) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(0));
        }

        matcher = pattern.matcher(bark);
        if (matcher.matches()) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(0));
        }

        matcher = pattern.matcher(lark);
        if (matcher.matches()) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(0));
        }

        matcher = pattern.matcher(stark);
        if (matcher.matches()) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(0));
        }
    }
}

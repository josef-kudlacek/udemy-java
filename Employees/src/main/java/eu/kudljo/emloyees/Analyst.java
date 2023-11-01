package eu.kudljo.emloyees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst {

    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int projectCount = 0;

    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    private final Pattern peoplePattern = Pattern.compile(peopleRegex);

    private final String anaRegex = "\\w+=(?<projectCount>\\w+)";
    private final Pattern anaPattern = Pattern.compile(anaRegex);

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    public Analyst(String personText) {
        Matcher peopleMatcher = peoplePattern.matcher(personText);
        if (peopleMatcher.find()) {
            this.lastName = peopleMatcher.group("lastName");
            this.firstName = peopleMatcher.group("firstName");
            this.dob = LocalDate.from(dateTimeFormatter.parse(peopleMatcher.group("dob")));

            Matcher analystMatcher = anaPattern.matcher(peopleMatcher.group("details"));
            if (analystMatcher.find()) {
                this.projectCount = Integer.parseInt(analystMatcher.group("projectCount"));
            }
        }
    }

    public int getSalary() {
        return 2500 + projectCount * 2;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormatter.format(getSalary()));
    }
}

package eu.kudljo.emloyees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nobody implements Employee {

    private String lastName;
    private String firstName;
    private LocalDate dob;

    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)})?\\n";
    private final Pattern peoplePattern = Pattern.compile(peopleRegex);

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    private final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    public Nobody(String personText) {
        Matcher peopleMatcher = peoplePattern.matcher(personText);
        if (peopleMatcher.find()) {
            this.lastName = peopleMatcher.group("lastName");
            this.firstName = peopleMatcher.group("firstName");
            this.dob = LocalDate.from(dateTimeFormatter.parse(peopleMatcher.group("dob")));
        }
    }

    @Override
    public int getSalary() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormatter.format(getSalary()));
    }
}

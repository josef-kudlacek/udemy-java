package eu.kudljo.emloyees;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee {

    private int projectCount = 0;

    private final String anaRegex = "\\w+=(?<projectCount>\\w+)";
    private final Pattern anaPattern = Pattern.compile(anaRegex);

    public Analyst(String personText) {
        super(personText);
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

    @Override
    public int getSalary() {
        return 2500 + projectCount * 2;
    }

}

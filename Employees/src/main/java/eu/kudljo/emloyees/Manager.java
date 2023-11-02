package eu.kudljo.emloyees;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee {

    private int organizationSize = 0;
    private int directReports = 0;

    private final String mngRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
    private final Pattern mngPattern = Pattern.compile(mngRegex);


    public Manager(String personText) {
        super(personText);
        Matcher peopleMatcher = peoplePattern.matcher(personText);
        if (peopleMatcher.find()) {
            this.lastName = peopleMatcher.group("lastName");
            this.firstName = peopleMatcher.group("firstName");
            this.dob = LocalDate.from(dateTimeFormatter.parse(peopleMatcher.group("dob")));

            Matcher mngMatcher = mngPattern.matcher(peopleMatcher.group("details"));
            if (mngMatcher.find()) {
                this.organizationSize = Integer.parseInt(mngMatcher.group("orgSize"));
                this.directReports = Integer.parseInt(mngMatcher.group("dr"));
            }
        }
    }

    @Override
    public int getSalary() {
        return 3500 + organizationSize * directReports;
    }

}

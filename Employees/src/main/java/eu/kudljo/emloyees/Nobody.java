package eu.kudljo.emloyees;

import java.time.LocalDate;
import java.util.regex.Matcher;

public class Nobody extends Employee {

    public Nobody(String personText) {
        super(personText);
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

}

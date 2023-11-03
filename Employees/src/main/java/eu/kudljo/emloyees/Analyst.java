package eu.kudljo.emloyees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee implements IEmployee, DummyInterface {

    private int projectCount = 0;

    private final String anaRegex = "\\w+=(?<projectCount>\\w+)";
    private final Pattern anaPattern = Pattern.compile(anaRegex);

    public Analyst(String personText) {
        super(personText);

        Matcher analystMatcher = anaPattern.matcher(peopleMatcher.group("details"));
        if (analystMatcher.find()) {
            this.projectCount = Integer.parseInt(analystMatcher.group("projectCount"));
        }
    }

    @Override
    public int getSalary() {
        return 2500 + projectCount * 2;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }
}

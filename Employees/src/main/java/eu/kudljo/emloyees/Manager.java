package eu.kudljo.emloyees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee implements IEmployee, DummyInterface {

    private int organizationSize = 0;
    private int directReports = 0;

    private final String mngRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
    private final Pattern mngPattern = Pattern.compile(mngRegex);


    public Manager(String personText) {
        super(personText);

        Matcher mngMatcher = mngPattern.matcher(peopleMatcher.group("details"));
        if (mngMatcher.find()) {
            this.organizationSize = Integer.parseInt(mngMatcher.group("orgSize"));
            this.directReports = Integer.parseInt(mngMatcher.group("dr"));
        }
    }

    @Override
    public int getSalary() {
        return 3500 + organizationSize * directReports;
    }

    public int getOrganizationSize() {
        return organizationSize;
    }

    public void setOrganizationSize(int organizationSize) {
        this.organizationSize = organizationSize;
    }

    public int getDirectReports() {
        return directReports;
    }

    public void setDirectReports(int directReports) {
        this.directReports = directReports;
    }
}

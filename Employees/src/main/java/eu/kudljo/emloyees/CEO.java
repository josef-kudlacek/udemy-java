package eu.kudljo.emloyees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements IEmployee, DummyInterface {

    private int avgStockPrice = 0;

    private final String ceoRegex = "\\w+=(?<avgStockPrice>\\w+)";
    private final Pattern ceoPattern = Pattern.compile(ceoRegex);

    public CEO(String personText) {
        super(personText);

        Matcher ceoMatcher = ceoPattern.matcher(peopleMatcher.group("details"));
        if (ceoMatcher.find()) {
            this.avgStockPrice = Integer.parseInt(ceoMatcher.group("avgStockPrice"));
        }
    }

    @Override
    public int getSalary() {
        return 5000 * avgStockPrice;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormatter.format(getSalary()));
    }
}

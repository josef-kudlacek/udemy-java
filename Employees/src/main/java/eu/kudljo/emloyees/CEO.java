package eu.kudljo.emloyees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee {

    private int avgStockPrice = 0;

    private final String ceoRegex = "\\w+=(?<avgStockPrice>\\w+)";
    private final Pattern ceoPattern = Pattern.compile(ceoRegex);
    private final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    public CEO(String personText) {
        super(personText);
        Matcher peopleMatcher = peoplePattern.matcher(personText);
        if (peopleMatcher.find()) {
            this.lastName = peopleMatcher.group("lastName");
            this.firstName = peopleMatcher.group("firstName");
            this.dob = LocalDate.from(dateTimeFormatter.parse(peopleMatcher.group("dob")));

            Matcher ceoMatcher = ceoPattern.matcher(peopleMatcher.group("details"));
            if (ceoMatcher.find()) {
                this.avgStockPrice = Integer.parseInt(ceoMatcher.group("avgStockPrice"));
            }
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

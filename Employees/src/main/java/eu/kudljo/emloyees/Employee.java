package eu.kudljo.emloyees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee {

    protected String lastName;
    protected String firstName;
    protected LocalDate dob;
    private static final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)})?\\n";
    public static final Pattern PEOPLE_REGEX = Pattern.compile(peopleRegex);
    protected final Matcher peopleMatcher;
    protected final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    protected final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    protected Employee() {
        peopleMatcher = null;
        lastName = "N/A";
        firstName = "N/A";
        dob = null;
    }

    protected Employee(String personText) {
        peopleMatcher = Employee.PEOPLE_REGEX.matcher(personText);
        if (peopleMatcher.find()) {
            this.lastName = peopleMatcher.group("lastName");
            this.firstName = peopleMatcher.group("firstName");
            this.dob = LocalDate.from(dateTimeFormatter.parse(peopleMatcher.group("dob")));
        }
    }

    // Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
    public static Employee createEmployee(String employeeText) {
        Matcher peopleMatcher = Employee.PEOPLE_REGEX.matcher(employeeText);

        class MyLocalClass extends Employee {
            public int getSalary() {
                return 0;
            }
        }

        if (peopleMatcher.find()) {
            return switch (peopleMatcher.group("role")) {
                case "Programmer" -> new Programmer(employeeText);
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
                default -> new Employee() { // anonymous class
                    @Override
                    public int getSalary() {
                        return 0;
                    }
                };
            };
        } else {
            return new DummyEmployee();
        }
    }

    public abstract int getSalary();

    public double getBonus() {
        return getSalary() * 1.10;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s - %s", lastName, firstName, moneyFormatter.format(getSalary()), moneyFormatter.format(getBonus()));
    }

    private static final class DummyEmployee extends Employee {

        @Override
        public int getSalary() {
            return 0;
        }
    }


}

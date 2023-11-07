package eu.kudljo.emloyees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee {

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
    public static IEmployee createEmployee(String employeeText) {
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
                default -> new DummyEmployee();
            };
        } else {
            return new DummyEmployee();
        }
    }

    public abstract int getSalary();

    public double getBonus() {
        return getSalary() * 1.10;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s - %s", lastName, firstName, moneyFormatter.format(getSalary()), moneyFormatter.format(getBonus()));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(lastName, employee.lastName) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(dob, employee.dob) &&
                getClass().equals(object.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, dob, getClass());
    }

    private static final class DummyEmployee extends Employee {

        @Override
        public int getSalary() {
            return 0;
        }
    }

    @Override
    public int compareTo(IEmployee o) {
        Employee other = (Employee) o;
        // Because of same last name will tree set evaluate some employees as same and not store them:
        return this.getFirstName().compareTo(other.getFirstName());
    }

    public record Jumper(String firstName, String lastName) {
    }

}

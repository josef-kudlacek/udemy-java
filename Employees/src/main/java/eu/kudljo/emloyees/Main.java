package eu.kudljo.emloyees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String people = """
                Flintstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flintstone, Fred, 1/1/1900, Programmerzz, {locpd=2000,yoe=10,iq=140}
                Flintstone2, Fred, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
                Flintstone3, Fred, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
                Flintstone4, Fred, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
                Flintstone5, Fred, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                Rubble2, Barney, 2/2/1905, Manager, {orgSize=100,dr=4}
                Rubble3, Barney, 2/2/1905, Manager, {orgSize=200,dr=2}
                Rubble4, Barney, 2/2/1905, Manager, {orgSize=500,dr=8}
                Rubble5, Barney, 2/2/1905, Manager, {orgSize=175,dr=20}
                Flintstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
                Flintstone2, Wilma, 3/3/1910, Analyst, {projectCount=4}
                Flintstone3, Wilma, 3/3/1910, Analyst, {projectCount=5}
                Flintstone4, Wilma, 3/3/1910, Analyst, {projectCount=6}
                Flintstone5, Wilma, 3/3/1910, Analyst, {projectCount=9}
                Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
                """;

        Matcher peopleMatcher = Employee.PEOPLE_REGEX.matcher(people);

        //Programmer coder = new Programmer("");
        //coder.cook("Hamburger");

        int totalSalaries = 0;
        // Prefer the most generic instance of object to use.
        IEmployee employee;
        List<IEmployee> employeeList = new ArrayList<>();
        while (peopleMatcher.find()) {
            employee = Employee.createEmployee(peopleMatcher.group());
            employeeList.add(employee);

//            String specificRoleText;
//            // Check instance of employee and cast to variable
//            if (employee instanceof Programmer programmer) {
//                specificRoleText = String.format("Programmer (iq: %d, code: %d, experience: %d)",
//                        programmer.getIq(), programmer.getLinesOfCode(), programmer.getYearsOfExp());
//            } else if (employee instanceof Manager manager) {
//                specificRoleText = String.format("Manager (size of organization: %d, reports: %d)",
//                        manager.getOrganizationSize(), manager.getDirectReports());
//            } else if (employee instanceof Analyst analyst) {
//                specificRoleText = String.format("Analyst (count of projects: %d)",
//                        analyst.getProjectCount());
//            } else if (employee instanceof CEO ceo) {
//                specificRoleText = String.format("CEO (average of stock price: %d)",
//                        ceo.getAvgStockPrice());
//            } else {
//                specificRoleText = "N/A:";
//            }
//
//            System.out.printf("%s: %s%n", specificRoleText, employee);
            // Example of usage of polymorphism for get employee's salary:
//            totalSalaries += employee.getSalary();
        }

        for (IEmployee employeeElement : employeeList) {
            System.out.println(employeeElement.toString());
            totalSalaries += employeeElement.getSalary();
        }

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("The total payout should be %s%n", currencyInstance.format(totalSalaries));

        Weirdo dirt = new Weirdo("Dirt", "Joe", LocalDate.of(2000, 11, 2));
//        System.out.println(dirt.lastName());
        // Only way to change properties
        Weirdo betterWeirdo = new Weirdo(dirt.lastName() + "Better", dirt.firstName(), dirt.dob());
        Weirdo jake = new Weirdo("Snake", "Jake");
        jake.sayHello();
    }
}

package eu.kudljo.emloyees;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;

public class Main {

    private static Set<IEmployee> employees;
    private static Map<String, Integer> employeeMap;

    public static void main(String[] args) {
        String people = """
                Flintstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flintstone, Fred, 1/1/1900, Programmer, {locpd=4000,yoe=10,iq=140}
                Flintstone, Fred, 1/1/1900, Programmer, {locpd=5000,yoe=10,iq=140}
                Flintstone, Fred, 1/1/1900, Programmer, {locpd=6000,yoe=10,iq=140}
                Flintstone, Fred, 1/1/1900, Programmer, {locpd=7000,yoe=10,iq=140}
                Flintstone, Fred, 1/1/1900, Programmer, {locpd=9000,yoe=10,iq=140}
                Flintstone, Fred, 1/1/1900, Programmerzz, {locpd=9000,yoe=10,iq=140}
                Flintstone2, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
                Flintstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
                Flintstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
                Flintstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
                Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
                Rubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
                Rubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
                Flintstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
                Flintstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
                Flintstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
                Flintstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
                Flintstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
                Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
                """;

        Matcher peopleMatcher = Employee.PEOPLE_REGEX.matcher(people);

        int totalSalaries = 0;
        // Prefer the most generic instance of object to use.
        IEmployee employee;
        employees = new TreeSet<>();
        employeeMap = new LinkedHashMap<>();
        while (peopleMatcher.find()) {
            employee = Employee.createEmployee(peopleMatcher.group());
            Employee emp = (Employee) employee;
            employees.add(employee);
            employeeMap.putIfAbsent(emp.firstName, emp.getSalary()); // duplicated values will not be replaced with new one
        }

        for (IEmployee employeeElement : employees) {
            System.out.println(employeeElement.toString());
            totalSalaries += employeeElement.getSalary();
        }

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("The total payout should be %s%n", currencyInstance.format(totalSalaries));
        System.out.println(employees.size());
        System.out.println(employeeMap.keySet());
        System.out.println(employeeMap.values());
        for (Map.Entry<String, Integer> entry : employeeMap.entrySet()) {
            System.out.printf("Key = %s, Value = %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println(employeeMap.containsKey("Wilma"));
        System.out.println(employeeMap.containsValue("2508"));
    }

    public int getSalary(String firstName) {
        return employeeMap.getOrDefault(firstName, -1);
    }
}

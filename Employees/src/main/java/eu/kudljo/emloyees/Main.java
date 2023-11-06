package eu.kudljo.emloyees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String people = """
                Flintstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flintstone, Fred, 1/1/1900, Programmerzz, {locpd=2000,yoe=10,iq=140}
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

        //Programmer coder = new Programmer("");
        //coder.cook("Hamburger");

        int totalSalaries = 0;
        // Prefer the most generic instance of object to use.
        IEmployee employee;
        List<IEmployee> employeeList = new ArrayList<>(16); // Initialization with knowing size of elements
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

        employeeList.remove(0);
        employeeList.remove(1);
        employeeList.remove(2);

        employeeList.add(0, new Programmer("Flintstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}\n"));

        // Replacing element in list based on index
        employeeList.set(0, Employee.createEmployee("Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}\n"));

        // Creating sublist of list
        List<IEmployee> employeeSublist = employeeList.subList(0, 3);

        // Creating array from array
        Object[] genericEmployeeArray = employeeList.toArray();
        IEmployee[] employeeAnotherList = employeeList.toArray(new IEmployee[employeeList.size()]);

        // Unmodifiable list
        List<String> undesirableFirstNames = List.of("Wilma5", "Barney4", "Fred2");
        // This list can be modifiable
        undesirableFirstNames = new ArrayList<>(List.of("Wilma5", "Barney4", "Fred2"));
        undesirableFirstNames.sort(Comparator.reverseOrder()); // pre-implemented comparators
        System.out.println(undesirableFirstNames);
        removeUndesirables(employeeList, undesirableFirstNames);

        // Example of contains method
        IEmployee myEmployee = employeeList.get(5);
        System.out.println("Is my employee contained in list? " + employeeList.contains(myEmployee));

        // Example of contains method – false is caused because method of equals for comparing is not override correctly
        // Without overriding equals method equals will only compare address in memory
        IEmployee employeeCreated = Employee.createEmployee("Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}\n");
        System.out.println("Is my created employee contained in list? " + employeeList.contains(employeeCreated));
        System.out.println("Is my created employee equaled to employee from list? " + myEmployee.equals(employeeCreated));

        List<String> newStrings = new ArrayList<>();
        newStrings.addAll(undesirableFirstNames);
        System.out.println(newStrings.size());

        Collections.sort(employeeList, Comparator.reverseOrder());

//        employeeList.sort((o1, o2) -> {
//            if (o1 instanceof Employee employee1 && o2 instanceof Employee employee2) {
//                int lastNameResult = employee1.getLastName().compareTo(employee2.getLastName());
//                return (lastNameResult != 0) ? lastNameResult :
//                        Integer.compare(employee2.getSalary(), employee1.getSalary());
//            }
//
//            return 0;
//        });

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

    private static void removeUndesirables(List<IEmployee> employeeList, List<String> removalFirstNames) {
        for (Iterator<IEmployee> iterator = employeeList.iterator(); iterator.hasNext(); ) {
            IEmployee employeeIterator = iterator.next();
            // Check class including subclasses
            if (employeeIterator instanceof Employee employeeTemp) {
                if (removalFirstNames.contains(employeeTemp.getFirstName())) {
                    iterator.remove();
                }
            }
        }
    }
}

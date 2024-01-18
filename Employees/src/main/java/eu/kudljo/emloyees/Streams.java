package eu.kudljo.emloyees;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Streams {
    public static void main(String[] args) {
        String peopleText = """
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

//        try {
//            Files.lines(Path.of("C:\\Users\\Pepa Kudláček\\IdeaProjects\\udemy-java\\Employees\\src\\main\\java\\eu\\kudljo\\emloyees\\employees.txt"))
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//

//        Predicate<String> dummyEmployeeSelector = s -> s.contains("Programmerzz");
        Predicate<Employee> employeePredicate = employee -> "N/A".equals(employee.getLastName());
        Predicate<Employee> underFiveKSelector = employee -> employee.getSalary() < 5000;
        Predicate<Employee> noDummiesAndUnderFiveK = employeePredicate.negate().and(underFiveKSelector);
        int sum = peopleText.lines()
//                .filter(not(s -> s.contains("Programmerzz")))
//                .filter(dummyEmployeeSelector.negate())
                .map(Employee::createEmployee)
                .map(employee -> (Employee) employee)
                .filter(noDummiesAndUnderFiveK)
                // usage of Predicate with NOT
//                .filter(not(employee -> employee instanceof Programmer))
//                .filter(not(employee -> "N/A".equals(employee.getLastName())))
//                .filter(employee -> employee.getSalary() > 5000)
//                .filter(employee -> employee.getSalary() < 10000)
                // remove duplicates by input them to Set
                .collect(Collectors.toSet()).stream()
                // nested sorting by multiple attributes
                .sorted(comparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName)
                        .thenComparingInt(Employee::getSalary)
                )
                .mapToInt(Streams::showEmployeeAndGetSalary)
                .sum();

        System.out.printf("%nSum of salaries is: %s", NumberFormat.getCurrencyInstance(Locale.US)
                .format(sum));


//        Collection<String> nums = Set.of("one", "two", "three", "four");
//        nums
//                .stream()
//                .map(String::hashCode)
//                .map(Integer::toHexString)
//                .forEach(System.out::println);
//
//        record Car(String make, String model){}
//
//        Stream.of(new Car("Ford", "Bronco"), new Car("Tesla", "X"), new Car("Tesla", "3"))
//                .filter(car -> "Tesla".equals(car.make))
//                .forEach(System.out::println);

        // Filter null values in stream
//        String myVar = null;
//        Stream myStream = null;
//
//        Stream.ofNullable(myVar)
//                .forEach(System.out::println);

        // Stream especially for integers
//        IntStream.rangeClosed(1, 40)
//                .mapToObj(String::valueOf)
//                .map(s -> s.concat("-"))
//                .forEach(System.out::print);

//        String[] names = {"terry", "sam", "jake"};
//        Arrays.stream(names)
//                .map(String::toUpperCase)
//                .forEach(System.out::println);
    }

    public static int showEmployeeAndGetSalary(IEmployee employee) {
        System.out.println(employee);

        return employee.getSalary();
    }
}

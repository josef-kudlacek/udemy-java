package eu.kudljo.emloyees;

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

        peopleText.lines()
//                .map(s -> Employee.createEmployee(s))
                .map(Employee::createEmployee)
                .forEach(System.out::println); // '::' is operator for referencing to methods
    }
}

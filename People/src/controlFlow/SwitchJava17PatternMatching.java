package controlFlow;

// When using JDK 17, preview of Java Switch for pattern matching have to be enabled from Project Structure > Language Level: 17 (Preview)
public class SwitchJava17PatternMatching {
    public static void main(String[] args) {
        record Person(String firstName, String lastName, int age) {}
        String var1 = "Hello World";
        Integer var2 = 34;
        String[] var3 = {"hello", "world"};
        Person var4 = new Person("Jake", "Johnson", 40);
        Person var5 = new Person("Abe", "Johnson", 40);

        Object object = null;
        switch (object) { // check about data types
            case String msg -> System.out.println(msg);
            case Integer num -> System.out.println("Your number is: " + num);
            case Person p && p.firstName().length() > 3 -> System.out.println("Looks like Jake");
            case String[] arr -> System.out.printf("Looks like an array with %d elements.", arr.length);
            case null -> System.out.println("It's null");
            default -> System.out.println("Have no idea");
            // null can be combined with default like this:
            // case null, default -> System.out.println("Have no idea");
        }
    }
}

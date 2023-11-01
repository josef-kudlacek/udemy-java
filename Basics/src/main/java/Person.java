import java.time.LocalDate;

public class Person {
    private String firstName; // "johnny"
    private String middleName = "Christopher";
    public String lastName;
    protected LocalDate dob;
    public static double PI = 3.14;
    public static int[] numbers = initNumbers();

    public Person() {

    }

    public Person(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    // static initializer
    static {
        numbers = new int[5];
        numbers[0] = 3;
        numbers[1] = 3;
        numbers[2] = 3;
        numbers[3] = 3;
    }

    // static initializer by static method
    public static int[] initNumbers() {
        int[] numbers = new int[5];
        numbers[0] = 3;
        numbers[1] = 3;
        numbers[2] = 3;
        numbers[3] = 3;

        return numbers;
    }

    public String getFirstName() {
        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public void saySomething(String message) {
        System.out.println(message);
    }

    public char getMiddleInitial() {
        return middleName.charAt(0);
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public void test(String[] words) {
        System.out.println(words[0]);
    }

    public void test2(int num1, int num2, String... words) {
        System.out.println(num1);
        System.out.println(num2);
        //String... varargs as array of Strings
        System.out.println(words[2]);
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.firstName = "Jake";
        person1.lastName = "Smith";

        person1.sayHello();
        person1.saySomething("My groovy message");
        person1.saySomething("Here's something else to say");

        char middleInitial = person1.getMiddleInitial();
        System.out.println(middleInitial);

        System.out.println(person1.add(5, 3));

        person1.test(new String[] {"one", "two", "three"});
        person1.test2(3, 6, "one", "two", "three");
        System.out.println(PI);

        Person johnny = new Person("johnny", "smith", LocalDate.of(2000, 11, 1));
        System.out.format("The person's first name is: %s.", johnny.getFirstName());
        johnny.setLastName("smith");
        System.out.format("The person's last name is: %s.", johnny.getLastName());
    }
}

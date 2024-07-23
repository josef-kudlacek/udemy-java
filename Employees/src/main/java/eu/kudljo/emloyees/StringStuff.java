package eu.kudljo.emloyees;

public class StringStuff {
    public static void main(String[] args) {
        int age = 5;
        String name = "Terry";

        System.out.printf("Hello my name is %s and I am %d year old. \n", name, age);
        System.out.println("Hello my name is " + name + " and I am " + age + " year old.");
        System.out.println(STR."Hello my name is \{name} and I am \{age + 10} year old.");
    }
}

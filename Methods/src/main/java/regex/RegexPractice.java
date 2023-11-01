package regex;

public class RegexPractice {
    public static void main(String[] args) {
        System.out.println("Gat".matches("[a-fA-F]at"));
        System.out.println("Cat".matches("[^a-z]at"));


        System.out.println("_a8".matches("\\w{3}")); // underscore is taken in regex as (w)ord, same for numbers
        System.out.println("8".matches("\\d")); // only numbers

        String phoneNumber = "321-333-7652";
        // symbol '+' is for one or more, symbol '*' is for zero or more, symbol '?' for zero or exactly one
        System.out.println(phoneNumber.matches("\\d{3}[-.\\s]?\\d{3}[-.\\s]*\\d{3,}"));
        System.out.println(phoneNumber.matches("(\\d{3}[-.\\s]?){2}\\d{3,}"));

        String phoneNumberChallenge = "1.321-333-7652";
        System.out.println(phoneNumberChallenge.matches("(\\d[-.\\s]?)?(\\d{3}[-.\\s]?){1,2}\\d{3,}"));
    }
}

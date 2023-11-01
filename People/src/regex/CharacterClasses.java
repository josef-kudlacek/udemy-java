package regex;

public class CharacterClasses {
    public static void main(String[] args) {
        System.out.println("doggy".matches(".....")); // symbol '.' for any character
        System.out.println("doggy".matches("^.....$")); // symbol '^' for start and symbol '$' for end
        System.out.println("cat doggy".matches("...\\s\\b.....")); // symbol '\\b' boundary for word and non-word character
        System.out.println("cat doggy".matches("\\w{3}\\s\\w{5}"));
        System.out.println("a_6".matches("\\w{3}")); // symbol '\\w' for word characters
        System.out.println("---".matches("\\W{3}")); // symbol '\\W' for non-characters
        System.out.println("123".matches("\\d{3}")); // symbol '\\d' for digits
        System.out.println("abc".matches("\\D{3}")); // symbol '\\D' for non-digits
        System.out.println("   ".matches("\\s{3}")); // symbol '\\s' for space
        System.out.println("1a-".matches("\\S{3}")); // symbol '\\S' for non-space character
    }
}

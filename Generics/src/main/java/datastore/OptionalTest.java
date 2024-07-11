package datastore;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optionalMessage = Optional.of("Hello");
        //System.out.println(optionalMessage);

        String message = null;
        Optional<String> optionalMessage2 = Optional.ofNullable(message); // instead usage method 'of' this can work with null values
        String finalOutput = optionalMessage2.orElse("There was nothing there").toUpperCase();
        System.out.println(finalOutput);

        if (optionalMessage2.isPresent() || !optionalMessage2.isEmpty()) {
            System.out.println(optionalMessage2.get().toUpperCase());
        } else {
            System.out.println("There was nothing there");
        }

        // System.out.println(optionalMessage2.orElseThrow(() -> new RuntimeException("Nothing found")));
        System.out.println(optionalMessage2.orElseGet(() -> "my alt")); // possible usage of function
        System.out.println(optionalMessage2.or(() -> Optional.of("nothing here optional alternative")));
        System.out.println(optionalMessage2.filter(s -> s.length() > 3).orElse("Invalid"));
    }
}

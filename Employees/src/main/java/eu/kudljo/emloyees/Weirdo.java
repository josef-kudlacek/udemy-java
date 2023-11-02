package eu.kudljo.emloyees;

import java.time.LocalDate;

public record Weirdo(String lastName, String firstName, LocalDate dob) implements DummyInterface {

    // new constructor without date of birth
    public Weirdo(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    public String sayHello() {
        return "Hello World";
    }
}

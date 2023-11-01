package eu.kudljo.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonGeneratorTest {

    private final PersonGenerator personGenerator = new PersonGenerator();

    @Test
    public void emptyStringTest() {
        List<Person> generatedPersons = personGenerator.generatePerson("");

        assertTrue(generatedPersons.isEmpty());
    }

    @Test
    public void personNotGeneratedTest() {
        List<Person> generatedPersons = personGenerator.generatePerson("Billy");

        assertTrue(generatedPersons.isEmpty());
    }

    @Test
    public void generateOnePersonTest() {
        List<Person> generatedPersons = personGenerator.generatePerson("Billy, Bob, 1234 Big St., Big City, California, 90210");

        assertEquals(1, generatedPersons.size());
        assertEquals(preparePerson1ForAssert(), generatedPersons.get(0));
    }

    @Test
    public void generateTwoPersonsTest() {
        List<Person> generatedPersons = personGenerator.generatePerson(
                "Billy, Bob, 1234 Big St., Big City, California, 90210 | "
                + "Joe,Smith,5678 Little St., Little City, New York, 20109"
        );

        assertEquals(2, generatedPersons.size());
        assertEquals(preparePerson1ForAssert(), generatedPersons.get(0));
        assertEquals(preparePerson2ForAssert(), generatedPersons.get(1));
    }

    @Test
    public void generateThreePersonsTest() {
        List<Person> generatedPersons = personGenerator.generatePerson(
                "Billy, Bob, 1234 Big St., Big City, California, 90210 | "
                        + "Joe,Smith,5678 Little St., Little City, New York, 20109 | "
                        + "Kelly,Clarkson, 99393 Wilderman St., Wilderman Junction, New Ramon, 34155"
        );

        assertEquals(3, generatedPersons.size());
        assertEquals(preparePerson1ForAssert(), generatedPersons.get(0));
        assertEquals(preparePerson2ForAssert(), generatedPersons.get(1));
        assertEquals(preparePerson3ForAssert(), generatedPersons.get(2));
    }

    private Person preparePerson1ForAssert() {
        return new Person.Builder()
                .withFirstName("Billy")
                .withLastName("Bob")
                .withAddress("1234 Big St., Big City, California, 90210")
                .build();
    }

    private Person preparePerson2ForAssert() {
        return new Person.Builder()
                .withFirstName("Joe")
                .withLastName("Smith")
                .withAddress("5678 Little St., Little City, New York, 20109")
                .build();
    }

    private Person preparePerson3ForAssert() {
        return new Person.Builder()
                .withFirstName("Kelly")
                .withLastName("Clarkson")
                .withAddress("99393 Wilderman St., Wilderman Junction, New Ramon, 34155")
                .build();
    }
}

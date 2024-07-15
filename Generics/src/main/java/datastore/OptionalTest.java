package datastore;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    record Car(String make, String model, String color, Year year) {}
    record Person(Long id, String firstName, String lastName, Optional<Car> car) implements Repository.IDable<Long>, Repository.Saveable {}

    public static void main(String[] args) {
        Repository<Person, Long> personRepository = new Repository<>();
        Person person1 = new Person( 100L, "Tom", "Johnson",
                Optional.of(new Car("Tesla", "X", "Red", Year.of(2018))));
        Person person2 = new Person(200L, "Jerry", "Johnson",
                Optional.of(new Car("Tesla", "Y", "Green", Year.of(2020))));
        Person person3 = null;
        Person person4 = new Person(200L, "Jake", "Johnson",
                Optional.of(new Car("Tesla", "3", "Green", Year.of(2020))));
        Person person5 = new Person(200L, "Johnny", "Johnson",
                        Optional.of(new Car("Tesla", "S", "Green", Year.of(2020))));

        Optional<Person> optionalPerson = Optional.ofNullable(null);
        System.out.println(optionalPerson.map(Person::firstName).orElse("Unknown")); // handle nullable for printing name

        System.out.println(optionalPerson
                .flatMap(Person::car)
                .map(Car::make)
                .orElse("Unknown make")
        );

        personRepository.save(person1);
        personRepository.save(person2);

        String firstName = personRepository.findByID(300L)
                .map(Person::firstName)
                .orElse("First name not found");
        System.out.println(firstName);

        List<Optional<Person>> people = List.of(Optional.of(person1),
                Optional.of(person2),
                Optional.of(person3),
                Optional.of(person4),
                Optional.of(person5));

        people.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Person::firstName)
                .forEach(System.out::println);

        Optional<Person> person11 = Optional.of(person1);
        person11.stream()
                .map(Person::firstName)
                .forEach(System.out::println);
    }
}

package datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Repository<T extends Repository.IDable<V> & Repository.Saveable, V> {
    record Person(String firstName, String lastName, Long id) implements IDable<Long>, Saveable {}
    interface Saveable {}
    interface IDable<E> {
        E id();
    }
    private List<T> records = new ArrayList<>();

    List<T> findAll() {
        return records;
    }

    T save(T record) {
        records.add(record);
        return record;
    }

    T findByID(long id) {
        return records.stream()
                .filter(record -> record.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    static <T, V> V encrypt(T data, Function<T, V> func) {
        return func.apply(data);
    }

    public static void main(String[] args) {
//        Repository<String> repository = new Repository<>();
//        repository.save("house");
//        repository.save("tree");
//        repository.save("boat");
//        repository.save("plane");

        Repository<Person, Long> personRepository = new Repository<>();
        personRepository.save(new Person("Jake", "Johnson", 10L));
        personRepository.save(new Person("Mary", "Johnson", 20L));
        personRepository.save(new Person("Jerry", "Johnson", 30L));

        Person foundPerson = personRepository.findByID(30L);
        System.out.println(foundPerson);

        System.out.println(personRepository.findAll());

        System.out.println(Repository.<String, String>encrypt("Hello", m -> m.toUpperCase()));
        System.out.println(Repository.<String, Integer>encrypt("world", m -> m.hashCode()));
    }
}

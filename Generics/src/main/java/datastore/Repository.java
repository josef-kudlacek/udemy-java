package datastore;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    record Person(String firstName, String lastName, Long id){}
    private List<T> records = new ArrayList<>();

    List<T> findAll() {
        return records;
    }

    T save(T record) {
        records.add(record);
        return record;
    }

    T findByID(long id) {
        return records.get(Long.valueOf(id).intValue());
    }

    public static void main(String[] args) {
        Repository<String> repository = new Repository<>();
        repository.save("house");
        repository.save("tree");
        repository.save("boat");
        repository.save("plane");

        Repository<Person> personRepository = new Repository<>();
        personRepository.save(new Person("Jake", "Johnson", 10L));
        personRepository.save(new Person("Mary", "Johnson", 20L));
        personRepository.save(new Person("Jerry", "Johnson", 30L));

        Person foundPerson = personRepository.findByID(30L);
        System.out.println(foundPerson);

        System.out.println(repository.findAll());
        System.out.println(personRepository.findAll());
    }
}

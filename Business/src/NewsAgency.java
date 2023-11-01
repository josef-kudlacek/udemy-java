import business.Company;

import java.time.LocalDate;

class NewsAgency {
    Company company;
    String name;

    public void accessMethod() {
        Person person = new Person("Johnny", null, null);
        person.lastName = "Smith";
        person.dob = LocalDate.now();
    }
}

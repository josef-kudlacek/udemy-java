package eu.kudljo.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonGenerator {

    public List<Person> generatePerson(String input) {
        List<Person> personList = new ArrayList<>();

        String regex = """
                \\s*(?<firstName>\\w+),\\s*
                (?<lastName>\\w+),\\s*
                (?<address>\\d{1,6}\\s*\\w*\\s*St.,\\s(\\w*\\s*)*,(\\w*\\s*)*,\\s\\d{5})\\s*\\|*
                """;

        Pattern pattern = Pattern.compile(regex, Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            personList.add(
                    new Person.Builder()
                            .withFirstName(matcher.group("firstName"))
                            .withLastName(matcher.group("lastName"))
                            .withAddress(matcher.group("address"))
                            .build()
            );
        }

        return personList;
    }
}

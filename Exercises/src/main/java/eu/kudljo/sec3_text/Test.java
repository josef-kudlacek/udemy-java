package eu.kudljo.sec3_text;

import eu.kudljo.sec3_text.model.People;

public class Test {
    public static void main(String[] args) {
        People george = new People();
        george.setFirstName("george"); // 1. first name with upper

        System.out.println(george.getFirstName());

        String sentence = "    This cat is on long walk with another cat. ".strip(); // 3. remove spaces
        System.out.println(replaceCat(sentence)); // 2. replace cat with dog

        String input = "alphabet";
        System.out.println(alphabetMethod(input)); // 4. call method with removing spaces and last char to upper

        String address = "12345 Big St., Alphabet City, CA 90210";
        System.out.println("Address: \"" + address + "\"");
        System.out.println("The building eu.kudljo.number: " + getBuildingNumber(address));
        System.out.println("The Street: \"" + getStreet(address) + "\"");
        System.out.println("City: \"" + getCity(address) + "\"");
        System.out.println("State: \"" + getState(address) + "\"");
        System.out.println("Postal Code: " + getPostalCode(address));
    }

    public static String replaceCat(String sentence) {
        String replaceWithDog = sentence.replaceAll("cat", "dog");
        return replaceWithDog;
    }

    public static String alphabetMethod(String input) {
        String result = input.strip();
        int endIndex = result.length() - 1;

        StringBuilder stringBuilder = new StringBuilder(result.length());
        stringBuilder.append(result.substring(0, endIndex));
        stringBuilder.append(result.substring(endIndex).toUpperCase());

        return stringBuilder.toString();
    }

    public static String getBuildingNumber(String address) {
        String parseBuildingNumber = address.strip().substring(0, address.indexOf(" "));

        return parseBuildingNumber;
    }

    public static String getStreet(String address) {
        String street = address.strip().substring(address.indexOf(" ") + 1, address.indexOf(","));

        return street;
    }

    public static String getCity(String address) {
        String city = address.strip().substring(
                address.indexOf(",") + 2, address.lastIndexOf(",")
        );

        return city;
    }

    public static String getState(String address) {
        String state = address.substring(
                address.lastIndexOf(",") + 2, address.lastIndexOf(" ")
        );

        return state;
    }

    public static String getPostalCode(String address) {
        String postalCode = address.strip().substring(
                address.lastIndexOf(" ") + 1
        );

        return postalCode;
    }
}

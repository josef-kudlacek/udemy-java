package eu.kudljo.sec5_numbers.ex3;

public class SpecialClass {
    private String[] names = {"joe", "mark", "adam", "lukas", "jean", "monica", "charlotte", "jane", "susan", "oprah"};
    private static int index = 0;

    public String next() {
        if (index >= 10) {
            throw new RuntimeException();
        }

        String name = names[index++];
        return formatName(name);
    }

    private String formatName(String name) {
        return new StringBuilder()
                .append(name.substring(0, 1).toUpperCase())
                .append(name.substring(1))
                .toString();
    }

}

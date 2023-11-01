package text;

public class StringStripTrim {
    public static void main(String[] args) {
        String firstName = "  Jake   ";

        System.out.format("'%s'", split(firstName));
    }

    public static String split(String text) {
        return text.replace(" ", "");
    }
}

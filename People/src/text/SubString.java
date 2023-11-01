package text;

public class SubString {
    public static void main(String[] args) {
        String myText = "apple";

        String firstCharCapital = myText.substring(0, 1).toUpperCase();
        String restChars = myText.substring(1);
        int stringCapacity = firstCharCapital.length() + restChars.length();
        String myNewText = new StringBuilder(stringCapacity)
                .append(firstCharCapital)
                .append(restChars)
                .toString();

        System.out.println(myNewText);
    }
}

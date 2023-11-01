package text;

public class CompareTo {
    public static void main(String[] args) {
        String firstWord = "Apple";
        String secondWord = "apple";

        System.out.println(compareToIgnoreCase(firstWord, secondWord));
    }

    public static int compareToIgnoreCase(String text1, String text2) {
        String lowerText1 = text1.toLowerCase();
        String lowerText2 = text2.toLowerCase();
        return lowerText1.compareTo(lowerText2);
    }
}

package text;

public class LearnStrings {
    public static void main(String[] args) {
        String myText = "Four score and seven years ago";
        System.out.println(myText.contains("four"));
        System.out.println(myText.contains("Four"));

        String text1 = "this is my text1";
        String text2 = "this is my text2";
        // System.out.println(text1 + " " + text2 + " hello");
        // not good in loops when adding multiple Strings for memory,
        // creating too much Strings

        System.out.println("my string literal".concat("second string literal").concat("third string literal"));

        // capacity of StringBuilder in constructor leads to more efficient
        String finalString = new StringBuilder(text1.length() + text2.length() + 1)
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();

        System.out.println(finalString);

        String otherFinalString = new StringBuffer()
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();

        System.out.println(otherFinalString);

        // not good in loops when adding multiple Strings for memory,
        // creating too much Strings, same as using + operator
        System.out.format("%s %s\n", text1, text2);
        String oneMoreFinalString = String.format("%s %s", text1, text2);
        System.out.println(oneMoreFinalString);
    }
}

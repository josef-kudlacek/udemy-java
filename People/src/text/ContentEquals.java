package text;

public class ContentEquals {
    public static void main(String[] args) {
        String firstText = "Apple";
        StringBuffer secondText = new StringBuffer("Apple");

        System.out.println(firstText.contentEquals(secondText)); // comparing content of objects
        System.out.println(firstText.equals(secondText)); // comparing data types too
    }
}

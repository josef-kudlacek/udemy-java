package text;

public class TextLearning {
    public static void main(String[] args) {
        String myText = "for score and seven years ago";
        System.out.println(myText.length());
        char[] chars = myText.toCharArray();

        int index = 2;
        if (index < myText.length()) {
            System.out.println(chars[index]);
        }

        String firstText = "for";
        String secondText = "score";

        StringBuilder stringBuilder = new StringBuilder(firstText.length() + secondText.length())
                .append(firstText)
                .append(secondText);

        System.out.println(stringBuilder);
    }
}

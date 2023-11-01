package text;

public class IndexOf {
    public static void main(String[] args) {
        String myText = "ABCDEFGABCDEFG";
        String phoneNumber = "  (763) 872-6633".strip();

        //ASCII Table: https://www.ascii-code.com/
        System.out.println(myText.indexOf("A", 2));

        String areaCode = parseAreaCode(phoneNumber);
        String exchange = parseExchange(phoneNumber);
        String lineNumber = parseLineNumber(phoneNumber);

        System.out.println("Area code: " + areaCode);
        System.out.println("Exchange: " + exchange);
        System.out.println("Line number: " + lineNumber);
    }

    public static String parseAreaCode(String phoneNumber) {
        int openParenthesisIndex = phoneNumber.indexOf("(");
        int closeParenthesisIndex = phoneNumber.indexOf(")");

        String areaCode = phoneNumber.substring(++openParenthesisIndex, closeParenthesisIndex);
        return areaCode;
    }

    public static String parseExchange(String phoneNumber) {
        int spaceIndex = phoneNumber.indexOf(32); // space
        int minusIndex = phoneNumber.indexOf("-");

        String exchange = phoneNumber.substring(++spaceIndex, minusIndex);
        return exchange;
    }

    public static String parseLineNumber(String phoneNumber) {
        int minusIndex = phoneNumber.indexOf("-");

        String lineNumber = phoneNumber.substring(++minusIndex);
        return lineNumber;
    }
}

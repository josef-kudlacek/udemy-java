package eu.kudljo.testing;

public class UpperCaseTransform {
    public String toUpperCase(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int charIndex = 0; charIndex < inputString.length(); charIndex++) {
            if (charIndex % 2 == 0) {
                stringBuilder.append(inputString.charAt(charIndex));
            } else {
                stringBuilder.append(Character.toUpperCase(inputString.charAt(charIndex)));
            }
        }

        return stringBuilder.toString();
    }
}

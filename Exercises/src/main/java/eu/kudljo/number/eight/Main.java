package eu.kudljo.number.eight;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String string1 = "123456.783";
        String string2 = "-9876.32532";
        String string3 = "23.19283928394829182";
        String string4 = "123456";
        String string5 = "-9876.35532";

        System.out.println(String.format(Locale.US, "$%,(.2f", Double.parseDouble(string1)));
        System.out.println(String.format(Locale.US, "%(,.3f", Double.parseDouble(string2)));
        System.out.println(String.format(Locale.US, "%6.6e", Double.parseDouble(string3)));
        System.out.println(String.format(Locale.US, "%010d", Integer.parseInt(string4)));
        System.out.println(String.format(Locale.US, "%,.1f", Double.parseDouble(string5)));
    }
}

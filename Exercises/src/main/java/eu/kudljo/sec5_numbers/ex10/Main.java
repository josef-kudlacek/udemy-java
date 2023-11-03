package eu.kudljo.sec5_numbers.ex10;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String string1 = "123456.783";
        String string2 = "-9876.32532";
        String string3 = "23.19283928394829182";
        String string4 = "123456";
        String string5 = "-9876.35532";

        NumberFormat moneyFormat = DecimalFormat.getCurrencyInstance(Locale.US);
        System.out.println(moneyFormat.format(Double.parseDouble(string1)));

        NumberFormat negative = new DecimalFormat(",###.###;(#)", new DecimalFormatSymbols(Locale.US));
        System.out.println(negative.format(Double.parseDouble(string2)));

        NumberFormat scientist = new DecimalFormat("#0.#####e+'01f'"); // solution was "0.######E00f"
        System.out.println(scientist.format(Double.parseDouble(string3)));

        NumberFormat places10 = new DecimalFormat("0000000000");
        System.out.println(places10.format(Integer.parseInt(string4)));

        NumberFormat negativeFloating = new DecimalFormat(",###.#", new DecimalFormatSymbols(Locale.US));
        System.out.println(negativeFloating.format(Double.parseDouble(string5)));
    }
}

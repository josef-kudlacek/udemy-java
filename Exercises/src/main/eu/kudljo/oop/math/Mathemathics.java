package eu.kudljo.oop.math;

public class Mathemathics {

    public static double getEulerNumber(int n) {
        double eulerNumber = 1;
        double result = 0;

        for (int i = 0; i < n; i++) {
            result = result + ((1 + 1 / n) * n);
        }

        return eulerNumber;
    }
}

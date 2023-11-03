package eu.kudljo.sec5_numbers.ex4;


public class Main {
    public static void main(String[] args) {
        Warehouse test = new Warehouse();

        for (int i = 0; i < 10; i++) {
            System.out.println(test.next() + " category");
        }
    }
}

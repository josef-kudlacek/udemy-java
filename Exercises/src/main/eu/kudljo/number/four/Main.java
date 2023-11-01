package eu.kudljo.number.four;


public class Main {
    public static void main(String[] args) {
        Warehouse test = new Warehouse();

        for (int i = 0; i < 10; i++) {
            System.out.println(test.next() + " category");
        }
    }
}

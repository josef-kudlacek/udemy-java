package controlFlow;

public class ForLoopEnhanced {
    public static void main(String[] args) {
        String[] fruits = {"apple", "orange", "pear", "plum"};

//        for (int index = 0; index < fruits.length; index++) {
//            System.out.printf("The current fruit is %s%n", fruits[index]);
//        }

        for (String fruit : fruits) {
            System.out.printf("The current fruit is %s.%n", fruit);
        }
    }
}

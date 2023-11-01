package number;

public class NumericWrapperClasses {
    public static void main(String[] args) {
        int num1 = 7;
        Integer num1B = Integer.valueOf(num1); // auto-boxing
        Double myDouble = Double.valueOf(2343.12);
        Float myFloat = Float.valueOf(23.23f);
        Byte myByte = Byte.valueOf("23"); // simpler then use number
        myDouble.byteValue();
        storeData(num1);

        int age = Integer.parseInt("37");
        System.out.printf("You will be %d age in 15 years.%n", age + 15);
        double amount = Double.parseDouble("345.12");
        boolean parsedBoolean = Boolean.parseBoolean("true");
        System.out.println(parsedBoolean);
    }

    /**
     * Takes in any type of data and stores it somewhere generically
     */
    public static void storeData(Object object) {
        System.out.println(object);
    }
}

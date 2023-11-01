package number;

public class NumberStuff {
    public static void main(String[] args) {
        byte myByte = 127; //@2F3582AF21
        boolean myFlag = true;
        short myShort = 32767;
        char myChar = '강'; // gang
        char myA = 'A'; // 65
        double myDouble = 3.141592;
        float myFloat = 3.141592f;

        float num1 = 2.15f;
        float num2 = 1.10f;

        byte anotherByte = 0x1f;
        int anotherInt = 0b01 | 0b10; // 1 OR 2 => 3

        System.out.println(myByte);
        System.out.println(num1 - num2);
        System.out.println(anotherByte);
        System.out.println(anotherInt);
    }
}

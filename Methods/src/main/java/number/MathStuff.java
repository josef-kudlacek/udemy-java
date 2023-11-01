package number;

public class MathStuff {
    public static void main(String[] args) {
        System.out.println(7 / 4); // result is whole number 1 without decimal places and floating
        System.out.println(7f / 4); // change result to floating number based on memory allocation with usage of 'f' OR 'd'
        System.out.println((double) 7 / 4); // casting 7 to floating number of data type double, which will increase data type of result to double
        System.out.println((double)(7 / 4)); // result is 1.0 because result of dividing is converted do data type double
        System.out.println(2 + 3 * 5); // result is 17, because operation of multiplication (and dividing) has higher priority then plus and minus
        System.out.println((2 + 3) * 5); // result is 25, because of parenthesis

        System.out.println("Modulo:"); // Column Selection Mode with Right-click
        System.out.println(1 % 3);
        System.out.println(2 % 3);
        System.out.println(3 % 3);
        System.out.println(4 % 3);
        System.out.println(5 % 3);
        System.out.println(6 % 3);
        System.out.println(7 % 3);
        System.out.println(8 % 3);
        System.out.println(9 % 3);
        System.out.println(10 % 3);

        int x = 1;
        System.out.println("x = " + x); // x = 1
        x += 4; // x = x + 4
        System.out.println("x = " + x); // x = 5
        ++x; // x = x + 1 OR x = x + 1
        System.out.println("x = " + x); // x = 6
        System.out.println("x = " + x++); // x = 6, but after printing is 7
        System.out.println("x = " + x); // x = 7

        System.out.println("working with boolean (bites):");
        boolean myFlag = true;
        System.out.println(myFlag);
        myFlag = !myFlag;
        System.out.println(myFlag);
    }
}

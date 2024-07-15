import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExceptionTests {
    public static void main(String[] args) {
        workWithFile();

        //doSecondLevel(0);
        System.out.println("You made it to the end");
    }

    private static void workWithFile() {
        try {
            Files.lines(Path.of("blablabla"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("We were unable to open the file.");
        } finally {
            System.out.println("Make sure that connection to the file is ended here..");
        }
    }

    private static void doSecondLevel(int num) {
        String[] array = {"one", "two", "three"};
        try {
            // Defend against runtime exception
            if (num != 0) {
                System.out.println(array.length / num);
            }
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException exception) {
            System.out.printf("Exception type: %s%nMessage: %s%n", exception.getClass(), exception.getMessage());
            exception.printStackTrace();
        }
    }
}

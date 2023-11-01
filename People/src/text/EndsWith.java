package text;

public class EndsWith {
    public static void main(String[] args) {
        String fileName = "  file001-myfile.txt";

        System.out.println(fileName.endsWith(".txt"));
        System.out.println(fileName.strip().startsWith("file001"));
    }
}

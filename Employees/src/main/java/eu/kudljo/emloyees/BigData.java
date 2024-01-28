package eu.kudljo.emloyees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BigData {
    public static void main(String[] args) {
        try {
            List<String> result = Files.lines(Path.of("PATH_OF_FILE"))
                    .skip(1)
                    .toList();

//            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

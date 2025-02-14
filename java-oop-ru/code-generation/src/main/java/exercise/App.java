package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

// BEGIN
public class App {

    public static void save(Path filePath, Car car) {
        try {
            String jsonString = car.serialize();
            Files.write(filePath, jsonString.getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path filePath) {
        try {
            String jsonString = Files.readString(filePath);
            return Car.deserialize(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
// END

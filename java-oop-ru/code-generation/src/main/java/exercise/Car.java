package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String serialize() {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Car deserialize(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, Car.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    // END
}

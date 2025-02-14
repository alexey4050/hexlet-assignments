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
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public String serialize() {
        try {
            return OBJECT_MAPPER.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Car deserialize(String jsonString) {
        try {
            return OBJECT_MAPPER.readValue(jsonString, Car.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    // END
}

package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }
    // BEGIN
    @Test
    public void testAdvancedValidate_ValidationWithMinLength() {
        Address address3 = new Address("US", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields3 = Validator.advancedValidate(address3);
        assertEquals(2, notValidFields3.size());
        assertEquals(List.of("can not be null"), notValidFields3.get("street"));

        Address address4 = new Address("USA", "Texas", "Main St", "7", "2");
        Map<String, List<String>> notValidFields4 = Validator.advancedValidate(address4);
        assertEquals(1, notValidFields4.size());

        Address address5 = new Address("US", "Texas", "Ma", "7", "2");
        Map<String, List<String>> notValidFields5 = Validator.advancedValidate(address5);
        assertEquals(1, notValidFields5.size());
        assertEquals(List.of("length less than 4"), notValidFields5.get("country"));
    }
    // END
}

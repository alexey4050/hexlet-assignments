package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
// BEGIN
@AllArgsConstructor
@Getter
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}

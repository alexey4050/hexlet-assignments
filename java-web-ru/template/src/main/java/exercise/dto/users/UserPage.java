package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@AllArgsConstructor
@Getter
public class UserPage {
    private final User user;
}
// END

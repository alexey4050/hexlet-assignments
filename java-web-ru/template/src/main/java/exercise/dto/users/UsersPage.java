package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class UsersPage {
    private final List<User> users;

    public List<User> getUsers() {
        return users;
    }
}
// END

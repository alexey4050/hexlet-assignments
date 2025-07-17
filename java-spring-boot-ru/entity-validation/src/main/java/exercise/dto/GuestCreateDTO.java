package exercise.dto;

// BEGIN

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class GuestCreateDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^\\+\\d{11,13}$",
            message = "Phone number must start with"
                    + "and contain 11-13 digits")
    private String phoneNumber;

    @Pattern(regexp = "^\\d{4}$",
            message = "Club card must contain exactly 4 digits")
    private String clubCard;

    @Future(message = "Club card must not be expired")
    private LocalDate cardValidUntil;
}
// END

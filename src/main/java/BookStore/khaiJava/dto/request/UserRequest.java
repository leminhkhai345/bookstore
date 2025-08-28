package BookStore.khaiJava.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    @NotBlank(message = "username is not blank")
    @Size(min = 5, message = "username must be at least 5 characters")
    String username;
    @NotBlank(message = "password is not blank")
    @Size(min = 5, message = "password must be at least 5 characters")
    String password;

    @NotBlank(message = "email is not blank")
    @Email(message = "email is not valid")
    String email;

    @NotBlank(message = "phone is not blank")
    @Size(min = 10, max = 10, message = "Phone number must be 10 characters")
    String phone;
    String fullname;
    String address;
    @Min(value = 1, message = "roleId must be greater than 1")
    int roleId;
}

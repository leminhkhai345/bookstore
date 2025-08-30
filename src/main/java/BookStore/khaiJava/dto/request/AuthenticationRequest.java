package BookStore.khaiJava.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Builder
public class AuthenticationRequest {
    @NotBlank(message = "username must be not blank")
    String username;
    @NotBlank(message = "password must be not blank")
    String password;
}

package BookStore.khaiJava.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    @Size(min = 5)
    String username;
    @Size(min = 5)
    String password;

    String email;
    String phone;
    String fullname;
    String address;
    int roleId;
}

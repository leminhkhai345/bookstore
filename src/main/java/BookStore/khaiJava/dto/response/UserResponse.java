package BookStore.khaiJava.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    String username;
    String email;
    String phone;
    String fullname;
    String address;
    Set<RoleResponse> roles;
}

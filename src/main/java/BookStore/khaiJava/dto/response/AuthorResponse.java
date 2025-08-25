package BookStore.khaiJava.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorResponse {
    int id;
    String fullName;
    String biography;
    LocalDate dob;
    String nationality;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}

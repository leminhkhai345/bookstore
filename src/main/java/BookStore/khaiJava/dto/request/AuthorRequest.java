package BookStore.khaiJava.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorRequest {
    String fullName;
    String biography; // tiểu sử
    LocalDate dob;
    String nationality; // quốc tịch
}

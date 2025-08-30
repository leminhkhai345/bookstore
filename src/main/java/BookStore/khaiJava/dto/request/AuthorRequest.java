package BookStore.khaiJava.dto.request;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "fullName must be not blank")
    String fullName;
    String biography; // tiểu sử
    LocalDate dob;
    String nationality; // quốc tịch
}

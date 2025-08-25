package BookStore.khaiJava.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AppException extends RuntimeException {
    ErrorCode errorCode;
}

package BookStore.khaiJava.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AppException extends RuntimeException {
    ErrorCode errorCode;
}

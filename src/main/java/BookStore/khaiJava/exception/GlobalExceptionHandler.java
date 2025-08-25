package BookStore.khaiJava.exception;


import BookStore.khaiJava.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException ex) {
        ApiResponse response = new ApiResponse();
        response.setCode(ex.getErrorCode().getCode());
        response.setMessage(ex.getErrorCode().getMessage());
        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingAppException(MethodArgumentNotValidException ex) {
        ApiResponse response = new ApiResponse();
        response.setCode(9998);
        response.setMessage(ex.getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest().body(response);
    }



}

package BookStore.khaiJava.exception;

import lombok.Getter;
import lombok.Setter;


public enum ErrorCode {
    ROLE_NOT_EXISTED(3636, "role khong ton tai"),
    USER_NOT_EXISTED(3637, "user not existed"),
    USER_EXISTED(5000, "user already existed"),
    ;


    private int code;
    private String message;
    ErrorCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {return this.code;}
    public String getMessage() {return this.message;}

}

package BookStore.khaiJava.exception;

import lombok.Getter;
import lombok.Setter;


public enum ErrorCode {
    ROLE_NOT_EXISTED(999, "role khong ton tai"),
    USER_NOT_EXISTED(1001, "user not existed"),
    USER_EXISTED(1002, "user already existed"),
    CATEGORY_NOT_EXISTED(1003, "category not existed"),
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

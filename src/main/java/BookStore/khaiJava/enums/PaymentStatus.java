package BookStore.khaiJava.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {
    pending,
    paid,
    failed,
    refunded

    ;


    private String value;
    private String description;

}

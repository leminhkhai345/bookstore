package BookStore.khaiJava.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum Status {
    pending,
    confirmed,
    processing,
    shipped,
    delivered,
    cancelled
}

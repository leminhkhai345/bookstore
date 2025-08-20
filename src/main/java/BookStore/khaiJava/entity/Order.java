package BookStore.khaiJava.entity;

import BookStore.khaiJava.enums.PaymentStatus;
import BookStore.khaiJava.enums.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderId;
    LocalDateTime orderDate;
    double totalAmount;
    double shippingFee;
    double discountAmount;
    double finalAmount;
    Status status;
    String paymentMethod;
    PaymentStatus paymentStatus;
    String shippingAddress;
    String receiptName;
    String receiptPhone;
    String notes;
    LocalDateTime createAt;
    LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    List<OrderDetail> orderDetails;

}

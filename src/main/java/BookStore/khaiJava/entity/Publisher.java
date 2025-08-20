package BookStore.khaiJava.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "Publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String address;
    String phone;
    String email;
    String website;
    LocalDateTime createAt;


    @PrePersist
    protected void onCreate() {
        createAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private Set<Book> books;
}

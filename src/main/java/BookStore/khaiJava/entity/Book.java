package BookStore.khaiJava.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String isbn;
    String description;
    double price;
    double costPrice;
    int page;
    int publicationYear;
    String language = "Vietnamese";
    double weight;
    String dimensions;
    String coverImageUrl;
    int stockQuantity;
    boolean isDeleted = false;
    LocalDateTime createAt;
    LocalDateTime updateAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    Set<Category> categories;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id") // Khóa ngoại trong bảng books
    private Publisher publisher;


    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    List<OrderDetail> orderDetails;
}


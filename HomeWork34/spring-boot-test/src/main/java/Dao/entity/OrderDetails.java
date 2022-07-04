package Dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "orderid")
    private Orders orderId;

    @OneToMany
    @JoinColumn(name = "bookid")
    @ToString.Exclude
    private List<Book> bookid;

    @Column(name = "bookscount")
    private int booksCount;

    @Column
    private int cost;
}
package Dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import lombok.ToString;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class BookWarehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "bookid")
    @ToString.Exclude
    private List<Book> bookid;

    @Column(name = "availablebooks")
    private int availableBooks;
}
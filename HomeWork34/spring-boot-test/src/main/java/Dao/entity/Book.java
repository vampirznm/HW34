package Dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookname")
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "authorid")
    private Author authorid;

    @Column(name = "releaseyear")
    private int releaseYear;

    @Column(name = "pagesnumber")
    private int pagesNumber;

    @Column(name = "cost")
    private double cost;
}
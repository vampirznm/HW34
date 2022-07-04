package Dao.repository;

import Dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from book b left join author a on a.id = b.authorid where a.authorname = :authorsName",
            nativeQuery = true)
    List<Book> findAllByAuthorsname(String authorsName);
}
package Dao.repository;

import Dao.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "select id,authorname from author a where a.authorname = :authorName",
            nativeQuery = true)
    Author findByName(String authorName);
}
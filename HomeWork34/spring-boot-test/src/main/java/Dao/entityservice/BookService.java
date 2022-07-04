package Dao.entityservice;

import Dao.entity.Book;
import Dao.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.getById(id);
    }

    public List<Book> getAllBooksByAuthorsName(String authorsName) {
        return bookRepository.findAllByAuthorsname(authorsName);
    }
}
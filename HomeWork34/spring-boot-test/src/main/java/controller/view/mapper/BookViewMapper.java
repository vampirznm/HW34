package controller.view.mapper;

import controller.view.BookView;
import Dao.entity.Book;
import Dao.entityservice.AuthorService;
import Dao.entityservice.BookService;
import org.springframework.stereotype.Component;

@Component
public class BookViewMapper {

    private final AuthorService authorService;
    private final BookService bookService;

    public BookViewMapper(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public BookView mapToView(Book book) {
        BookView view = new BookView();
        view.setId(book.getId());
        view.setBookName(book.getBookName());
        view.setAuthorName(book.getAuthorid().getAuthorName());
        view.setCost(book.getCost());
        return view;
    }

    public Book mapFromView(BookView view) {
        Book book = new Book();
        book.setId(view.getId());
        book.setBookName(view.getBookName());
        book.setAuthorid(authorService.getAuthorByName(view.getAuthorName()));
        book.setPagesNumber(bookService.getBookById(view.getId()).getPagesNumber());
        book.setReleaseYear(bookService.getBookById(view.getId()).getReleaseYear());
        book.setCost(view.getCost());
        return book;
    }
}
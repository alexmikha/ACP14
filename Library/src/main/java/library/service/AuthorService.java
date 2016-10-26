package library.service;

import library.exception.NoBookFoundException;
import library.model.Author;
import library.model.Book;

import java.util.List;

/**
 * Created by mi on 22.10.16.
 */
public interface AuthorService {

    String login(String name, String pass);

    Book getBookById(Integer id) throws NoBookFoundException;

    List<Book> getBooks(int authorId);

    boolean addBook(Book book);

    boolean addAuthor(Author author);


}

package week6.jpa.service;

import week6.jpa.model.Book;

import java.util.List;

/**
 * Created by mi on 20.10.2016.
 */
public interface AuthorService {

    String login(String name, String pass);

    List<Book> getBooks(int authorId);

    boolean addBook(Book book);


}

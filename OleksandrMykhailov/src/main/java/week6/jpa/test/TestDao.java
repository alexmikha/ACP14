package week6.jpa.test;

import week6.jpa.dao.BookDao;
import week6.jpa.model.Book;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by mi on 13.10.2016.
 */
public class TestDao {

    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("hibernate-unit");
        BookDao bookDao = new BookDao(factory);

        Book book = new Book();
        book.setId(10);
        bookDao.delete(book);
        List<Book> bookList = bookDao.getBooksByType(Book.BookType.IT);
        bookList.stream().forEach(System.out::println);

    }
}

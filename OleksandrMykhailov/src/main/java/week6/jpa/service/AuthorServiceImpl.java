package week6.jpa.service;

import week6.jpa.dao.BookDao;
import week6.jpa.model.Book;
import week6.jpa.validator.Validator;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService {


    private BookDao bookDao;

    private Validator<Book> validator;

    public AuthorServiceImpl() {
    }

    public AuthorServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public String login(String name, String pass) {
        return null;
    }

    @Override
    public List<Book> getBooks(int authorId) {
        return Arrays.asList(new Book(), new Book());
    }

    @Override
    public boolean addBook(Book book) {

        if(validator.isValid(book)){
            return false;
        }

        Book created = bookDao.create(book);
        return created != null;
    }
}

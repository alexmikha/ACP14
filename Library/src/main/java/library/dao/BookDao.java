package library.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import library.model.Book;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mi on 22.10.16.
 */
@Component
public class BookDao implements Dao<Book> {

    private static final Logger LOGGER = Logger.getLogger(BookDao.class);

    @Autowired
    private EntityManagerFactory factory;

    public BookDao() {
    }

    public BookDao(EntityManagerFactory factory) {
        LOGGER.trace("create book dao instance");
        this.factory = factory;
    }

    @Override
    public Book create(Book book) {
        LOGGER.info("create new book");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(book);
            transaction.commit();
            LOGGER.info("book was saved");
        } catch (Exception e) {
            LOGGER.error("book was not saved", e);
            transaction.rollback();
        } finally {
            manager.close();
        }

        return book;
    }

    @Override
    public boolean delete(Book book) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        book = manager.find(Book.class,book.getId());

        try {
            transaction.begin();
            manager.remove(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            manager.close();
        }

        return true;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book findById(Object id) {
        EntityManager manager = factory.createEntityManager();

        try {
            Book book = manager.find(Book.class, id);
            return book;
        } finally {
            manager.close();
        }

    }

    public List<Book> getBooksByType(Book.BookType type){
        EntityManager manager = factory.createEntityManager();
        // JPQL - Java PErsistence Query Language (OOP + SQL)
        TypedQuery<Book> query = manager.createQuery("SELECT b FROM Book b WHERE b.type =:typeName", Book.class);
        query.setParameter("typeName", type);
        query.setMaxResults(20);
        query.setFirstResult(0);

        return query.getResultList();
    }
}

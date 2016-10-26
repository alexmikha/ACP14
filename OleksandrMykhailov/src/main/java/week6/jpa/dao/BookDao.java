package week6.jpa.dao;

import week6.jpa.model.Book;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mi on 20.10.2016.
 */
public class BookDao implements Dao<Book> {

    private EntityManagerFactory factory;

    public BookDao(EntityManagerFactory factory) {
    }

    @Override
    public Book create(Book book) {
        //     EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-unit");

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return book;
    }

    @Override
    public boolean delete(Book book) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-unit");

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        book = manager.find(Book.class, book.getId());
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
        EntityTransaction transaction = manager.getTransaction();
        try {
            Book book = manager.find(Book.class, id);
            return book;
        } finally {
            manager.close();
        }
    }


    public List<Book> getBooksByType(Book.BookType type){
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Book> query = manager.createQuery("SELECT b FROM Book b WHERE b.type = :typeName", Book.class);
 //       Query query = manager.createQuery("SELECT b FROM Book b WHERE b.type = :typeName");
        query.setParameter("typeName", type);
        query.setMaxResults(10);
        query.setFirstResult(0);
        query.getResultList();
        return query.getResultList();
    }
}

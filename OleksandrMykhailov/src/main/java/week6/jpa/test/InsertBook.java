package week6.jpa.test;

import week6.jpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by mi on 12.10.2016.
 */
public class InsertBook {


    public static void main(String[] args) {

        Book book = new Book("Java 8", Book.BookType.IT, "Kiev", new Date(), 400);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-unit");

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
    }
}

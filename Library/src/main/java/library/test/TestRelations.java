package library.test;

import library.model.Address;
import library.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by mi on 13.10.2016.
 */
public class TestRelations {


    public static void main(String[] args) {
        Address address = new Address("Kiev", "Starokievskaya", "10");
        Author author = new Author("Alex", 123.34, new Date());
        author.setAddress(address);

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("hibernate-unit");

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(author);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }

        factory.close();
    }
}

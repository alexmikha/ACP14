package homeWork.faculty.test;

import homeWork.faculty.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by mi on 16.10.2016.
 */
public class InsertStudent {
    public static void main(String[] args) {
        Student student = new Student("Alex", 1);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-unit");

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(student);
            transaction.commit();
        } catch (Exception e)

        {
            transaction.rollback();
        } finally {
            manager.close();
        }
    }
}
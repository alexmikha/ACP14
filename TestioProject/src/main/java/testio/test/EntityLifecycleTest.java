package testio.test;

import testio.model.Student;
import testio.model.StudentType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by Mi on 27.10.16.
 */
public class EntityLifecycleTest {


    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Student student = new Student("Gavriil", 3, StudentType.MIDDLE,
                new Date(), "sdfsdf");



        // delete
        manager.getTransaction().begin();
        Student student1 = manager.find(Student.class, 1);
        manager.remove(student1);
        manager.getTransaction().commit();

    }
}

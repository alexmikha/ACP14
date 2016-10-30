package testio.test;

import testio.model.Student;
import testio.model.StudentType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by Mi on 27.10.16.
 */
public class EntityManagerFactoryTest {


    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Student student = new Student("Gavriil", 3, StudentType.MIDDLE, new Date(), "sdfsdf");


        EntityTransaction transaction = manager.getTransaction();

        try{
            transaction.begin();
            manager.persist(student); // add student to context (see entity lifecycle)
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        } finally {
            manager.close();
        }


        manager = entityManagerFactory.createEntityManager();
        Student student1 = manager.find(Student.class,1);

        System.out.println(student1);

        // Entity lifecycle
        // log4j






    }
}

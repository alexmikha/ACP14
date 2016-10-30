package testio.test;

import testio.model.Course;
import testio.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Mi on 27.10.16.
 */
public class TestFetchType {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Teacher teacher1 = new Teacher("Bloch3",5);
        for (int i = 0; i < 1000; i++) {
            teacher1.getCourses().add(new Course(String.valueOf(i), "desc",teacher1));
        }
        manager.getTransaction().begin();
        manager.persist(teacher1);
        manager.getTransaction().commit();


        manager.clear();


        Teacher teacher = manager.createQuery("SELECT t FROM Teacher t WHERE t.name = :tName", Teacher.class)
                .setParameter("tName", "Bloch").getSingleResult();

        System.out.println(teacher);

        int level = teacher.getLevel();

        int size = teacher.getCourses().size();


    }
}

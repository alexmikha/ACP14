package homeWork.facultyHibernate.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Mi on 23.10.2016.
 */
public class MenagerConection {

    private static final String PERSISTENT_NAME = "faculty_hibernate";
    private static EntityManagerFactory factory =
            Persistence.createEntityManagerFactory(PERSISTENT_NAME);

    public static EntityManager getManagerConnection() {
        return factory.createEntityManager();
    }
}

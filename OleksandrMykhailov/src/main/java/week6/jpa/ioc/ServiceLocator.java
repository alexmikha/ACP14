package week6.jpa.ioc;

import week6.jpa.dao.BookDao;
import week6.jpa.service.AuthorServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mi on 20.10.16.
 */
public class ServiceLocator {

    private static final Map<String, Object> contex = new HashMap<>();

   //  while class loading
    static {
        // configuration
        contex.put("entityManagerFactory", Persistence.createEntityManagerFactory("hibernate-unit"));
        contex.put("bookDao", new BookDao((EntityManagerFactory) contex.get("entityManagerFactory")));
        contex.put("authorService", new AuthorServiceImpl((BookDao) contex.get("bookDao")));
    }

    public static Object get(String beanName) {
        return contex.get(beanName);
    }
}

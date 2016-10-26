package week7.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week6.jpa.service.AuthorService;

/**
 * Created by mi on 20.10.16.
 */
public class TestAopSpring {


    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("week7/ioc/app-xml-annot-context.xml");
        AuthorService authorService = applicationContext.getBean(AuthorService.class);
        authorService.getBooks(15);
    //    List books = authorService.getBooks(-45);
        authorService.login("", "");



    }
}

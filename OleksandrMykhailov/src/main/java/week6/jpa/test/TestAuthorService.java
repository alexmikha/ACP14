package week6.jpa.test;

import week6.jpa.dao.BookDao;
import week6.jpa.ioc.ServiceLocator;
import week6.jpa.service.AuthorService;
import week6.jpa.service.AuthorServiceImpl;

import javax.persistence.Persistence;

/**
 * Created by mi on 20.10.2016.
 */
public class TestAuthorService {


    public static void main(String[] args) {
        AuthorService authorService = new AuthorServiceImpl(
                new BookDao(
                    Persistence.createEntityManagerFactory("hibernate-unit")));

        AuthorService authorService1 = (AuthorService) ServiceLocator.get("authorService");
    }
}

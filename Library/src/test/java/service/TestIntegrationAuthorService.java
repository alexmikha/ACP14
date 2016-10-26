package service;

import library.model.Author;
import library.model.Book;
import library.service.AuthorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Mi on 25.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml"})
public class TestIntegrationAuthorService {

    @Autowired
    private AuthorService service;

    @Test
    public void addBook(){
        boolean res =
                service.addBook(
                        new Book("book1", Book.BookType.IT, "Kiev", new Date(),500));
        Assert.assertTrue(res);
    }

//    @Test
//    public void createUser(){
//        Assert.assertTrue(service.addAuthor(new Author("Martin",30000,new Date())));
//    }

}

package week6.jpa.test;

import week6.jpa.ioc.DependencyInjector;
import week6.jpa.service.AuthorService;
import week6.jpa.service.AuthorServiceImpl;

/**
 * Created by mi on 13.10.2016.
 */
public class TestInjector {


    public static void main(String[] args) {
        AuthorService service = new AuthorServiceImpl();
        DependencyInjector.doInjection(service);
    }
}

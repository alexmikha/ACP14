//package library.test;
//
//import library.dao.BookDao;
//import library.ioc.ServiceLocator;
//import library.service.AuthorService;
//import library.service.AuthorServiceImpl;
//
//import javax.persistence.Persistence;
//
///**
// * Created by mi on 20.10.2016.
// */
//public class TestAuthorService {
//
//
//    public static void main(String[] args) {
//        AuthorService authorService = new AuthorServiceImpl(
//                new BookDao(
//                    Persistence.createEntityManagerFactory("hibernate-unit")));
//
//        AuthorService authorService1 = (AuthorService) ServiceLocator.get("authorService");
//    }
//}

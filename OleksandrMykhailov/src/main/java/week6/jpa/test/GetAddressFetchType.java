package week6.jpa.test;

import week6.jpa.model.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by mi on 20.10.2016.
 */
public class GetAddressFetchType {


    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("hibernate-unit");

        EntityManager manager = factory.createEntityManager();

        Address address = manager.find(Address.class, 5);
        List authors = address.getAuthorList();
        System.out.println(address);


    }
}

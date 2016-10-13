package week6.jpa.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by mi on 12.10.2016.
 */
public class InitTables {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");

    }
}

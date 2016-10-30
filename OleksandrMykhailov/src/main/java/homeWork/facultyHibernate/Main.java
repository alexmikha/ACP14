package homeWork.facultyHibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by mi on 06.10.2016.
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
//        ManagerConnection managerConnection = new ManagerConnection();
//        MenuDao menuDao = new MenuDao();
//        menuDao.menu();

        EntityManagerFactory managerFaculty = Persistence.
                createEntityManagerFactory("faculty_hibernate");
    }
}

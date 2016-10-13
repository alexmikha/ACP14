package homeWork.faculty;

import homeWork.faculty.utilsDao.ManagerConnection;
import homeWork.faculty.view.MenuDao;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by mi on 06.10.2016.
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        ManagerConnection managerConnection = new ManagerConnection();
        MenuDao menuDao = new MenuDao();
        menuDao.menu();
    }
}

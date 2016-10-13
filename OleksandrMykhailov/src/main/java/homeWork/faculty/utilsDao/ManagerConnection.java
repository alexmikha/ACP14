package homeWork.faculty.utilsDao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * Created by mi on 08.10.2016.
 */
public class ManagerConnection {
    private static Logger logger = Logger.getLogger(ManagerConnection.class);
    private static ResourceBundle resources = ResourceBundle.getBundle("database");
    private static boolean instance;

    public static Connection getConnection() throws SQLException {
        logger.trace("Create connection");
        if (!instance) try {
            initializeDriver();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = resources.getString("db.url");
        String login = resources.getString("db.user");
        String pass = resources.getString("db.password");
        try {
            Connection connection = DriverManager.getConnection(url, login, pass);
            return connection;
        } catch (Exception e) {
            logger.error("Exception: not connection url or not tru login or not tru pass " + e.getMessage());
        }
        return null;
    }

    private static synchronized void initializeDriver() throws ClassNotFoundException {
        try {
            Class.forName(resources.getString("db.driver"));
        } catch (Exception e) {
            logger.error("Exception: not load driver " + e.getMessage());
        }
        instance = true;
    }
}

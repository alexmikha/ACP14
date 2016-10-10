package homeWork.faculty.utilsDao;

import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by mi on 07.10.2016.
 */
public class ConnectionClose {

    private static final Logger logger = Logger.getLogger(ConnectionClose.class);
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("SQLException: closeConnection" + e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("SQLException: closeResultSet" + e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("SQLException: closeStatement" + e.getMessage());
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("SQLException: closePreparedStatement" + e.getMessage());
            }
        }
    }
}

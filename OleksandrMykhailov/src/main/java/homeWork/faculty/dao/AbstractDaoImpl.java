package homeWork.faculty.dao;

import homeWork.faculty.controller.ControllerDao;
import homeWork.faculty.utilsDao.ConnectionClose;
import homeWork.faculty.utilsDao.ManagerConnection;

import java.sql.*;
import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */
public class AbstractDaoImpl<E> implements ControllerDao {
    private Statement statement;
    private ResultSet resultSet;
    private Connection connection;



    public List<E> analysisList(ResultSet resultSet) {
        return null;
    }


    @Override
    public List<E> getAll() throws SQLException {
        List<E> list = null;
        String entityQuery = "SELECT id, studentName, avg_score, group_id FROM students";
        connection = ManagerConnection.getConnection();
        PreparedStatement prstatement =null;
        try {
            statement = connection.prepareStatement(entityQuery);
            resultSet = statement.executeQuery(entityQuery);
          //  while (resultSet.next()) {
                list = analysisList(resultSet);
 //               list.add();
          //  }
        } finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return list;
    }

    @Override
    public boolean insertEntity(Object entity) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteEntity(Object entity) throws SQLException {
        return false;
    }

    @Override
    public boolean updateEntity(Object entity) throws SQLException {
        return false;
    }
}

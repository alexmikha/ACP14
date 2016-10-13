package homeWork.faculty.dao;

import homeWork.faculty.controller.ControllerDao;
import homeWork.faculty.model.Group;
import homeWork.faculty.utilsDao.ConnectionClose;
import homeWork.faculty.utilsDao.ManagerConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi on 10.10.2016.
 */
public class GroupDaoImpl implements ControllerDao<Group, Integer> {

    private static final Logger logger = Logger.getLogger(GroupDaoImpl.class);
    private PreparedStatement prstmt;
    private Connection connection = ManagerConnection.getConnection();
    private Statement statement;
    private ResultSet resultSet;

    public GroupDaoImpl() throws SQLException {
    }

    @Override
    public List<Group> getAll() throws SQLException {
        logger.info("Calling method getAllGroup");
        connection = ManagerConnection.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM groups");

            List<Group> groupList = new ArrayList<>();
            while (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setGroupName(resultSet.getString("name"));
                groupList.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean insertEntity(Group group) throws SQLException {
        logger.info("Calling  method addGroupToDB create new group");
        String addGroup = "INSERT INTO groups(name) VALUES (?)";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(addGroup);
            prstmt.setString(1, group.getGroupName());
            prstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("not connection " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteEntity(Group group) throws SQLException {
        logger.info("Calling method deleteGroup delete group from DB");
        PreparedStatement prstmt = null;
        String deleteGroup = "DELETE FROM groups WHERE id=?";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(deleteGroup);
            prstmt.setInt(1, group.getId());
            prstmt.execute();
        } catch (SQLException e) {
            logger.error("Group was not delete from DB" + e.getMessage());
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        logger.info("Group was deleted from DB");
        return true;

    }

    @Override
    public boolean updateEntity(Group group) throws SQLException {
        logger.info("Calling method updateGroup update group from DB");
        String updateGroup = "UPDATE groups SET name=? WHERE id=?";
        connection = ManagerConnection.getConnection();
        if (getEntityById(group.getId()) == null) {
            return false;
        }
        try {
            prstmt = connection.prepareStatement(updateGroup);

            prstmt.setString(1, group.getGroupName());
            prstmt.setInt(2, group.getId());

            prstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Group was not update from DB" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public Group getEntityById(Integer id) throws SQLException {
        logger.info("Calling method getEntityById");
        String getById = "SELECT * FROM groups WHERE id=" + id + ";";
        Group group = new Group();
        connection = ManagerConnection.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getById);
            if (resultSet.next()) {
                group.setId(resultSet.getInt("id"));
                group.setGroupName(resultSet.getString("name"));
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        logger.info("Id of group successfully  got from DB");
        return null;
    }
}

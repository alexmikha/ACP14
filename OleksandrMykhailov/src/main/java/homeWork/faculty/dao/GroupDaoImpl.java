package homeWork.faculty.dao;

import homeWork.faculty.controller.ControllerDao;
import homeWork.faculty.model.Group;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 10.10.2016.
 */
public class GroupDaoImpl implements ControllerDao<Group> {
    @Override
    public List<Group> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insertEntity(Group entity) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteEntity(Group entity) throws SQLException {
        return false;
    }

    @Override
    public boolean updateEntity(Group entity) throws SQLException {
        return false;
    }
}

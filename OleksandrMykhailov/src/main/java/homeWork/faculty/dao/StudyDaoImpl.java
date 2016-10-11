package homeWork.faculty.dao;

import homeWork.faculty.controller.ControllerDao;
import homeWork.faculty.model.Study;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 10.10.2016.
 */
public class StudyDaoImpl implements ControllerDao<Study> {
    @Override
    public List<Study> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insertEntity(Study entity) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteEntity(Study entity) throws SQLException {
        return false;
    }

    @Override
    public boolean updateEntity(Study entity) throws SQLException {
        return false;
    }
}

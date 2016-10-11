package homeWork.faculty.dao;

import homeWork.faculty.controller.ControllerDao;
import homeWork.faculty.model.Teacher;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */
public class TeacherDaoImpl implements ControllerDao<Teacher> {

    @Override
    public List getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insertEntity(Teacher entity) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteEntity(Teacher entity) throws SQLException {
        return false;
    }

    @Override
    public boolean updateEntity(Teacher entity) throws SQLException {
        return false;
    }

}

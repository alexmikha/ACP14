package homeWork.faculty.dao;

import homeWork.faculty.model.Student;
import homeWork.faculty.model.Teacher;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */
public class TeacherDaoImpl implements TeacherDao {
    @Override
    public List<Teacher> getTeacher() throws SQLException {
        return null;
    }

    @Override
    public boolean addTeacherToDB(Student student) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteTeacher(Student student) throws SQLException {
        return false;
    }
}

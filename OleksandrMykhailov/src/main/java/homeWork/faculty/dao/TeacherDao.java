package homeWork.faculty.dao;

import homeWork.faculty.model.Student;
import homeWork.faculty.model.Teacher;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */
public interface TeacherDao {

    List<Teacher> getTeacher() throws SQLException;

    boolean addTeacherToDB(Student student) throws SQLException;

    boolean deleteTeacher(Student student) throws SQLException;
}


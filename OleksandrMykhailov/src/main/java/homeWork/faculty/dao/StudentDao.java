package homeWork.faculty.dao;

import homeWork.faculty.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */
public interface StudentDao {

    List<Student> getStudents() throws SQLException;

    boolean addStudentToDB(Student student) throws SQLException;

    boolean deleteStudentFromDB(Student student) throws SQLException;
}

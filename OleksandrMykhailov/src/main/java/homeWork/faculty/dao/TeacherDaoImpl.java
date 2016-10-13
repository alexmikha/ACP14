package homeWork.faculty.dao;

import homeWork.faculty.controller.ControllerDao;
import homeWork.faculty.model.Teacher;
import homeWork.faculty.utilsDao.ConnectionClose;
import homeWork.faculty.utilsDao.ManagerConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */
public class TeacherDaoImpl implements ControllerDao<Teacher, Integer> {
    private static final Logger logger = Logger.getLogger(StudentDaoImpl.class);

    private PreparedStatement prstmt;
    private Connection connection = ManagerConnection.getConnection();
    private Statement statement;
    private ResultSet resultSet;

    public TeacherDaoImpl() throws SQLException {
    }

    @Override
    public List getAll() throws SQLException {
        logger.info("Calling method getAllTeachers");
        List<Teacher> teachers = new ArrayList<>();
        String teachersQuery = "SELECT id, name, experience, group_id FROM students";
        connection = ManagerConnection.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(teachersQuery);
            while (resultSet.next()) {
                Teacher teacher = new Teacher(resultSet);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            logger.error("not connection " + e.getMessage());
        } finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return teachers;
    }

    @Override
    public boolean insertEntity(Teacher teacher) throws SQLException {
        logger.info("Calling  method addTeacherToDB create new teacher");
        String addTeacher = "INSERT INTO students(name, experience, subject_id) VALUE (?,?,?)";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(addTeacher);
            prstmt.setString(1, teacher.getTeacherName());
            prstmt.setDouble(2, teacher.getExperience());
            prstmt.setInt(3, teacher.getSubjectId());
            prstmt.execute();
        } catch (SQLException e) {
            logger.error("Teacher was not add to DB" + e.getMessage());
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        logger.info("Teacher " + teacher.getTeacherName() + " was added to DB");
        return true;
    }

    @Override
    public boolean deleteEntity(Teacher teacher) throws SQLException {
        logger.info("Calling method deleteTeacher delete teacher from DB");
        String deleteTeacher = "DELETE FROM students WHERE id=?";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(deleteTeacher);
            prstmt.setInt(1, teacher.getId());
            prstmt.execute();
        } catch (SQLException e) {
            logger.error("Teacher was not delete from DB" + e.getMessage());
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        logger.error("Teacher " + teacher.getTeacherName() + " was delete to DB");
        return true;
    }

    @Override
    public boolean updateEntity(Teacher teacher) throws SQLException {
        logger.info("Calling method updateTeacher update teacher from DB");
        PreparedStatement prstmt = null;
        String updateStudent = "UPDATE students SET   name=?, avg=?, group_id=? WHERE id=?";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(updateStudent);
            prstmt.setString(1, teacher.getTeacherName());
            prstmt.setInt(2, teacher.getExperience());
            prstmt.setInt(3, teacher.getSubjectId());
            prstmt.setInt(4, teacher.getId());
            prstmt.execute();
        } catch (SQLException e) {
            logger.error("Teacher was not update from DB" + e.getMessage());
            return false;
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        logger.error("Teacher " + teacher.getTeacherName() + " was update to DB");
        return true;
    }

    @Override
    public Teacher getEntityById(Integer id) throws SQLException {
        logger.info("Calling method getEntityById");
        connection = ManagerConnection.getConnection();
        String idQuery = "SELECT * FROM teachers WHERE id=" + id + ";";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(idQuery);

            if (resultSet.next()) {
                Teacher teacher = new Teacher(resultSet);
                teacher.setTeacherName(resultSet.getString("name"));
                teacher.setExperience(resultSet.getInt("experience"));
                teacher.setSubjectId(resultSet.getInt("subject_id"));
                teacher.setId(resultSet.getInt("id"));
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        logger.info("Id of teacher successfully  got from DB");
        return null;
    }

}

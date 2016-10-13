package homeWork.faculty.dao;

import homeWork.faculty.controller.ControllerDao;
import homeWork.faculty.model.Student;
import homeWork.faculty.utilsDao.ConnectionClose;
import homeWork.faculty.utilsDao.ManagerConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by mi on 08.10.2016.
 */
public class StudentDaoImpl implements ControllerDao<Student, Integer> {

    private static final Logger logger = Logger.getLogger(StudentDaoImpl.class);

    private PreparedStatement prstmt;
    private Connection connection = ManagerConnection.getConnection();
    private Statement statement;
    private ResultSet resultSet;

    public StudentDaoImpl(Connection connection) throws SQLException {
        this.connection = ManagerConnection.getConnection();
    }

    public StudentDaoImpl() throws SQLException {

    }

    @Override
    public List<Student> getAll() throws SQLException {
        logger.info("Calling method getStudents");
        List<Student> students = new ArrayList<>();
        String studentsQuery = "SELECT id, name, avg, group_id FROM students";
        connection = ManagerConnection.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(studentsQuery);
            while (resultSet.next()) {
                Student student = new Student(resultSet);
                students.add(student);
            }
        } catch (SQLException e) {
            logger.error("not connection " + e.getMessage());
        } finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return students;
    }


    @Override
    public boolean insertEntity(Student student) throws SQLException {
        logger.info("Calling  method addStudentToDB create new student");
        String addStudent = "INSERT INTO students(name, avg, group_id) VALUE (?,?,?)";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(addStudent);
            prstmt.setString(1, student.getStudentName());
            prstmt.setDouble(2, student.getAvgScore());
            prstmt.setInt(3, student.getGroupId());
            prstmt.execute();
        } catch (SQLException e) {
            logger.error("Student was not add to DB" + e.getMessage());
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        logger.info("Student " + student.getStudentName() + " was add to DB");
        return true;
    }


    @Override
    public boolean deleteEntity(Student student) throws SQLException {
        logger.info("Calling method deleteStudent delete student from DB");
        PreparedStatement prstmt = null;
        String deleteStudett = "DELETE FROM students WHERE id=?";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(deleteStudett);
            prstmt.setInt(1, student.getId());
            prstmt.execute();
        } catch (SQLException e) {
            logger.error("Student was not delete from DB" + e.getMessage());
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        return true;
    }

    @Override
    public boolean updateEntity(Student student) throws SQLException {
        logger.info("Calling method updateStudent update student from DB");
        PreparedStatement prstmt = null;
        String updateStudent = "UPDATE students SET   name=?, avg=?, group_id=? WHERE id=?";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(updateStudent);
            prstmt.setString(1, student.getStudentName());
            prstmt.setDouble(2, student.getAvgScore());
            prstmt.setInt(3, student.getGroupId());
            prstmt.setInt(4, student.getId());
            prstmt.execute();
        } catch (SQLException e) {
            logger.error("Student was not update from DB" + e.getMessage());
            return false;
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        return true;
    }

    @Override
    public Student getEntityById(Integer id) throws SQLException {
        logger.info("Calling method getEntityById");
        connection = ManagerConnection.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students WHERE id=" + id + ";");

            if (resultSet.next()) {
                Student student = new Student(resultSet);
                student.setStudentName(resultSet.getString("name"));
                student.setAvgScore(resultSet.getInt("avr_score"));
                student.setGroupId(resultSet.getInt("group_id"));
                student.setId(resultSet.getInt("id"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        logger.info("Id of student successfully  got from DB");
        return null;
    }
}

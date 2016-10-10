package homeWork.faculty.dao;

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
public class StudentDaoImpl implements StudentDao {

    private PreparedStatement prstmt;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private static final Logger logger = Logger.getLogger(StudentDaoImpl.class);

    @Override
    public List<Student> getStudents() throws SQLException {
        logger.info("Calling method getStudents method");
        List<Student> students = new ArrayList<>();
        String studentsQuery = "SELECT id, studentName, avg_score, group_id FROM students";
        connection = ManagerConnection.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(studentsQuery);
            while (resultSet.next()) {
                Student student = new Student(resultSet);
                students.add(student);
            }
        } catch (Exception e){
            logger.error("not connection " + e.getMessage());
        }
        finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return students;
    }

    @Override
    @SuppressWarnings("JpaQueryApiInspection")
    public boolean addStudentToDB(Student student) throws SQLException {
        logger.info("Calling  method addStudentToDB create new student");
        PreparedStatement prstmt = null;
        String addStudent = "INSERT INTO students(studentName, avg_score, group_id) VALUE (?,?,?)";
        try {
            prstmt = connection.prepareStatement(addStudent);
            prstmt.setString(1, student.getStudentName());
            prstmt.setDouble(2, student.getAvgScore());
            prstmt.setInt(3, student.getGroupId());
            prstmt.execute();
        }catch (Exception e){
            logger.error("student was not add to DB");
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        return true;
    }


    @Override
    public boolean deleteStudentFromDB(Student student) throws SQLException {
        logger.info("Calling meyhod deleteStudent delete student from DB");
        PreparedStatement prstmt = null;
        try {
            prstmt = connection.prepareStatement(
                    "DELETE FROM students WHERE id=?");
            prstmt.setInt(1, student.getId());
            prstmt.execute();
        }catch (Exception e){
            logger.error("student was not delete from DB");
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        return true;
    }
}

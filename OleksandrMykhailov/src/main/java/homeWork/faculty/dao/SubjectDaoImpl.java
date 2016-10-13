package homeWork.faculty.dao;

import homeWork.faculty.controller.ControllerDao;
import homeWork.faculty.model.Subject;
import homeWork.faculty.utilsDao.ConnectionClose;
import homeWork.faculty.utilsDao.ManagerConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi on 13.10.2016.
 */
public class SubjectDaoImpl implements ControllerDao<Subject, Integer> {

    private static final Logger logger = Logger.getLogger(SubjectDaoImpl.class);

    private PreparedStatement prstmt;
    private Connection connection = ManagerConnection.getConnection();
    private Statement statement;
    private ResultSet resultSet;

    public SubjectDaoImpl() throws SQLException {
    }

    @Override
    public List<Subject> getAll() throws SQLException {
        logger.info("Calling method getStudents");
        List<Subject> subjects = new ArrayList<>();
        String subjectsQuery = "SELECT id, name, description FROM subjects";
        connection = ManagerConnection.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(subjectsQuery);
            while (resultSet.next()) {
                Subject subject = new Subject(resultSet);
                subjects.add(subject);
            }
        } catch (SQLException e) {
            logger.error("not connection " + e.getMessage());
        } finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return subjects;
    }

    @Override
    public boolean insertEntity(Subject subject) throws SQLException {
        logger.info("Calling  method addSubjectToDB create new subject");
        String addSubject = "INSERT INTO subjects(name, description) VALUE (?,?)";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(addSubject);
            prstmt.setString(1, subject.getSubjectName());
            prstmt.setString(2, subject.getDescription());
            prstmt.execute();
        } catch (SQLException e) {
            logger.error("Subject was not add to DB" + e.getMessage());
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        logger.info("Subject " + subject.getSubjectName() + " was add to DB");
        return true;
    }

    @Override
    public boolean deleteEntity(Subject subject) throws SQLException {
        logger.info("Calling method deleteSubject delete subject from DB");
        String deleteSubject = "DELETE FROM subjects WHERE id=?";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(deleteSubject);
            prstmt.setInt(1, subject.getId());
            prstmt.execute();
        } catch (SQLException e) {
            logger.error("Subject was not delete from DB" + e.getMessage());
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        logger.error("Subject " + subject.getSubjectName() + " was delete to DB");
        return true;
    }

    @Override
    public boolean updateEntity(Subject subject) throws SQLException {
        logger.info("Calling method updateSubject update subject from DB");
        String updateSubject = "UPDATE subjects SET name=?, description=? WHERE id=?";
        connection = ManagerConnection.getConnection();
        try {
            prstmt = connection.prepareStatement(updateSubject);
            prstmt.setString(1, subject.getSubjectName());
            prstmt.setString(2, subject.getDescription());
            prstmt.setInt(3, subject.getId());
            prstmt.execute();
        } catch (SQLException e) {
            logger.error("Subject was not update from DB" + e.getMessage());
            return false;
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        logger.error("Subject " + subject.getSubjectName() + " was update to DB");
        return true;
    }

    @Override
    public Subject getEntityById(Integer id) throws SQLException {
        logger.info("Calling method getSubjectById");
        connection = ManagerConnection.getConnection();
        String idQuery = "SELECT * FROM subjects WHERE id=" + id + ";";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(idQuery);
            if (resultSet.next()) {
                Subject subject = new Subject(resultSet);
                subject.setSubjectName(resultSet.getString("name"));
                subject.setDescription(resultSet.getString("description"));
                subject.setId(resultSet.getInt("id"));
                return subject;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        //    return null;
        }
        logger.info("Id of subject successfully  got from DB");
        return null;
    }
}

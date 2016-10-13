package TestDao;

import homeWork.faculty.dao.StudentDaoImpl;
import homeWork.faculty.model.Student;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created by mi on 10.10.2016.
 */
public class TestStudentsDaoImpl {

    private static final String PROPERTIES_PATH = "src/main/resources/database.properties";
    private static Connection connection;
    private static Properties properties;
    private static StudentDaoImpl studentDao;

    @BeforeClass
    public static void beforeClass() throws IOException, SQLException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(PROPERTIES_PATH)));
        connection = DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password"));
        studentDao = new StudentDaoImpl(connection);

    }

    @AfterClass
    public static void afterClass() throws SQLException {
        connection.close();
    }

    @Test
    public void getAllStudent() throws SQLException {
        List<Student> studentList = studentDao.getAll();
        Assert.assertNotNull(studentList);
        Assert.assertEquals(9, studentList.size());
    }

    @Test
    public void createStudent() throws SQLException {
        Student student = new Student();
        student.setStudentName("Test");
        student.setAvgScore(92.1);
        student.setGroupId(1);
        Assert.assertTrue(studentDao.insertEntity(student));
        List<Student> studentList = studentDao.getAll();
        for (int i = 0; i < studentList.size(); i++) {
            studentDao.deleteEntity(studentList.get(studentList.size() - 1));
        }
    }

    @Test
    public void deleteStudent() throws SQLException {
        List<Student> studentList = studentDao.getAll();
        studentDao.deleteEntity(studentList.get(studentList.size() - 1));
        studentDao.insertEntity(studentList.get(studentList.size() - 1));
        Assert.assertEquals(9, studentList.size());
    }

    @Test
    public void updateStudent() throws SQLException {
        String newStudentName = "updTest";
        double newAvg = 77.7;
        int newGroupId = 2;
        int oldId = 1;
        Student newStudent = new Student(newStudentName, newAvg, newGroupId);
        newStudent.setId(oldId);
        studentDao.updateEntity(newStudent);
        Assert.assertTrue(studentDao.updateEntity(newStudent));

    }
}

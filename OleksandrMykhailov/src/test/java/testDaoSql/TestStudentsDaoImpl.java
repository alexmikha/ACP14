//package testDaoSql;
//
//import homeWork.facultyHibernate.dao.StudentDaoImpl;
//import homeWork.facultyHibernate.model.Student;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Properties;
//
///**
// * Created by mi on 10.10.2016.
// */
//public class TestStudentsDaoImpl {
//
//    private static final String PROPERTIES_PATH = "src/main/resources/database.properties";
//    private static Connection connection;
//    private static Properties properties;
//    private static StudentDaoImpl studentDao;
//
//    @BeforeClass
//    public static void beforeClass() throws IOException, SQLException {
//        properties = new Properties();
//        properties.load(new FileInputStream(new File(PROPERTIES_PATH)));
//        connection = DriverManager.getConnection(
//                properties.getProperty("db.url"),
//                properties.getProperty("db.user"),
//                properties.getProperty("db.password"));
//        studentDao = new StudentDaoImpl(connection);
//
//    }
//
//    @AfterClass
//    public static void afterClass() throws SQLException {
//        connection.close();
//    }
//
//    @Test
//    public void getAllStudent() throws SQLException {
//        List<Student> studentList = studentDao.getAll();
//        Assert.assertNotNull(studentList);
//        Assert.assertEquals(3, studentList.size());
//    }
//
//    @Test
//    public void createStudent() throws SQLException {
//        Student student = new Student();
//        student.setStudentName("TestName");
//        student.setGroupId(1);
//        List<Student> studentListBefore = studentDao.getAll();
//
//        studentDao.insertEntity(student);
//
//        List<Student> studentList = studentDao.getAll();
//        Assert.assertNotEquals(studentListBefore.size(), studentList.size());
//
//        studentDao.deleteEntity(studentList.get(studentList.size() - 1));
//
//        List<Student> studentListAfter = studentDao.getAll();
//        Assert.assertEquals(studentListBefore.size(), studentListAfter.size());
//    }
//
//    @Test
//    public void deleteStudent() throws SQLException {
//        List<Student> studentList = studentDao.getAll();
//
//        studentDao.deleteEntity(studentList.get(studentList.size() - 1));
//        studentDao.insertEntity(studentList.get(studentList.size() - 1));
//
//        Assert.assertEquals(3, studentList.size());
//    }
//
//    @Test
//    public void updateStudent() throws SQLException {
//        List<Student> studentList = studentDao.getAll();
//        Student studentBeforeUpd = studentDao.getEntityById(studentList.get(studentList.size()-1).getId());
//        String newStudentName = "Orlov";
//        Student studentUpd = studentDao.getEntityById(studentList.get(studentList.size()-1).getId());
//        studentUpd.setStudentName(newStudentName);
//
//        studentDao.updateEntity(studentUpd);
//
//        Student studentAfterUpd = studentDao.getEntityById(1);
//        Assert.assertNotEquals(studentBeforeUpd, studentAfterUpd);
//    }
//
//    @Test
//    public void getStudentByID() throws SQLException {
//        Student student = studentDao.getEntityById(1);
//        Assert.assertNotNull(student);
//    }
//}

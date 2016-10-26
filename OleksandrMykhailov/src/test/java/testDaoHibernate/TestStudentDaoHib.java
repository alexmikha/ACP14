package testDaoHibernate;

import homeWork.facultyHibernate.dao.implemetation.GroupDaoImpl;
import homeWork.facultyHibernate.dao.implemetation.StudentDaoImpl;
import homeWork.facultyHibernate.model.Group;
import homeWork.facultyHibernate.model.Student;
import homeWork.facultyHibernate.utils.LoadDB;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 16.10.2016.
 */
public class TestStudentDaoHib {

    static EntityManagerFactory factory = null;
    static EntityManager manager = null;
    static StudentDaoImpl studentDao = null;
    static GroupDaoImpl groupDao;

    @BeforeClass
    public static void beforeClass() throws SQLException {
        factory = Persistence.createEntityManagerFactory("faculty_hibernate");
        LoadDB.addDataIntoDB();
        studentDao = new StudentDaoImpl(factory);
        groupDao = new GroupDaoImpl(factory);
    }

    @AfterClass
    public static void afterClass() throws SQLException {
        factory = Persistence.createEntityManagerFactory("faculty_hibernate");
        LoadDB.deleteFromTables();
        factory.close();
    }

    @Test
    public void getAllStudent() throws SQLException {
        List<Student> studentList = studentDao.getAll();
        Assert.assertNotNull(studentList);
    }


    @Test
    public void createStudent() throws SQLException {
        Group group = groupDao.getEntityById(groupDao.getAll().get(1).getId());
        boolean  createStudent= studentDao.insertEntity(new Student("Test", group));
        Assert.assertNotNull(createStudent);
    }


    @Test
    public void deleteStudent() throws SQLException {
        List<Student> studentListBefore = studentDao.getAll();

        studentDao.deleteEntity(studentListBefore.get(studentListBefore.size() - 1));

        List<Student> studentListAfter = studentDao.getAll();
        Assert.assertEquals(studentListBefore.size(), studentListAfter.size());

    }

    @Test
    public void updateStudent() throws SQLException {
        List<Student> studentList = studentDao.getAll();
        Student studentBeforeUpd = studentDao.getEntityById(studentList.get(studentList.size() - 1).getId());
        String newStudentName = "Orlovas";
        Student studentUpd = studentDao.getEntityById(studentList.get(studentList.size() - 1).getId());
        studentUpd.setStudentName(newStudentName);

        studentDao.updateEntity(studentUpd);
        List<Student> studentListAfter = studentDao.getAll();
        Student studentAfterUpd = studentDao.getEntityById(studentListAfter.get(studentList.size() - 1).getId());
        Assert.assertNotEquals(studentBeforeUpd.getStudentName(), studentAfterUpd.getStudentName());
    }

    @Test
    public void testGetStudentById() throws SQLException {
        int id = 1;
        Student student = studentDao.getEntityById(id);
        Assert.assertEquals(id, student.getId());
    }
}
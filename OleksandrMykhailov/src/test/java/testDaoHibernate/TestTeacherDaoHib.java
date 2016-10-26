package testDaoHibernate;

import homeWork.facultyHibernate.dao.implemetation.SubjectDaoImpl;
import homeWork.facultyHibernate.dao.implemetation.TeacherDaoImpl;
import homeWork.facultyHibernate.model.Subject;
import homeWork.facultyHibernate.model.Teacher;
import homeWork.facultyHibernate.utils.LoadDB;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 19.10.2016.
 */
public class TestTeacherDaoHib {
    static EntityManagerFactory factory = null;
    static TeacherDaoImpl teacherDao = null;
    static SubjectDaoImpl subjectDao = null;

    @BeforeClass
    public static void beforeClass() throws SQLException {
        factory = Persistence.createEntityManagerFactory("faculty_hibernate");
        LoadDB.addDataIntoDB();
        teacherDao = new TeacherDaoImpl(factory);
        subjectDao = new SubjectDaoImpl(factory);
    }

    @AfterClass
    public static void afterClass() throws SQLException {
        factory = Persistence.createEntityManagerFactory("faculty_hibernate");
        LoadDB.deleteFromTables();
        factory.close();
    }

    @Test
    public void getAllTeacher() throws SQLException {
        List<Teacher> teacherList = teacherDao.getAll();
        Assert.assertNotNull(teacherList);
    }

    @Test
    public void createTeacher() throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("newTeacher3");
        teacher.setExperience(12);
        Subject subject = new Subject();
        subject.setSubjectName("physics");
        teacher.setSubject(teacher.getSubject());
        List<Teacher> teacherListBefore = teacherDao.getAll();

        teacherDao.insertEntity(teacher);

        List<Teacher> teacherListAfter = teacherDao.getAll();
        Teacher teacher1 = teacherListAfter.get(teacherListAfter.size() - 1);
        Assert.assertEquals(teacher.getTeacherName(), teacher1.getTeacherName());
        Assert.assertNotEquals(teacherListBefore.size(), teacherListAfter.size());
    }

    @Test
    public void deleteTeacher() throws SQLException {
        List<Teacher> teacherListBefore = teacherDao.getAll();

        teacherDao.deleteEntity(teacherListBefore.get(teacherListBefore.size() - 1));

        List<Teacher> teacherListAfter = teacherDao.getAll();
        Assert.assertNotEquals(teacherListBefore.size(), teacherListAfter.size());
    }

    @Test
    public void updateTeacher() throws SQLException {
        List<Teacher> teacherList = teacherDao.getAll();
        Teacher teacherBeforeUpd = teacherDao.getEntityById(teacherList.get(teacherList.size() - 1).getId());
        String newTeacherName = "Orlenko";
        Teacher teacherUpd = teacherDao.getEntityById(teacherList.get(teacherList.size() - 1).getId());
        teacherUpd.setTeacherName(newTeacherName);

        teacherDao.updateEntity(teacherUpd);

        List<Teacher> teacherListAfter = teacherDao.getAll();
        Teacher teacherAfterUpd = teacherDao.getEntityById(teacherListAfter.get(teacherList.size() - 1).getId());
        Assert.assertNotEquals(teacherBeforeUpd.getTeacherName(), teacherAfterUpd.getTeacherName());
    }

    @Test
    public void testGetStudentById() throws SQLException {
        List<Teacher> teacherList = teacherDao.getAll();
        Teacher teacher = teacherList.get(teacherList.size() - 1);

        Teacher teacher1 = teacherDao.getEntityById(teacher.getId());
        Assert.assertEquals(teacher.getId(), teacher1.getId());
    }
}


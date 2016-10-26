package testDaoHibernate;

import homeWork.facultyHibernate.dao.implemetation.GroupDaoImpl;
import homeWork.facultyHibernate.dao.implemetation.SubjectDaoImpl;
import homeWork.facultyHibernate.model.Subject;
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
 * Created by Mi on 19.10.2016.
 */

public class TestSubjectDaoHib {

    static EntityManagerFactory factory = null;
    static SubjectDaoImpl subjectDao = null;
    static GroupDaoImpl groupDao;

    @BeforeClass
    public static void beforeClass() throws SQLException {
        factory = Persistence.createEntityManagerFactory("faculty_hibernate");
        LoadDB.addDataIntoDB();
        subjectDao = new SubjectDaoImpl(factory);
        groupDao = new GroupDaoImpl(factory);
    }

    @AfterClass
    public static void afterClass() throws SQLException {
        factory = Persistence.createEntityManagerFactory("faculty_hibernate");
        LoadDB.deleteFromTables();
        factory.close();
    }

    @Test
    public void getAllSubject() throws SQLException {
        List<Subject> subjectList = subjectDao.getAll();
        Assert.assertNotNull(subjectList);
    }


    @Test
    public void createSubject() throws SQLException {
        Subject subject = new Subject();
        subject.setSubjectName("physics");
        subject.setDescription("study");

        List<Subject> subjectListBefore = subjectDao.getAll();

        subjectDao.insertEntity(subject);
        List<Subject> subjectListAfter = subjectDao.getAll();
        Subject subject1 = subjectListAfter.get(subjectListAfter.size() - 1);
        Assert.assertEquals(subject.getSubjectName(), subject1.getSubjectName());

        Assert.assertNotEquals(subjectListBefore.size(), subjectListAfter.size());
    }


    @Test
    public void deleteSubject() throws SQLException {
        List<Subject> subjectListBefore = subjectDao.getAll();
        Subject subject = subjectListBefore.get(subjectListBefore.size() - 1);
        subjectDao.deleteEntity(subject);

        List<Subject> subjectListAfter = subjectDao.getAll();
        Subject subject1 = subjectListAfter.get(subjectListAfter.size() - 1);
        Assert.assertNotEquals(subject, subject1);
    }

    @Test
    public void updateSubject() throws SQLException {
        List<Subject> subjectList = subjectDao.getAll();
        Subject subjectBeforeUpd = subjectDao.getEntityById(subjectList.get(subjectList.size() - 1).getId());
        String newTeacherName = "Orlenko";
        Subject subjectUpd = subjectDao.getEntityById(subjectList.get(subjectList.size() - 1).getId());
        subjectUpd.setSubjectName(newTeacherName);

        subjectDao.updateEntity(subjectUpd);
        List<Subject> teacherListAfter = subjectDao.getAll();
        Subject subjectAfterUpd = subjectDao.getEntityById(teacherListAfter.get(subjectList.size() - 1).getId());
        Assert.assertNotEquals(subjectBeforeUpd.getSubjectName(), subjectAfterUpd.getSubjectName());
    }

    @Test
    public void testGetSubjectById() throws SQLException {
        List<Subject> subjectList = subjectDao.getAll();
        Subject subject = subjectList.get(subjectList.size() - 1);

        Subject subject1 = subjectDao.getEntityById(subject.getId());
        Assert.assertEquals(subject.getId(), subject1.getId());
    }
}


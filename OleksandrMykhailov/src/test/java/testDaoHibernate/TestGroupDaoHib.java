package testDaoHibernate;

import homeWork.facultyHibernate.dao.implemetation.GroupDaoImpl;
import homeWork.facultyHibernate.dao.implemetation.StudentDaoImpl;
import homeWork.facultyHibernate.dao.implemetation.TeacherDaoImpl;
import homeWork.facultyHibernate.model.Group;
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
public class TestGroupDaoHib {
    static EntityManagerFactory factory = null;
    static GroupDaoImpl groupDao = null;
    static StudentDaoImpl studentDao = null;
    static TeacherDaoImpl teacherDao = null;

    @BeforeClass
    public static void beforeClass() throws SQLException {
        factory = Persistence.createEntityManagerFactory("faculty_hibernate");
        groupDao = new GroupDaoImpl(factory);
        studentDao = new StudentDaoImpl(factory);
        teacherDao = new TeacherDaoImpl(factory);
        LoadDB.addDataIntoDB();
    }

    @AfterClass
    public static void afterClass() throws SQLException {
        factory = Persistence.createEntityManagerFactory("faculty_hibernate");
        LoadDB.deleteFromTables();
        factory.close();
    }

    @Test
    public void getAllGroup() throws SQLException {
        List<Group> groupList = groupDao.getAll();
        Assert.assertNotNull(groupList.size());
    }

    @Test
    public void createGroup() throws SQLException {
        Group group = new Group();
        String groupName = "IT_test";
        group.setGroupName(groupName);

        List<Group> groupListBefore = groupDao.getAll();

        groupDao.insertEntity(new Group(group.getGroupName()));
        List<Group> groupListAfter = groupDao.getAll();

        Assert.assertEquals(groupListBefore.size(), groupListAfter.size());

    }

    @Test
    public void deleteGroup() throws SQLException {
        Group group = groupDao.getEntityById(groupDao.getAll().get(1).getId());
        boolean deleteGroup = groupDao.deleteEntity(group);
        Assert.assertTrue(deleteGroup);

    }

    @Test
    public void updateGroup() throws SQLException {
        List<Group> groupList = groupDao.getAll();
        Group groupBeforeUpd = groupDao.getEntityById(groupList.get(groupList.size() - 1).getId());
        String newGroupName = "IT_upd";
        Group groupUpd = groupDao.getEntityById(groupList.get(groupList.size() - 1).getId());
        groupUpd.setGroupName(newGroupName);

        groupDao.updateEntity(groupUpd);
        List<Group> groupListAfter = groupDao.getAll();
        Group groupAfterUpd = groupDao.getEntityById(groupListAfter.get(groupList.size() - 1).getId());
        Assert.assertNotEquals(groupBeforeUpd.getGroupName(), groupAfterUpd.getGroupName());
    }

    @Test
    public void testGetGroupById() throws SQLException {
       // int id = 1;
        List<Group> groupList = groupDao.getAll();
        Group group = groupList.get(groupList.size() - 1);

        Group group1 = groupDao.getEntityById(group.getId());
        Assert.assertEquals(group.getId(), group1.getId());
    }
}



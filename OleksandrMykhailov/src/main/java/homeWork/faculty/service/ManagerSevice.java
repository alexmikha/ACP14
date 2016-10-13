package homeWork.faculty.service;

import homeWork.faculty.dao.GroupDaoImpl;
import homeWork.faculty.dao.StudentDaoImpl;
import homeWork.faculty.dao.StudyDaoImpl;
import homeWork.faculty.dao.TeacherDaoImpl;
import homeWork.faculty.model.Group;
import homeWork.faculty.model.Student;
import homeWork.faculty.model.Teacher;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 12.10.2016.
 */
public class ManagerSevice {

    private GroupDaoImpl groupDao;
    private StudentDaoImpl studentDao;
     StudyDaoImpl studyDao;
    private TeacherDaoImpl teacherDao;

    public ManagerSevice(GroupDaoImpl groupDao, StudentDaoImpl studentDao, StudyDaoImpl studyDao, TeacherDaoImpl teacherDao) {
        this.groupDao = groupDao;
        this.studentDao = studentDao;
        this.studyDao = studyDao;
        this.teacherDao = teacherDao;
    }

    public ManagerSevice() {

    }

    public List<Student> getAllStudents() throws SQLException {
        return studentDao.getAll();
    }

    public boolean updateStudent(Student entity) throws SQLException {
        return studentDao.updateEntity(entity);
    }

    public boolean createStudent(Student entity) throws SQLException {
        return studentDao.updateEntity(entity);
    }
    public boolean deleteStudent(Student entity) throws SQLException {
        return studentDao.deleteEntity(entity);
    }

    public List<Teacher> getAllTeacher() throws SQLException {
        return teacherDao.getAll();
    }

    public boolean updateTeacher(Teacher entity) throws SQLException {
        return teacherDao.updateEntity(entity);
    }

    public boolean createTeacher(Teacher entity) throws SQLException {
        return teacherDao.insertEntity(entity);
    }
    public boolean deleteTeacher(Teacher entity) throws SQLException {
        return teacherDao.deleteEntity(entity);
    }

    public List<Group> getAllGroup() throws SQLException {
        return groupDao.getAll();
    }

    public boolean updateGroup(Group entity) throws SQLException {
        return groupDao.updateEntity(entity);
    }

    public boolean createGroup(Group entity) throws SQLException {
        return groupDao.insertEntity(entity);
    }
    public boolean deleteGroup(Group entity) throws SQLException {
        return groupDao.deleteEntity(entity);
    }
}

package homeWork.facultyHibernate.service;

import homeWork.facultyHibernate.dao.implemetation.GroupDaoImpl;
import homeWork.facultyHibernate.dao.implemetation.StudentDaoImpl;
import homeWork.facultyHibernate.dao.implemetation.TeacherDaoImpl;
import homeWork.facultyHibernate.model.Group;
import homeWork.facultyHibernate.model.Student;
import homeWork.facultyHibernate.model.Teacher;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 12.10.2016.
 */
public class ManagerService {

    private GroupDaoImpl groupDaoService;
    private StudentDaoImpl studentDaoService;
    private TeacherDaoImpl teacherDaoService;


    public ManagerService(GroupDaoImpl groupDaoService, StudentDaoImpl studentDaoService, TeacherDaoImpl teacherDaoService) {
        this.groupDaoService = groupDaoService;
        this.studentDaoService = studentDaoService;
        this.teacherDaoService = teacherDaoService;
    }

    public ManagerService() {

    }

    public List<Student> getAllStudents() throws SQLException {
        return studentDaoService.getAll();
    }

    public boolean updateStudent(Student entity) throws SQLException {
        return studentDaoService.updateEntity(entity);
    }

    public boolean createStudent(Student entity) throws SQLException {
        return studentDaoService.updateEntity(entity);
    }

    public boolean deleteStudent(Student entity) throws SQLException {
        return studentDaoService.deleteEntity(entity);
    }

    public List<Teacher> getAllTeacher() throws SQLException {
        return teacherDaoService.getAll();
    }

    public boolean updateTeacher(Teacher entity) throws SQLException {
        return teacherDaoService.updateEntity(entity);
    }

    public boolean createTeacher(Teacher entity) throws SQLException {
        return teacherDaoService.insertEntity(entity);
    }

    public boolean deleteTeacher(Teacher entity) throws SQLException {
        return teacherDaoService.deleteEntity(entity);
    }

    public List<Group> getAllGroup() throws SQLException {
        return groupDaoService.getAll();
    }

    public boolean updateGroup(Group entity) throws SQLException {
        return groupDaoService.updateEntity(entity);
    }

    public boolean createGroup(Group entity) throws SQLException {
        return groupDaoService.insertEntity(entity);
    }

    public boolean deleteGroup(Group entity) throws SQLException {
        return groupDaoService.deleteEntity(entity);
    }
}

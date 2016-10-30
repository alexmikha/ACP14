package homeWork.facultyHibernate.service;

import homeWork.facultyHibernate.dao.implemetation.GroupDaoImpl;
import homeWork.facultyHibernate.dao.implemetation.StudentDaoImpl;
import homeWork.facultyHibernate.dao.implemetation.SubjectDaoImpl;
import homeWork.facultyHibernate.dao.implemetation.TeacherDaoImpl;
import homeWork.facultyHibernate.model.Group;
import homeWork.facultyHibernate.model.Student;
import homeWork.facultyHibernate.model.Subject;
import homeWork.facultyHibernate.model.Teacher;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 12.10.2016.
 */
public class ManagerServiceImpl implements ManagerService{

    private GroupDaoImpl groupDaoService;
    private StudentDaoImpl studentDaoService;
    private TeacherDaoImpl teacherDaoService;
    private SubjectDaoImpl subjectDaoServise;


    public ManagerServiceImpl(GroupDaoImpl groupDaoService, StudentDaoImpl studentDaoService, TeacherDaoImpl teacherDaoService, SubjectDaoImpl subjectDaoServise) {
        this.groupDaoService = groupDaoService;
        this.studentDaoService = studentDaoService;
        this.teacherDaoService = teacherDaoService;
        this.subjectDaoServise = subjectDaoServise;
    }

    public ManagerServiceImpl() {

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

    @Override
    public Student findStudentById(Object id) throws SQLException {
        return studentDaoService.getEntityById((Integer) id);
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

    @Override
    public Teacher findTeacherById(Object id) throws SQLException {
        return teacherDaoService.getEntityById((Integer) id);
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

    @Override
    public Group findGroupById(Object id) throws SQLException {
         return groupDaoService.getEntityById((Integer) id);
    }

    @Override
    public List<Subject> getAllSubject() throws SQLException {
        return subjectDaoServise.getAll();
    }

    @Override
    public boolean updateSubject(Subject entity) throws SQLException {
        return subjectDaoServise.updateEntity(entity);
    }

    @Override
    public boolean createSubject(Subject entity) throws SQLException {
        return subjectDaoServise.insertEntity(entity);
    }

    @Override
    public boolean deleteSubject(Subject entity) throws SQLException {
        return subjectDaoServise.deleteEntity(entity);
    }

    @Override
    public Subject findSubjectById(Object id) throws SQLException {
        return subjectDaoServise.getEntityById((Integer) id);
    }
}

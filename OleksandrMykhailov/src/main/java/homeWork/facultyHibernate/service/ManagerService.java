package homeWork.facultyHibernate.service;

import homeWork.facultyHibernate.model.Group;
import homeWork.facultyHibernate.model.Student;
import homeWork.facultyHibernate.model.Subject;
import homeWork.facultyHibernate.model.Teacher;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mi on 24.10.2016.
 */
public interface ManagerService {


    List<Student> getAllStudents() throws SQLException;
    boolean updateStudent(Student entity) throws SQLException;
    boolean createStudent(Student entity) throws SQLException;
    boolean deleteStudent(Student entity) throws SQLException;
    Student findStudentById(Object id) throws SQLException;

    List<Teacher> getAllTeacher() throws SQLException;
    boolean updateTeacher(Teacher entity) throws SQLException;
    boolean createTeacher(Teacher entity) throws SQLException;
    boolean deleteTeacher(Teacher entity) throws SQLException;
    Teacher findTeacherById(Object id) throws SQLException;

    List<Group> getAllGroup() throws SQLException;
    boolean updateGroup(Group entity) throws SQLException;
    boolean createGroup(Group entity) throws SQLException;
    boolean deleteGroup(Group entity) throws SQLException;
    Group findGroupById(Object id) throws SQLException;

    List<Subject> getAllSubject() throws SQLException;
    boolean updateSubject(Subject entity) throws SQLException;
    boolean createSubject(Subject entity) throws SQLException;
    boolean deleteSubject(Subject entity) throws SQLException;
    Subject findSubjectById(Object id) throws SQLException;
}

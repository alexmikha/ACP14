package homeWork.facultyHibernate.dao.implemetation;

import homeWork.facultyHibernate.dao.GeneralDao;
import homeWork.facultyHibernate.dao.StudentDao;
import homeWork.facultyHibernate.model.Group;
import homeWork.facultyHibernate.model.Student;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by mi on 08.10.2016.
 */
public class StudentDaoImpl implements GeneralDao<Student, Integer>, StudentDao {

    private EntityManagerFactory factory;

    public StudentDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Student> getAll() throws SQLException {

        EntityManager manager = factory.createEntityManager();
        TypedQuery<Student> query = manager.createNamedQuery("Student.getAll", Student.class);
        query.setMaxResults(20);
        query.setFirstResult(0);
        List<Student> studentList = query.getResultList();
        manager.close();
        return studentList;
    }

    @Override
    public boolean insertEntity(Student student) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.merge(student);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            manager.close();
        }
        return true;
    }

    @Override
    public boolean deleteEntity(Student student) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            student = manager.find(student.getClass(), student.getId());
            manager.remove(student);
            manager.flush();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            manager.close();
        }
        return true;
    }


    @Override
    public boolean updateEntity(Student student) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        if (student == null) {
            throw new IllegalArgumentException("Unknown student id");
        }
        try {
            transaction.begin();
            manager.merge(student);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            manager.close();
        }
        return true;
    }

    @Override
    public Student getEntityById(Integer id) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        Student student = manager.find(Student.class, id);
        manager.close();
        return student;
    }

    @Override
    public List<Student> getListOfStudentsInGroup(Group group) {
        EntityManager manager = factory.createEntityManager();
        List<Student> students = manager.createQuery("SELECT s FROM Student s WHERE s.group LIKE :group").
                setParameter("group", group).getResultList();
        if (students != null) {
            return students;
        } else {
            throw new EntityNotFoundException("Students with group " + group + "not found");
        }
    }
}

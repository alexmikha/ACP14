package homeWork.facultyHibernate.dao.implemetation;

import homeWork.facultyHibernate.dao.GeneralDao;
import homeWork.facultyHibernate.dao.TeacherDao;
import homeWork.facultyHibernate.model.Teacher;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */
public class TeacherDaoImpl implements GeneralDao<Teacher, Integer>, TeacherDao {
    private EntityManagerFactory factory;

    public TeacherDaoImpl(EntityManagerFactory factory) {

        this.factory = factory;
    }

    public TeacherDaoImpl() {

    }

    @Override
    public List<Teacher> getAll() throws SQLException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Teacher> query = manager.createNamedQuery("Teacher.getAll", Teacher.class);
        query.setMaxResults(20);
        query.setFirstResult(0);
        List<Teacher> teacherList = query.getResultList();
        manager.close();
        return teacherList;
    }

    @Override
    public boolean insertEntity(Teacher teacher) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(teacher);
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
    public boolean deleteEntity(Teacher teacher) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            teacher = manager.find(Teacher.class, teacher.getId());
            manager.remove(teacher);
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
    public boolean updateEntity(Teacher teacher) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        if (teacher == null) {
            throw new IllegalArgumentException("Unknown teacher id");
        }
        try {
            transaction.begin();
            manager.merge(teacher);
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
    public Teacher getEntityById(Integer id) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        try {
            Teacher teacher = manager.find(Teacher.class, id);
            return teacher;
        } finally {
            manager.close();

        }
    }

    @Override
    public List<Teacher> getMaxExperienceTeacher() {
        EntityManager manager = factory.createEntityManager();
        List<Teacher> teachers = manager.createQuery
                ("SELECT t FROM Teacher t WHERE t.experience = (SELECT MAX(tt.experience) FROM Teacher tt)").getResultList();
        if (teachers.size() != 0) {
            return teachers;
        } else {
            throw new EntityNotFoundException("Teacher have not max experience");
        }
    }

    @Override
    public List<Teacher> getLessExperienceTeacher() {
        EntityManager manager = factory.createEntityManager();
        List<Teacher> teachers = manager.createQuery
                ("SELECT t FROM Teacher t WHERE t.experience = (SELECT MIN(tt.experience) FROM Teacher tt)").getResultList();
        if (teachers.size() != 0) {
            return teachers;
        } else {
            throw new EntityNotFoundException("Teacher have not less experience");
        }
    }

    @Override
    public List<Teacher> getTeachersWithMoreYearsExperience(int experience) {
        EntityManager manager = factory.createEntityManager();
        List<Teacher> teachers = manager.createQuery("SELECT t FROM Teacher t WHERE t.experience > :experience").
                setParameter("experience", experience).getResultList();
        if (teachers != null) {
            return teachers;
        } else {
            throw new EntityNotFoundException("No teachers taught for more than " + experience  + " years");
        }
    }
}
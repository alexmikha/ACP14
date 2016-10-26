package homeWork.facultyHibernate.dao.implemetation;

import homeWork.facultyHibernate.dao.GeneralDao;
import homeWork.facultyHibernate.dao.SubjectDao;
import homeWork.facultyHibernate.model.Subject;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 13.10.2016.
 */
public class SubjectDaoImpl implements GeneralDao<Subject, Integer>, SubjectDao {

    private EntityManagerFactory factory;

    public SubjectDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Subject> getAll() throws SQLException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Subject> query = manager.createNamedQuery("Subject.getAll", Subject.class);
        query.setMaxResults(20);
        query.setFirstResult(0);
        List<Subject> subjectList = query.getResultList();
        manager.close();
        return subjectList;
    }

    @Override
    public boolean insertEntity(Subject entity) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(entity);
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
    public boolean deleteEntity(Subject entity) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            entity = manager.find(Subject.class, entity.getId());
            manager.remove(entity);
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
    public boolean updateEntity(Subject entity) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        if (entity == null) {
            throw new IllegalArgumentException("Unknown teacher id");
        }
        try {
            transaction.begin();
            manager.merge(entity);
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
    public Subject getEntityById(Integer id) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        try {
            Subject subject = manager.find(Subject.class, id);
            return subject;
        } finally {
            manager.close();

        }
    }

    @Override
    public List<Subject> getHumanitarSubjects() {
        EntityManager manager = factory.createEntityManager();
        List<Subject> gumanitariumSubjects = manager.createQuery("SELECT s FROM Subject s WHERE s.name IN ('history', 'language', 'economy')").getResultList();
        if (gumanitariumSubjects != null) {
            return gumanitariumSubjects;
        } else {
            throw new EntityNotFoundException("Humanitarian subjects not found" );
        }

    }
}


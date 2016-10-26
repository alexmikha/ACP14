package homeWork.facultyHibernate.controller;

import homeWork.facultyHibernate.model.IdEntity;
import homeWork.facultyHibernate.model.Subject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.sql.SQLException;

/**
 * Created by Mi on 22.10.2016.
 */
public class GenerDao {

    private EntityManagerFactory factory;

    public boolean getAll() throws SQLException {
        return false;
    }


    public boolean insertEntity(Object entity) throws SQLException {
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


    public boolean deleteEntity(Object entity, IdEntity element) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            entity = manager.find(Object.class, element.getId());
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


    public boolean updateEntity(Object entity) throws SQLException {
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


    public Object getEntityById(Integer id) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        try {
            Object o = manager.find(Object.class, id);
            return o;
        } finally {
            manager.close();

        }
    }
}
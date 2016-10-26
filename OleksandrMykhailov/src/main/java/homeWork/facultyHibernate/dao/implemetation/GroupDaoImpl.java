package homeWork.facultyHibernate.dao.implemetation;

import homeWork.facultyHibernate.dao.GeneralDao;
import homeWork.facultyHibernate.dao.GroupDao;
import homeWork.facultyHibernate.model.Group;
import homeWork.facultyHibernate.model.Subject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 10.10.2016.
 */
public class GroupDaoImpl implements GeneralDao<Group, Integer>, GroupDao  {
    private EntityManagerFactory factory;

    public GroupDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Group> getAll() throws SQLException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Group> query = manager.createNamedQuery("Group.getAll", Group.class);
        query.setMaxResults(20);
        query.setFirstResult(0);
        List<Group> groupList = query.getResultList();
        manager.close();
        return groupList;
    }

    @Override
    public boolean insertEntity(Group entity) throws SQLException {
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
    public boolean deleteEntity(Group entity) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            entity = manager.find(Group.class, entity.getId());
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
    public boolean updateEntity(Group entity) throws SQLException {
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
    public Group getEntityById(Integer id) throws SQLException {
        EntityManager manager = factory.createEntityManager();
        try {
            Group group = manager.find(Group.class, id);
            return group;
        } finally {
            manager.close();

        }
    }

    @Override
    public List<Group> getGroupsThatStudySubject(Subject subject) {
        return null;
    }
}

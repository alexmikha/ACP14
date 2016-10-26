package library.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import library.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

/**
 * Created by mi on 22.10.16.
 */
@Component
//@Scope(value = "singleton")
public class AuthorDao implements Dao<Author> {

    private static final Logger LOGGER = Logger.getLogger(library.dao.BookDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public AuthorDao() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public boolean delete(Author book) {
        return false;
    }

    @Override
    public Author update(Author book) {
        return null;
    }

    @Override
    public Author findById(Object id) {
        return null;
    }

}

package week6.jpa.dao;

/**
 * Created by mi on 13.10.2016.
 */
public interface Dao<T> {

    T create(T entity);

    boolean delete(T entity);

    T update(T entity);

    T findById(Object id);


}



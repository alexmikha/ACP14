package library.dao;

import library.model.Book;

/**
 * Created by mi on 22.10.16.
 */
public interface Dao<T> {

    T create(T book);
    boolean delete(T book);
    T update(T book);
    T findById(Object id);

}

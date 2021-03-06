package homeWork.faculty.controller;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */
public interface ControllerDao<E, K> {
    List<E> getAll()throws SQLException;
    boolean insertEntity(E entity)throws SQLException;
    boolean deleteEntity(E entity)throws SQLException;
    boolean updateEntity(E entity)throws SQLException;
    E getEntityById(K id) throws SQLException;
}

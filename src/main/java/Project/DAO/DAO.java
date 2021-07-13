package Project.DAO;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by .
 */
public interface DAO<T>  {
    void save(T t) throws SQLException;

    T get(Long id) throws SQLException;


    void delete(Long id) throws SQLException;
}

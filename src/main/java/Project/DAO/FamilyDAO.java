package Project.DAO;

import Project.Entity.Family;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by .
 */
public interface FamilyDAO extends DAO<Family> {
    void change(Long id, String lastName) throws SQLException;

    Boolean findLoginAndPassword(String login, String password) throws SQLException;

    Family getByLoginAndPassword(String login,String password) throws SQLException;
}

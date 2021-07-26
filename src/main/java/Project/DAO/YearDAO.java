package Project.DAO;

import Project.Entity.Month;
import Project.Entity.Year;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by .
 */
public interface YearDAO extends DAO<Year> {
    List<Year> getAllYear(String lastnameFamily);

    List<Month> getAllMonth(Long year);

    void addMonth(Month month, Long idYear) throws SQLException;

    void deleteMonth(Long idMonth) throws SQLException;
}

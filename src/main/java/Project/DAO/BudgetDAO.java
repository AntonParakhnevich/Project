package Project.DAO;

import Project.Entity.Budget;
import Project.Entity.Year;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

/**
 * Created by .
 */
public interface BudgetDAO extends DAO<Budget> {
    void addYear(Year year, Long id) throws SQLException;
}

package Project.DAO;

import Project.Entity.CategoryCost;
import Project.Entity.Expenses;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by .
 */
public interface ExpensesDAO extends DAO<Expenses> {
    BigDecimal sumExpensesInMonth(String name) throws SQLException;

    void addCategoryCost(CategoryCost cost,Long idMonth);
}

package Project.DAO;

import Project.Entity.CategoryIncome;
import Project.Entity.Income;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by .
 */
public interface IncomesDAO extends DAO<Income> {
    BigDecimal sumIncomes(String month) throws SQLException;

    void addCategory(CategoryIncome categoryIncome,Long idMonth) throws SQLException;
}

package Project.DAO;

import Project.Entity.CategoryIncome;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by .
 */
public interface CategoryIncomeDAO extends DAO<CategoryIncome> {
    void changeName(String name, Long id) throws SQLException;

    List<CategoryIncome> getAll(Long idMonth);
}

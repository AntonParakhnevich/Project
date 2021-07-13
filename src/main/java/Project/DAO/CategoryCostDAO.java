package Project.DAO;

import Project.Entity.CategoryCost;
import Project.Entity.CategoryIncome;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public interface CategoryCostDAO extends DAO<CategoryCost> {
    public void changeName(String name,Long id) throws SQLException;

    List<CategoryCost> getAll(Long idMonth);
}

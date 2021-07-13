package Project.Service;

import Project.DAO.ImplCategoryCostDao;
import Project.Entity.CategoryCost;
import Project.Entity.Expenses;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class CategoryCostService {
    ImplCategoryCostDao implCategoryCostDao = new ImplCategoryCostDao();

    public void save(CategoryCost categoryCost) {
        try {
            implCategoryCostDao.save(categoryCost);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Long id) {
        try {
            implCategoryCostDao.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public CategoryCost get(Long id) {
        CategoryCost categoryCost = null;
        try {
            categoryCost = implCategoryCostDao.get(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryCost;
    }

    public List<CategoryCost> getAllCategory(Long idMonth) {
        return implCategoryCostDao.getAll(idMonth);
    }

}

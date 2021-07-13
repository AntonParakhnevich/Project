package Project.Service;

import Project.DAO.ImplCategoryIncomeDao;
import Project.Entity.CategoryIncome;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class CategoryIncomeService {
    ImplCategoryIncomeDao implCategoryIncomeDao = new ImplCategoryIncomeDao();

    public void save(CategoryIncome categoryIncome) {
        try {
            implCategoryIncomeDao.save(categoryIncome);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public CategoryIncome get(Long id) {
        CategoryIncome categoryIncome = null;
        try {
            categoryIncome = implCategoryIncomeDao.get(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryIncome;
    }

    public void delete(Long id) {
        try {
            implCategoryIncomeDao.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void changeName(String name, Long id) {
        try {
            implCategoryIncomeDao.changeName(name, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<CategoryIncome> getAll(Long idMonth){
        return implCategoryIncomeDao.getAll(idMonth);
    }


}

package Project.Service;

import Project.DAO.ImplExpensesDao;
import Project.Entity.CategoryCost;
import Project.Entity.Expenses;
import Project.Entity.Year;

import java.sql.SQLException;

/**
 * Created by .
 */
public class ExpensesService {
    ImplExpensesDao implExpensesDao = new ImplExpensesDao();

    public void saveExpenses(Expenses expenses) {
        try {
            implExpensesDao.save(expenses);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteExpenses(Long id) {
        try {
            implExpensesDao.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Expenses getExpenses(Long id) {
        Expenses expenses = null;
        try {
            expenses = implExpensesDao.get(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return expenses;
    }


    public void addCategoryCost(CategoryCost cost,Long id){
        implExpensesDao.addCategoryCost(cost, id);
    }
}

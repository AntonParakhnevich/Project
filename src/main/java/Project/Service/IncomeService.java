package Project.Service;

import Project.DAO.ImplIncomesDao;
import Project.Entity.CategoryCost;
import Project.Entity.CategoryIncome;
import Project.Entity.Expenses;
import Project.Entity.Income;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by .
 */
public class IncomeService {
    ImplIncomesDao implIncomesDao=new ImplIncomesDao();

    public void saveIncome(Income expenses) {
        try {
            implIncomesDao.save(expenses);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteIncome(Long id) {
        try {
            implIncomesDao.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Income getIncome(Long id) {
        Income income = null;
        try {
            income = implIncomesDao.get(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return income;
    }

    public BigDecimal getIncomesInMonth(String nameMonth){
        BigDecimal bigDecimal=null;
        try {
             bigDecimal = implIncomesDao.sumIncomes(nameMonth);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bigDecimal;
    }

    public void addCategoryCost(CategoryIncome categoryIncome, Long id){
        try {
            implIncomesDao.addCategory(categoryIncome, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}

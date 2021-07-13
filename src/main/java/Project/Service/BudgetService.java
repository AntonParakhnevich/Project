package Project.Service;

import Project.DAO.ImplBudgetDao;
import Project.Entity.Year;

import java.sql.SQLException;

/**
 * Created by .
 */
public class BudgetService {
    ImplBudgetDao implBudgetDao=new ImplBudgetDao();

    public void addYear(Year year,Long id){
        try {
            implBudgetDao.addYear(year,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

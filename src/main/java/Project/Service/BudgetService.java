package Project.Service;

import Project.DAO.ImplBudgetDao;
import Project.Entity.Year;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

/**
 * Created by .
 */
@Slf4j // for logging
public class BudgetService {
    ImplBudgetDao implBudgetDao=new ImplBudgetDao();

    public void addYear(Year year,Long id){
        try {
            implBudgetDao.addYear(year,id);
        } catch (SQLException throwables) { // name just e, ex or exception
            // log.error(throwables.getMessage(), throwables); попробуй раскомментить и посмотри определит ли этот метод у тебя , у меня почему-то не подхватывает
            throwables.printStackTrace();
        }
    }
    public static Integer calculationAccumulationForTheTime(int years,int income,int cost){ // why this method is static?
        return years*12*(income-cost);
    }
}

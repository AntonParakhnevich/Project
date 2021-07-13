package Project.DAO;

import Project.Entity.Budget;
import Project.Entity.Year;
import Project.Util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 * Created by .
 */
public class ImplBudgetDao implements BudgetDAO{
    @Override
    public void addYear(Year year, Long id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Budget budget = session.get(Budget.class, id);
        budget.addYear(year);
        session.update(budget);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void save(Budget budget) throws SQLException {

    }

    @Override
    public Budget get(Long id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Long id) throws SQLException {

    }

}

package Project.DAO;

import Project.Entity.CategoryCost;
import Project.Entity.CategoryIncome;
import Project.Entity.Expenses;
import Project.Entity.Month;
import Project.Util.SessionUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */


public class ImplExpensesDao implements ExpensesDAO{
    @Override
    public void save(Expenses expenses) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(expenses);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Expenses get(Long id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Expenses expenses = session.get(Expenses.class, id);
        session.getTransaction().commit();
        session.close();
        return expenses;
    }

    @Override
    public void delete(Long id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.delete(id);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public BigDecimal sumExpensesInMonth(String name) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        List<BigDecimal> resultList = session.createNativeQuery("select sum(cc.price) from expenses left join months m on expenses.id = m.expenses_id\n" +
                "left join expenses_category_cost ecc on expenses.id = ecc.E_ID\n" +
                "left join category_cost cc on cc.id = ecc.CC_ID where m.name=?").setParameter(1, name).getResultList();
        return resultList.get(0);
    }

    @Override
    public void addCategoryCost(CategoryCost cost, Long idMonth) {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Month month = session.get(Month.class, idMonth);
        month.getExpenses().addCategory(cost);
        session.update(month);
        session.getTransaction().commit();
        session.close();
    }
}

package Project.DAO;

import Project.Entity.CategoryIncome;
import Project.Entity.Income;
import Project.Entity.Month;
import Project.Util.SessionUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class ImplIncomesDao implements IncomesDAO {
    @Override
    public void save(Income income) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(income);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Income get(Long id) throws SQLException {

        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Income income = session.get(Income.class, id);
        session.getTransaction().commit();
        session.close();
        return income;
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
    public BigDecimal sumIncomes(String month) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        List<BigDecimal> resultList = session.createNativeQuery("select sum(ci.value) from incomes" +
                " left join months m on incomes.id = m.income_id " +
                "left join income_category_income ici on incomes.id = ici.In_ID " +
                "left join category_income ci on ci.id = ici.CI_ID where m.name=?")
                .setParameter(1, month)
                .getResultList();
        return resultList.get(0);
    }

    @Override
    public void addCategory(CategoryIncome categoryIncome,Long idMonth) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Month month = session.get(Month.class, idMonth);
        month.getIncome().addCategory(categoryIncome);
        session.update(month);
        session.getTransaction().commit();
        session.close();
    }
}

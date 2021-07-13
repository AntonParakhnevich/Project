package Project.DAO;

import Project.Entity.CategoryCost;
import Project.Entity.CategoryIncome;
import Project.Util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by .
 */
public class ImplCategoryIncomeDao implements CategoryIncomeDAO {

    @Override
    public void changeName(String name, Long id) throws SQLException {
        Session session = SessionUtil.getSession();
        CategoryCost categoryCost = session.get(CategoryCost.class, id);
        categoryCost.setName(name);
        session.update(categoryCost);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void save(CategoryIncome categoryIncome) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(categoryIncome);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CategoryIncome get(Long id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        CategoryIncome categoryIncome = session.get(CategoryIncome.class, id);
        session.getTransaction().commit();
        session.close();
        return categoryIncome;
    }

    @Override
    public void delete(Long id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.createNativeQuery("delete from income_category_income where CI_ID=?;")
                .setParameter(1, id)
                .executeUpdate();
        session.createNativeQuery("delete from category_income where id=?;")
                .setParameter(1,id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<CategoryIncome> getAll(Long idMonth) {

        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        List<CategoryIncome> resultList = session.createNativeQuery("select category_income.id, category_income.name, category_income.value from category_income left join income_category_income ici on category_income.id = ici.CI_ID\n" +
                "left join incomes i on i.id = ici.In_ID\n" +
                "left join months m on i.id = m.income_id where m.id=?;", CategoryIncome.class).setParameter(1, idMonth).getResultList();
        session.getTransaction().commit();
        session.close();
        return  resultList;
    }
}

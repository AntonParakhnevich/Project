package Project.DAO;

import Project.Entity.CategoryCost;
import Project.Entity.CategoryIncome;
import Project.Util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class ImplCategoryCostDao implements CategoryCostDAO { // as I know the common practise is to name such classes CategoryCostDaoImpl
    @Override
    public void save(CategoryCost cost) throws SQLException { // remove unnecessary exception declaration, after that you could remove try-catch in services
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(cost);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CategoryCost get(Long id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        CategoryCost categoryCost = session.get(CategoryCost.class, id);
        session.getTransaction().commit();
        session.close();
        return categoryCost;
    }

    @Override
    public void delete(Long id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.createNativeQuery("delete from expenses_category_cost where CC_ID=?;")
                .setParameter(1, id).executeUpdate();
        session.createNativeQuery("delete from category_cost where id=?;").setParameter(1,id).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void changeName(String name, Long id) {
        Session session = SessionUtil.getSession();
        CategoryCost categoryCost = session.get(CategoryCost.class, id);
        categoryCost.setName(name);
        session.update(categoryCost);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<CategoryCost> getAll(Long idMonth) {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        List<CategoryCost> resultList = session.createNativeQuery("select category_cost.id, category_cost.name,category_cost.price,category_cost.binding from category_cost left join expenses_category_cost ecc on category_cost.id = ecc.CC_ID\n" +
                "left join expenses e on e.id = ecc.E_ID\n" +
                "left join months m on e.id = m.expenses_id where m.id=?", CategoryCost.class)
                .setParameter(1, idMonth)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return resultList;
    }
}

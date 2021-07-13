package Project.DAO;

import Project.Entity.Month;
import Project.Entity.Year;
import Project.Util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by .
 */
public class ImplDaoYear implements YearDAO {
    @Override
    public void save(Year year) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(year);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Year get(Long id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Year year = session.get(Year.class, id);
        session.getTransaction().commit();
        session.close();
        return year;
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
    public List<Year> getAllYear(String lastnameFamily) {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
//        List<Integer> resultList = session.createNativeQuery("select y.year FROM family left join budget b on family.id = b.family_id\n" +
//                "left join budget_year `by` on b.id = `by`.B_ID\n" +
//                "left join year y on y.id = `by`.Y_ID where family.login=?").setParameter(1, lastnameFamily).getResultList();

        List<Year> resultList = session.createNativeQuery("select year.id, year from year left join budget_year `by` on year.id = `by`.Y_ID\n" +
                "left join budget b on b.id = `by`.B_ID\n" +
                "left join family f on f.id = b.family_id where login=?;", Year.class).setParameter(1, lastnameFamily).getResultList();
        session.getTransaction().commit();
        session.close();
        return resultList;
    }

    @Override
    public List<Month> getAllMonth(Long year) {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        List<Month> allMonth = session.createNativeQuery("select months.id, name, expenses_id, income_id, year_id FROM months left join year y on y.id = months.year_id where y.id=?", Month.class)
                .setParameter(1, year)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return allMonth;
    }

    @Override
    public void addMonth(Month month,Long idYear) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Year year = session.get(Year.class, idYear);
        System.out.println(year);
        year.addMonth(month);
        month.setYear(year);
        session.update(year);
        session.getTransaction().commit();
        session.close();
    }
}

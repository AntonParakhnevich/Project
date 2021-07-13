package Project.DAO;

import Project.Entity.Family;
import Project.Util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class ImplDaoFamily implements FamilyDAO {

    @Override
    public void save(Family family) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(family);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Family get(Long id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Family family = session.get(Family.class, id);
        session.getTransaction().commit();
        session.close();
        return family;
    }

    @Override
    public void change(Long id, String name) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Family family = session.get(Family.class, id);
        family.setLogin(name);
        session.update(family);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Boolean findLoginAndPassword(String login, String password) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        List<Family> resultList = session.createNativeQuery("SELECT * from family where login=? && password=?; ", Family.class)
                .setParameter(1, login)
                .setParameter(2, password)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return !resultList.isEmpty();

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
    public Family getByLoginAndPassword(String login, String password) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        List<Family> resultList = session.createNativeQuery("SELECT * from family where login=? && password=?", Family.class)
                .setParameter(1, login)
                .setParameter(2, password)
                .getResultList();
        return resultList.get(0);
    }
}

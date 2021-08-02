package Project.Service;

import Project.DAO.ImplDaoFamily;
import Project.Entity.Family;

import java.sql.SQLException;

/**
 * Created by .
 */
public class FamilyService {
    ImplDaoFamily implDaoFamily = new ImplDaoFamily();

    public void save(Family family) { // name createFamily
        try {
            implDaoFamily.save(family);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Family getFamily(Long id) {
        Family family = null;
        try {
            family = implDaoFamily.get(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return family;
    }

    public void deleteFamily(Long id) {
        try {
            implDaoFamily.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void changeLastname(String lastname, Long id) {
        try {
            implDaoFamily.change(id, lastname);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean findLoginAndPassword(String login, String password) { // name isFamilyExist or familyExists
        boolean family = false;
        try {
            family = implDaoFamily.findLoginAndPassword(login, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return family;
    }

    public Family getByLoginAndPassword(String login, String password) { // getFamily(preferable, you can just overload this method), getFamilyByCredentials, getFamilyByLoginAndPassword
        Family family = null;
        try {
            family = implDaoFamily.getByLoginAndPassword(login, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return family;
    }


}

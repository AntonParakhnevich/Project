package Project.Service;

import Project.DAO.ImplDaoYear;
import Project.Entity.CategoryCost;
import Project.Entity.Month;
import Project.Entity.Year;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class YearService {
    ImplDaoYear implDaoYear = new ImplDaoYear();

    public void saveYear(Year year) {
        try {
            implDaoYear.save(year);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteYear(Long id) {
        try {
            implDaoYear.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Year getYear(Long id) {
        Year year = null;
        try {
            year = implDaoYear.get(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return year;
    }

    public List<Month> getAllMonth(Long year) {
        return implDaoYear.getAllMonth(year);
    }

    public List<Year> getAllYears(String lastnameFamily){
        return implDaoYear.getAllYear(lastnameFamily);
    }

    public void addMonth(Month month,Long idYear){
        try {
            implDaoYear.addMonth(month,idYear);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
